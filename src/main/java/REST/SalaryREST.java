package REST;

import DAO.SalaryDAO;
import VO.SalaryVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/salary")
public class SalaryREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getSalaryList(){
        SalaryDAO salaryDAO = new SalaryDAO();
        List<SalaryVO> list = salaryDAO.getSalarVOList();
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Salary present").build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }


}
