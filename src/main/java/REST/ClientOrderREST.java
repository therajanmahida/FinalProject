package REST;

import DAO.ClientOrderDAO;
import DAO.Global.DBOperationDAO;
import VO.ClientOrderVO;
import VO.CompanyVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/clientorder")
public class ClientOrderREST {

    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getClientOrderVOList() {
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOList();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder present")).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param}")
    public Response getClientOrderVOListByCompany(@PathParam("param") int _company_id) {
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByCompany(_company_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder with company id = " + _company_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/client/id/{param2}")
    public Response getClientOrderVOListByCompanyAndClient(@PathParam("param1") int _company_id, @PathParam("param2") int _client_id) {
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByClient(_company_id, _client_id);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder with company id = " + _company_id + " and client id=" + _client_id)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/orderDate/{param2}")
    public Response getClientOrderVOListByCompanyAndOrder(@PathParam("param1") int _company_id, @PathParam("param2") String dateinput) {
        final Date orderDate = new GsonBuilder().setDateFormat("ddMMyyyy").create().fromJson(dateinput, Date.class);

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByOrderDate(_company_id, orderDate);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder with company id = " + _company_id + " and OrderDate =" + orderDate.toString())).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/deliverydate/{param2}")
    public Response getClinetOrderVOListByCompanyAndDelivery(@PathParam("param1") int _company_id, @PathParam("param2") String dateinput) {
        final Date deliveryDate = new GsonBuilder().setDateFormat("ddMMyyyy").create().fromJson(dateinput, Date.class);

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByDeliveryDate(_company_id, deliveryDate);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder with company id = " + _company_id + " and DeliveryDate =" + deliveryDate.toString())).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/dispatchdate/{param2}")
    public Response getClinetOrderVOListByCompanyAndDispatch(@PathParam("param1") int _company_id, @PathParam("param2") String dateinput) {
        final Date dispatchDate = new GsonBuilder().setDateFormat("ddMMyyyy").create().fromJson(dateinput, Date.class);

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClinetOrderVOListByDispatchDate(_company_id, dispatchDate);
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder with company id = " + _company_id + " and DispatchDate =" + dispatchDate.toString())).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/paymentstatus/{param2}")
    public Response getClientOrderVOListByPaymentstStatus(@PathParam("param1") int _company_id, @PathParam("param2") String paymentStatus) {
        ClientOrderVO.PaymentStatus paymentStatus1 = gson.fromJson(paymentStatus, ClientOrderVO.PaymentStatus.class);

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByPaymentstStatus(_company_id, paymentStatus1);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClientOrder with company id = " + _company_id + " and PaymentStatus =" + paymentStatus1.toString())).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/sellAmount/{param2}")
    public Response getClientOrderVOListBySellAmount(@PathParam("param1") int _company_id, @PathParam("param2") double sellAmount) {
        Double sellAmountDouble = /*gson.fromJson(sellAmount, Double.class);*/ sellAmount;

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListBySellAmount(_company_id, sellAmountDouble);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClinetOrder with company id = " + _company_id + " and sellamount = " + sellAmountDouble)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/taxamount/{param2}")
    public Response getClientOrderVOListByTaxAmount(@PathParam("param1") int _company_id, @PathParam("param2") String TaxAmount) {
        Double taxAmountDouble = gson.fromJson(TaxAmount, Double.class);

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByTaxAmount(_company_id, taxAmountDouble);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClinetOrder with company id = " + _company_id + " and TaxAmount = " + taxAmountDouble)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/company/id/{param1}/profitmargin/{param2}")
    public Response getClientOrderVOListByProfitMargin(@PathParam("param1") int _company_id, @PathParam("param2") String ProfitMargin) {
        Double profitMarginDouble = gson.fromJson(ProfitMargin, Double.class);

        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        List<ClientOrderVO> list = clientOrderDAO.getClientOrderVOListByProfitMargin(_company_id, profitMarginDouble);

        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No ClinetOrder with company id = " + _company_id + " and ProfitMargin = " + profitMarginDouble)).build();
        } else {
            return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post")
    public Response insertClientOrder(String inputDate) {
        ClientOrderVO clientOrderVO = gson.fromJson(inputDate, ClientOrderVO.class);
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        clientOrderDAO.insert(clientOrderVO);
        return Response.ok(gson.toJson("Client order inserted."), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post/list")
    public Response insertClientOrderList(String inputData) {
        Type list_type = new TypeToken<ArrayList<ClientOrderVO>>() {
        }.getType();
        List<ClientOrderVO> list = gson.fromJson(inputData, list_type);
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        list.forEach(clientOrderVO -> {
            clientOrderDAO.insert(clientOrderVO);
        });
        return Response.ok(gson.toJson(list.size() + " clinetOrder inserted"), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post/company/id/{param}")
    public Response insertClinetOrderByCompany(@PathParam("param") int _company_id, String inputData) {
        DBOperationDAO dbOperationDAO = new DBOperationDAO();
        dbOperationDAO.openCurrentSession();
        List<CompanyVO> list = dbOperationDAO.getList("from VO.CompanyVO where id=" + _company_id);
        dbOperationDAO.closeCurrentSession();
        if (list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Company with company id = " + _company_id)).build();
        }

        CompanyVO companyVO = list.get(0);
        ClientOrderVO clientOrderVO = gson.fromJson(inputData, ClientOrderVO.class);
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        clientOrderVO.setCompanyVO(companyVO);
        clientOrderDAO.insert(clientOrderVO);

        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClientOrder(String _client_order_data) {
        ClientOrderVO clientOrderVO = gson.fromJson(_client_order_data, ClientOrderVO.class);
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        clientOrderDAO.update(clientOrderVO, clientOrderVO.getId());
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{param}")
    public Response deleteClientOrder(@PathParam("param") int _clinet_order_id) {
        ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
        clientOrderDAO.deleteById(_clinet_order_id);
        return Response.ok().build();
    }


}
