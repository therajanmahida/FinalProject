package REST;

import DAO.DepartmentDAO;
import DAO.DocumentDAO;
import DAO.Global.DBOperationDAO;
import VO.DepartmentVO;
import VO.DocumentVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.Doc;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/document")
public class DocumentREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentList() {
        DocumentDAO documentDAO = new DocumentDAO();
        List<DocumentVO> list = documentDAO.getDocumentVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Document present").build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/user/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDocumentListByUserName(@PathParam("param") String username){
        DocumentDAO documentDAO = new DocumentDAO();
        List<DocumentVO> list = documentDAO.getDocumentVOListByUserName(username);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Document present for username: "+username).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postDocument(String document_data){
        DocumentVO documentVO = gson.fromJson(document_data,DocumentVO.class);
        documentVO.setCreationDate(new Date());
        documentVO.setUpdateDate(new Date());
        DocumentDAO documentDAO = new DocumentDAO();
        documentDAO.insert(documentVO);
        return Response.ok(gson.toJson("Document Inserted.")).build();
    }

    @GET
    @Path("/delete/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDocument(@PathParam("param") int _document_id){
        DocumentDAO documentDAO = new DocumentDAO();
        documentDAO.deleteById(_document_id);
        return Response.ok(gson.toJson("Document with id = "+_document_id+" deleted.")).build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _document_data) {
        DocumentVO documentVO = gson.fromJson(_document_data, DocumentVO.class);
        DocumentDAO documentDAO = new DocumentDAO();
        List<DocumentVO> list = documentDAO.getDocumentVOByID(documentVO.getId());
        DocumentVO documentVO1 = list.get(0);
        documentVO.setCreationDate(documentVO1.getCreationDate());
        documentVO.setUpdateDate(new Date());
        documentDAO.update(documentVO, documentVO.getId());
        return Response.ok(gson.toJson("Document Updated")).build();
    }

}

