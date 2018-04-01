package REST;


import DAO.DrugDocumentDAO;
import VO.DrugDocumentVO;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Path("/drugdocument")
public class DrugDocumentREST {

    @GET
    @Path("/drug/{param}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getDocument(@PathParam("param") int _drug_id) throws SQLException {
        DrugDocumentDAO drugDocumentDAO = new DrugDocumentDAO();
        List<DrugDocumentVO> list  = drugDocumentDAO.getDocumentByDrugID(_drug_id);
        return Response.ok().entity(list.get(0).getDocument().getBytes(1,(int)list.get(0).getDocument().length())).type(MediaType.APPLICATION_OCTET_STREAM).header("content-disposition","attachment; filename = image.jpg").build();

    }

}
