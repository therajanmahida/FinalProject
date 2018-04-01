package REST;

import DAO.CompanyDAO;
import DAO.MessageDAO;
import DAO.MessageToDAO;
import DAO.UserDAO;
import VO.CompanyVO;
import VO.MessageToVO;
import VO.MessageVO;
import VO.UserVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/messageto")
public class MessageToREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageToVOList(){
        MessageToDAO messageToDAO = new MessageToDAO();
        List<MessageToVO> list = messageToDAO.getMessageToVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No message present").build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }
    @POST
    @Path("/company/id/{param1}/userto/{param2}/userfrom/{param3}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertMessage(@PathParam("param1") int _company_id,@PathParam("param2") String userToName,@PathParam("param3") String userFromName,String _message_content){
        MessageToVO messageToVO = gson.fromJson(_message_content,MessageToVO.class);
        CompanyDAO companyDAO = new CompanyDAO();
        List<CompanyVO> list  = companyDAO.getCompanyById(_company_id);
        if(list.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity("You are not associated with the company.").build();
        } else{
            UserDAO userDAO = new UserDAO();
            List<UserVO> userVOList = userDAO.getUserWithUserName(userToName);
            if(userVOList.size() == 0){
                return Response.status(Response.Status.NOT_FOUND).entity("Invalid Email-Id unable to deliver mail.").build();
            }else{
                MessageVO messageVO = messageToVO.getMessageVO();
                messageVO.setMessageTime(new Date());
                messageVO.setMessageDate(new Date());
                messageVO.setCompanyVO(list.get(0));
                new MessageDAO().insert(messageVO);

                messageToVO.setMessageVO(messageVO);
                messageToVO.setUserTo(userDAO.getUserWithUserName(userToName).get(0));
                messageToVO.setUserFrom(userDAO.getUserWithUserName(userFromName).get(0));
                messageToVO.setIsRead(0);

                MessageToDAO messageToDAO = new MessageToDAO();
                messageToDAO.insert(messageToVO);

                return Response.ok(gson.toJson("Message Sent")).build();


            }
        }




    }

    @GET
    @Path("/delete/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMessage(@PathParam("param") int _message_id){
        MessageToDAO messageToDAO = new MessageToDAO();
        messageToDAO.deleteById(_message_id);
        return Response.ok(gson.toJson("Message deleted Successfully"),MediaType.APPLICATION_JSON).build();
        
    }

}
