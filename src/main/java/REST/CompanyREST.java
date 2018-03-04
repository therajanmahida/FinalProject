package REST;

import DAO.CompanyDAO;
import VO.CompanyVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



@Path("/company")
public class CompanyREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getCompanyList(){
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list = companyDAO.getCompanyVOList();
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Company present").build();
        }else{


            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{param}")
    public Response getCompanyListByName(@PathParam("param") String _company_name) {
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list = companyDAO.getCompanyVOListByName(_company_name);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Company present").build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gst/{param}")
    public Response getCompanyListByGst(@PathParam("param") String _gst_number) {
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list = companyDAO.getCompanyVOListByGst(_gst_number);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Company present").build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/email/{param}")
    public Response getCompanyListByEmail(@PathParam("param") String _company_email) {
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list = companyDAO.getCompanyVOListByEmail(_company_email);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Company present").build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contact/{param}")
    public Response getCompanyListByContactNumber(@PathParam("param") String _company_contact) {
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list = companyDAO.getCompanyVOListByContactNumber(_company_contact);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Company present").build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCompany(String _inputdata) {
        CompanyVO companyVO = gson.fromJson(_inputdata,CompanyVO.class);
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.insert(companyVO);
        return Response.ok().build();
    }

    @POST
    @Path("/post/list")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCompanyList(String _inputdata){
        Type listType = new TypeToken<ArrayList<CompanyVO>>(){}.getType();
        List<CompanyVO> companyVOList = gson.fromJson(_inputdata,listType);
        CompanyDAO companyDAO = new CompanyDAO();
        for (CompanyVO companyVO : companyVOList) {
            companyDAO.insert(companyVO);
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{param}")
    public Response deleteCompany(@PathParam("param") int _company_id){
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.deleteById(_company_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _company_data){
        CompanyVO companyVO = gson.fromJson(_company_data,CompanyVO.class);
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.update(companyVO,companyVO.getId());
        return Response.ok().build();
    }




}
