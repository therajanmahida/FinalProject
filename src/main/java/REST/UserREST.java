package REST;

import DAO.UserDAO;
import VO.UserVO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getAllUserList(){

        UserDAO userDAO = new UserDAO();
        List<UserVO> _list = userDAO.getUserList();
        if(_list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity("No user present").build();
        }else{
            return Response.ok(_list,MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/username/{param}")
    public Response getUser(@PathParam("param") String username) {
        if(username.trim().length() == 0) {
            return Response.serverError().entity("UUID cannot be blank").build();
        }
        UserDAO userDAO = new UserDAO();
        List<UserVO> _list = userDAO.getUserWithUserName(username);
        if(_list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(_list.get(0), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{param}")
    public Response getUserWithID(@PathParam("param") int _user_id) {

       // int user_id = Integer.parseInt(_user_id);
        UserDAO userDAO = new UserDAO();
        List<UserVO> _list = userDAO.getUserWithUserId(_user_id);
        if(_list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(_list.get(0), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUser(UserVO userVO) {

        UserDAO userDAO = new UserDAO();
        userDAO.insert(userVO);
        return Response.ok().build();

    }

    @DELETE
    @Path("/delete/{param}")
    public Response deleteUser(@PathParam("param") int _user_id){
        UserDAO userDAO = new UserDAO();
        userDAO.deleteById(_user_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(UserVO userVO){
        UserDAO userDAO = new UserDAO();
        userDAO.update(userVO,userVO.getId());
        return Response.ok().build();
    }



}

