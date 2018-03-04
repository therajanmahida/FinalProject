package REST;

import DAO.DepartmentDAO;
import VO.DepartmentVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Path("/department")
public class DepartmentREST
{
    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentList(){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<DepartmentVO> list = departmentDAO.getDepartmentVOList();
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Company present").build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/name/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentListByName(@PathParam("param") String _name){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<DepartmentVO> list = departmentDAO.getDepartmentVOListByName(_name);
        if(list.size()==0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No department with name "+_name+" found.")).build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentListByCompany(@PathParam("param") int  _company_id){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<DepartmentVO> list = departmentDAO.getDepartmentVOListByCompanyId(_company_id);
        if(list.size()==0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No department with name "+_company_id+" found.")).build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path(("/post"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertDepartment(String _inputdata){
        DepartmentVO departmentVO = gson.fromJson(_inputdata,DepartmentVO.class);
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.insert(departmentVO);
        return Response.ok().build();
    }

    @POST
    @Path("/post/list")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertDepartemntList(String _inputdata){
        Type listType = new TypeToken<ArrayList<DepartmentVO>>(){}.getType();
        List<DepartmentVO> departmentVOList = gson.fromJson(_inputdata,listType);
        DepartmentDAO departmentDAO = new DepartmentDAO();
        for (DepartmentVO departmentVO : departmentVOList) {
            departmentDAO.insert(departmentVO);
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{param}")
    public Response deleteDepartment(@PathParam("param") int _department_id){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.deleteById(_department_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _department_data){
        DepartmentVO departmentVO = gson.fromJson(_department_data,DepartmentVO.class);
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.update(departmentVO,departmentVO.getId());
        return Response.ok().build();
    }

}
