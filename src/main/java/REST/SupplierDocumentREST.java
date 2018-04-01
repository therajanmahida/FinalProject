package REST;

import DAO.SupplierDocumentDAO;
import VO.SupplierDocumentVO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Path("/supplierdocument")
public class SupplierDocumentREST {

    @GET
    @Path("/supplier/{param}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getDocument(@PathParam("param") int _supplier_id) throws SQLException {
        SupplierDocumentDAO supplierDocumentDAO = new SupplierDocumentDAO();
        List<SupplierDocumentVO> list  = supplierDocumentDAO.getDocumentBySupplierID(_supplier_id);
        return Response.ok().entity(list.get(0).getDocument().getBytes(1,(int)list.get(0).getDocument().length())).type(MediaType.APPLICATION_OCTET_STREAM).header("content-disposition","attachment; filename = image.pdf").build();

    }
}
