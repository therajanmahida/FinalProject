package REST;

import Controller.Supplier.Supplier;
import DAO.CompanyDAO;
import DAO.SupplierDAO;
import VO.CompanyVO;
import VO.SupplierVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Path("/supplier")
public class SupplierREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierVOList(){
        SupplierDAO supplierDAO = new SupplierDAO();
        List<SupplierVO> list = supplierDAO.getSupplierVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Supplier present").build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierVOListByCompany(@PathParam("param") int _company_id){
        SupplierDAO supplierDAO = new SupplierDAO();
        List<SupplierVO> list = supplierDAO.getSupplierVOList(_company_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Supplier present with company id="+_company_id).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierById(@PathParam("param") int _supplier_id){
        SupplierDAO supplierDAO = new SupplierDAO();
        List<SupplierVO> list = supplierDAO.getSupplierVOListBySupplierID(_supplier_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Supplier present with supplier id="+_supplier_id).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSupplierData(String input_data){
        SupplierVO supplierVO = gson.fromJson(input_data,SupplierVO.class);
        SupplierDAO supplierDAO = new SupplierDAO();
        Integer id = supplierDAO.insert(supplierVO);
        return Response.ok(gson.toJson(id),MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/post/list")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSupplierDateList(String input_date){
        Type list_type = new TypeToken<ArrayList<SupplierVO>>(){}.getType();
        List<SupplierVO> list = gson.fromJson(input_date,list_type);
        final SupplierDAO supplierDAO = new SupplierDAO();
        list.forEach(supplierVO -> {
            supplierDAO.insert(supplierVO);
        });
        return Response.ok(gson.toJson(list.size()+" Suppliers inserted."),MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/post/company/id/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSupplierByCompanyId(@PathParam("param") int _company_id, String input_date){
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> companyVOList = companyDAO.getCompanyById(_company_id);
        if(companyVOList.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity("No Company found with id = "+_company_id).build();
        }
        CompanyVO companyVO = companyVOList.get(0);

        SupplierVO supplierVO = gson.fromJson(input_date, SupplierVO.class);
        supplierVO.setCompanyVO(companyVO);

        final SupplierDAO supplierDAO = new SupplierDAO();

        Integer id  = supplierDAO.insert(supplierVO);

        return Response.ok(gson.toJson(id),MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/delete/{param}")
    public Response deleteSupplier(@PathParam("param") int _supplier_id){
        SupplierDAO supplierDAO = new SupplierDAO();
        supplierDAO.deleteById(_supplier_id);
        return Response.ok(gson.toJson("Supplier Deleted."),MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSupplier(String inputData){
        SupplierVO supplierVO = gson.fromJson(inputData,SupplierVO.class);
        SupplierDAO supplierDAO = new SupplierDAO();
        supplierDAO.update(supplierVO,supplierVO.getId());
        return Response.ok(gson.toJson("Supplier Updated"),MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/update/company/id/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSupplierByCompany(@PathParam("param") int _company_id ,  String inputData){
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> companyVOList = companyDAO.getCompanyById(_company_id);
        if(companyVOList.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity("No Company found with id = "+_company_id).build();
        }
        CompanyVO companyVO = companyVOList.get(0);

        SupplierVO supplierVO = gson.fromJson(inputData, SupplierVO.class);
        supplierVO.setCompanyVO(companyVO);

        final SupplierDAO supplierDAO = new SupplierDAO();

        supplierDAO.update(supplierVO,supplierVO.getId());

        return Response.ok(gson.toJson(" Supplier updated with id ="+supplierVO.getId()+" ."),MediaType.APPLICATION_JSON).build();

    }




}
