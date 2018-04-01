package REST;

import DAO.CompanyDAO;
import DAO.DrugDAO;
import VO.CompanyVO;
import VO.DrugVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Path("/drug")
public class DrugREST {

    static final Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugVOList(){
        DrugDAO drugDAO = new DrugDAO();
        List<DrugVO> list = drugDAO.getDrugVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Drug present").build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugVOListByCompany(@PathParam("param") int _company_id){
        DrugDAO drugDAO = new DrugDAO();
        List<DrugVO> list = drugDAO.getDrugVOListByCompany(_company_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Drug present with company id = "+_company_id).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}/itemname/{param1}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugVOListByItemName(@PathParam("param") int _company_id,@PathParam("param1") String itemName){
        DrugDAO drugDAO = new DrugDAO();
        List<DrugVO> list = drugDAO.getDrugVOListByItemName(_company_id,itemName);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Drug present with company id = "+_company_id+" and itemName ="+itemName).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}/drugtype/{param1}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugVOListByDrugType(@PathParam("param") int _company_id,@PathParam("param1") String drugType){
        DrugVO.DrugType drugType1 = gson.fromJson(drugType, DrugVO.DrugType.class);
        DrugDAO drugDAO = new DrugDAO();
        List<DrugVO> list = drugDAO.getDrugVOListByDrugType(_company_id,drugType1);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Drug present with company id = "+_company_id+" and drugType ="+drugType1).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}/drugstate/{param1}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugVOListByDrugState(@PathParam("param") int _company_id,@PathParam("param1") String drugType){
        DrugVO.State state = gson.fromJson(drugType, DrugVO.State.class);
        DrugDAO drugDAO = new DrugDAO();
        List<DrugVO> list = drugDAO.getDrugVOListByDrugState(_company_id,state);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Drug present with company id = "+_company_id+" and drugState ="+state).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCompany(String _inputdata) {
        DrugVO drugVO = gson.fromJson(_inputdata, DrugVO.class);
        DrugDAO drugDAO = new DrugDAO();
        Integer id  = drugDAO.insert(drugVO);
        return Response.ok(gson.toJson(id),MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/post/list")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCompanyList(String _inputdata) {
        Type listType = new TypeToken<ArrayList<DrugVO>>() {
        }.getType();
        List<DrugVO> drugVOList = gson.fromJson(_inputdata, listType);
        DrugDAO drugDAO = new DrugDAO();
        for (DrugVO drugVO : drugVOList) {
            drugDAO.insert(drugVO);
        }
        return Response.ok().build();
    }
    @POST
    @Path("/post/company/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCompanyList(@PathParam("param") int _company_id,String inputdata) {

        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list  = companyDAO.getCompanyById(_company_id);
        if(list.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity("No company present").build();
        }
        DrugVO drugVO = gson.fromJson(inputdata,DrugVO.class);
        drugVO.setCompanyVO(list.get(0));

        new DrugDAO().insert(drugVO);

        return Response.ok().build();
    }

    @GET
    @Path("/delete/{param}")
    public Response deleteCompany(@PathParam("param") int _drug_id) {
        DrugDAO drugDAO = new DrugDAO();
        drugDAO.deleteById(_drug_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _company_data) {
        DrugVO drugVO = gson.fromJson(_company_data, DrugVO.class);
        DrugDAO drugDAO = new DrugDAO();
        drugDAO.update(drugVO, drugVO.getId());
        return Response.ok().build();
    }



}
