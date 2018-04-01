package REST;

import DAO.MessageDAO;
import VO.MessageVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/message")
public class MessageREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageVOList(){
        MessageDAO messageDAO = new MessageDAO();
        List<MessageVO> list = messageDAO.getMessageVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Message present")).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Path("/company/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageVOListByCompanyId(@PathParam("param") int _company_id){
        MessageDAO messageDAO = new MessageDAO();
        List<MessageVO> list = messageDAO.getMessageVOListByCompanyId(_company_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Message present for company with id = "+_company_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/date/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageVOListByDate(@PathParam("param") String date_input,@PathParam("param1") int _company_id){
        Gson modified_gson = new GsonBuilder().setDateFormat("ddMMyyyy").create();
        Date date = gson.fromJson(date_input,Date.class);
        MessageDAO messageDAO = new MessageDAO();
        List<MessageVO> list = messageDAO.getMessageVOListByDate(_company_id,date);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(modified_gson.toJson("No Message present for company with id = "+_company_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }






}
