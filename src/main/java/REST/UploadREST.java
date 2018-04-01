package REST;


import DAO.DrugDAO;
import DAO.FilesDAO;
import DAO.Global.DBOperationDAO;
import DAO.SupplierDAO;
import DAO.UserDAO;
import VO.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.Hibernate;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.List;

@Path("/upload")
public class UploadREST {

    static final Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();

    @POST
    @Path("/file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "/home/tarang/Desktop/Umlet/" + fileDetail.getFileName();

        // save it
        //writeToFile(uploadedInputStream, uploadedFileLocation);
        savetoDatabase(uploadedInputStream,fileDetail);
        String output = "File uploaded to : " + uploadedFileLocation;

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/file/supplier/id/{param}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadSupplierDocument(@FormDataParam("file") InputStream uploadInputStream,
                                           @FormDataParam("file") FormDataContentDisposition fileDetail, @PathParam("param") int _supplier_id){
        return savetoSupplierDocument(uploadInputStream,fileDetail,_supplier_id);



    }

    @POST
    @Path("/file/drug/id/{param}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadDrugDocument(@FormDataParam("file") InputStream uploadInputStream,
                                       @FormDataParam("file") FormDataContentDisposition fileDetail, @PathParam("param") int _drug_id) {

        return savetoDrugDocument(uploadInputStream,fileDetail,_drug_id);
    }

    private Response savetoDrugDocument(InputStream uploadInputString,FormDataContentDisposition info,int _drug_id) {
        DrugDAO drugDAO = new DrugDAO();
        List<DrugVO> list = drugDAO.getDrugVOListByDrugId(_drug_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Supplier Present with id = " + _drug_id)).build();
        } else {
            DrugVO drugVO = list.get(0);

            DBOperationDAO dbOperationDAO = new DBOperationDAO();
            dbOperationDAO.openCurrentSessionWithTransaction();

            DrugDocumentVO drugDocumentVO = new DrugDocumentVO();
            drugDocumentVO.setDrugVO(drugVO);

            Blob blob = Hibernate.getLobCreator(dbOperationDAO.getCurrentSession())
                    .createBlob(uploadInputString, info.getSize());
            drugDocumentVO.setDocument(blob);
            dbOperationDAO.insert(drugDocumentVO);


            dbOperationDAO.closeCurrentSessionWithTransaction();

            return Response.ok(gson.toJson("Drug Document Inserted")).build();


        }
    }


    private Response savetoSupplierDocument(InputStream uploadInputString,FormDataContentDisposition info,int _supplier_id){

        SupplierDAO supplierDAO = new SupplierDAO();
        List<SupplierVO> list  = supplierDAO.getSupplierVOListBySupplierID(_supplier_id);
        if(list.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Supplier Present with id = "+_supplier_id)).build();
        }else{
            SupplierVO supplierVO = list.get(0);

            DBOperationDAO dbOperationDAO = new DBOperationDAO();
            dbOperationDAO.openCurrentSessionWithTransaction();

            SupplierDocumentVO supplierDocumentVO = new SupplierDocumentVO();
            supplierDocumentVO.setSupplierVO(supplierVO);

            Blob blob = Hibernate.getLobCreator(dbOperationDAO.getCurrentSession())
                        .createBlob(uploadInputString,info.getSize());
            supplierDocumentVO.setDocument(blob);
            dbOperationDAO.insert(supplierDocumentVO);


            dbOperationDAO.closeCurrentSessionWithTransaction();

            return Response.ok(gson.toJson("Supplier Document Inserted")).build();
        }


    }
    private void savetoDatabase(InputStream uploadInputString,FormDataContentDisposition info){
        DBOperationDAO dbOperationDAO = new DBOperationDAO();
        dbOperationDAO.openCurrentSessionWithTransaction();
        FilesVO filesVO = new FilesVO();
        filesVO.setUserVO(new UserDAO().load(1));
        Blob blob = Hibernate.getLobCreator(dbOperationDAO.getCurrentSession())
                .createBlob(uploadInputString, info.getSize());
        filesVO.setFile(blob);
        dbOperationDAO.insert(filesVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();


    }

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
                             String uploadedFileLocation) {

        try {
            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}
