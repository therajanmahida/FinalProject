package REST;

import DAO.ClientDAO;
import DAO.Global.DBOperationDAO;
import VO.ClientVO;
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

@Path("/client")
public class ClientREST {

    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getClientVOList() {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present")).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param}")
    public Response getClientVOListByCompany(@PathParam("param") int _company_id) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByCompany(_company_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/name/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientVOListByCompanyAndName(@PathParam("param1") int _company_id, @PathParam("param2") String name) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByName(_company_id, name);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id + " and name = " + name)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/gst/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientVOListByCompanyAndGstNumber(@PathParam("param1") int _company_id, @PathParam("param2") String gstNumber) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByGstNumber(_company_id, gstNumber);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id + " and gstNumber = " + gstNumber)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/contact/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientVOListByCompanyAndContact(@PathParam("param1") int _company_id, @PathParam("param2") String contactNumber) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByContactNumber(_company_id, contactNumber);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id + " and contactNumber = " + contactNumber)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/email/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientVOListByCompanyAndEmail(@PathParam("param1") int _company_id, @PathParam("param2") String email) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByEmailId(_company_id, email);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id + " and emailid = " + email)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/state/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientVOListByCompanyAndState(@PathParam("param1") int _company_id, @PathParam("param2") String state) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByState(_company_id, state);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id + " and State = " + state)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param1}/city/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientVOListByCompanyAndCity(@PathParam("param1") int _company_id, @PathParam("param2") String city) {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientVO> list = clientDAO.getClientVOListByCity(_company_id, city);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client present for Company with id = " + _company_id + " and City = " + city)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/delete/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClientById(@PathParam("param") int _client_id) {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.deleteById(_client_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _client_data) {
        ClientVO clientVO = gson.fromJson(_client_data, ClientVO.class);
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.update(clientVO, clientVO.getId());
        return Response.ok().build();
    }

    @POST
    @Path("/post/company/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertClientForCompany(@PathParam("param") int _company_id, String clientData) {
        DBOperationDAO dbOperationDAO = new DBOperationDAO();
        dbOperationDAO.openCurrentSession();
        List<CompanyVO> list = dbOperationDAO.getList("from VO.CompanyVO where id=" + _company_id);
        dbOperationDAO.closeCurrentSession();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Company with company id = " + _company_id)).build();
        }
        CompanyVO companyVO = list.get(0);
        ClientVO clientVO = gson.fromJson(clientData, ClientVO.class);
        clientVO.setCompanyVO(companyVO);

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(clientVO);

        return Response.ok().build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertClient(String clientData) {
        ClientVO clientVO = gson.fromJson(clientData, ClientVO.class);
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(clientVO);
        return Response.ok().build();
    }

    @POST
    @Path(("/post/list"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertClientList(String clientListDate) {
        Type list_type = new TypeToken<ArrayList<ClientVO>>() {
        }.getType();
        List<ClientVO> list = gson.fromJson(clientListDate, list_type);
        ClientDAO clientDAO = new ClientDAO();
        list.forEach(clientVO -> clientDAO.insert(clientVO));
        return Response.ok(gson.toJson(list.size() + " number of Clients inserted Successfully"), MediaType.APPLICATION_JSON).build();
    }

}
