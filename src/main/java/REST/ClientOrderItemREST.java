package REST;

import DAO.ClientItemDAO;
import VO.ClientOrderItemsVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Path("/clientorderitem")
public class ClientOrderItemREST {
    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientOrderItemsVOList() {
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        List<ClientOrderItemsVO> list = clientItemDAO.getClientOrderItemsVOList();

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client order items found")).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/quantity/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientOrderItemsVOListByQuantity(@PathParam("param") int _quantity) {
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        List<ClientOrderItemsVO> list = clientItemDAO.getClientOrderItemsVOListByQuantity(_quantity);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client order items found with quantity = " + _quantity)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Path("/clientOrder/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientOrderItemsVOListByClientOrderID(@PathParam("param") int _client_order_id) {
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        List<ClientOrderItemsVO> list = clientItemDAO.getClientOrderItemsVOListByClientOrderID(_client_order_id);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client order items found with Client Order Id = " + _client_order_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/drug/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientOrderItemsVOListByDrugID(@PathParam("param") int _drug_id) {
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        List<ClientOrderItemsVO> list = clientItemDAO.getClientOrderItemsVOListByDrugID(_drug_id);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Client order items found with Drug Id = " + _drug_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Path("/delete/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClientOrderItemById(@PathParam("param") int _client_order_item_id) {
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        clientItemDAO.deleteById(_client_order_item_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _client_order_item_data) {
        ClientOrderItemsVO clientOrderItemsVO = gson.fromJson(_client_order_item_data, ClientOrderItemsVO.class);
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        clientItemDAO.update(clientOrderItemsVO, clientOrderItemsVO.getId());
        return Response.ok().build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertClientOrderItem(String clientOrderItemData) {
        ClientOrderItemsVO clientOrderItemsVO = gson.fromJson(clientOrderItemData, ClientOrderItemsVO.class);
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        clientItemDAO.insert(clientOrderItemsVO);
        return Response.ok().build();
    }


    @POST
    @Path(("/post/list"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertClientOrderItemList(String clientOrderItemListData) {
        Type list_type = new TypeToken<ArrayList<ClientOrderItemsVO>>() {
        }.getType();
        List<ClientOrderItemsVO> list = gson.fromJson(clientOrderItemListData, list_type);
        ClientItemDAO clientItemDAO = new ClientItemDAO();
        list.forEach(clientOrderItemsVO -> clientItemDAO.insert(clientOrderItemsVO));
        return Response.ok(gson.toJson(list.size() + " number of Clients order items inserted Successfully"), MediaType.APPLICATION_JSON).build();
    }


}
