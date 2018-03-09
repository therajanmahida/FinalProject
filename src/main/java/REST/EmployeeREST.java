package REST;


import DAO.EmployeeDAO;
import DAO.Global.DBOperationDAO;
import VO.CompanyVO;
import VO.DepartmentVO;
import VO.EmployeeVO;
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
import java.util.stream.Collectors;

@Path("/employee")
public class EmployeeREST {

    static final Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeList(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOList();
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Employee present")).build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/name/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByName(@PathParam("param") String _employee_name){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByName(_employee_name);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Employee found with name "+_employee_name+" found.")).build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/designation/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByDesignation(@PathParam("param") EmployeeVO.Designation _designation){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByDesignation(_designation);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Employee found with designation "+_designation.toString()+" found.")).build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByCompanyId(@PathParam("param") int _company_id){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByCompany(_company_id);
        if(list.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Employee found with company id = "+_company_id+" found.")).build();
        }else{
            return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/company/id/{param}/quantity")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeQuantity(@PathParam("param") int _company_id){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int _quant = employeeDAO.getEmployeeQuantity(_company_id);
        return Response.ok(gson.toJson(new Integer(_quant)),MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/company/id/{param}/department/id/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByDepartment(@PathParam("param") int _company_id,@PathParam("param2") int _department_id){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByCompany(_company_id);
        if(list.size()==0){
           return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee with company id = "+_company_id)).build();
        }
        final int _dept_id = _department_id;
        List<EmployeeVO> list_send = list.stream().filter(employeeVO -> {
                                            for(DepartmentVO departmentVO : employeeVO.getDepartmentVO()){
                                                if(departmentVO.getId() == _dept_id)
                                                    return true;
                                            }
                                            return false;
                                        }).collect(Collectors.toList());
        if(list_send.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee working in this department")).build();
        }else{
            return Response.ok(gson.toJson(list_send)).build();
        }
    }

    @GET
    @Path("/company/id/{param}/outlet/id/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByOutlet(@PathParam("param") int _company_id , @PathParam("param2") int _outlet_id){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByCompany(_company_id);
        if(list.size()==0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee with company id = "+_company_id)).build();
        }
        final int _out_id = _outlet_id;
        List<EmployeeVO> list_send = list.stream().filter(employeeVO -> {
                                                            if (employeeVO.getOutletVO()==null)
                                                                return false;
                                                            if(employeeVO.getOutletVO().getId() == _out_id)
                                                                return true;
                                                            else
                                                                return false;
                                                        }).collect(Collectors.toList());
        if(list_send.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee working in this outlet")).build();
        }else{
            return Response.ok(gson.toJson(list_send)).build();
        }
    }

    @GET
    @Path("/company/id/{param}/workingstatus/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByWorkingStatus(@PathParam("param") int _company_id,@PathParam("param2") EmployeeVO.WorkingStatus _working_status){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByCompany(_company_id);
        if(list.size()==0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee with company id = "+_company_id)).build();
        }
        final EmployeeVO.WorkingStatus workingStatus = _working_status;
        List<EmployeeVO> list_send = list.stream().filter(employeeVO -> {
            return employeeVO.getCurrentStatus().compareTo(workingStatus) == 0;
        }).collect(Collectors.toList());
        if(list_send.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee has status "+workingStatus.toString())).build();
        }else{
            return Response.ok(gson.toJson(list_send)).build();
        }
    }

    @GET
    @Path("/company/id/{param}/joiningdate/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeListByJoiningDate(@PathParam("param") int _company_id,@PathParam("param2") String _date_input){
        final Date _joining_date = new GsonBuilder().setDateFormat("ddMMyyyy").create().fromJson(_date_input,Date.class);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> list = employeeDAO.getEmployeeVOListByCompany(_company_id);
        if(list.size()==0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee with company id = "+_company_id)).build();
        }

        List<EmployeeVO> list_send = list.stream().filter(employeeVO -> employeeVO.getJoiningDate().compareTo(_joining_date) == 0).collect(Collectors.toList());

        if(list_send.size() == 0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No employee has date of joining "+_joining_date.toString())).build();
        }else{
            return Response.ok(gson.toJson(list_send)).build();
        }

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertEmployee(String employeeData){
        EmployeeVO employeeVO = gson.fromJson(employeeData,EmployeeVO.class);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.insert(employeeVO);
        return Response.ok().build();
    }

    @POST
    @Path("/post/list")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertEmployeeList(String employeeDataList){
        Type list_type = new TypeToken<ArrayList<EmployeeVO>>(){}.getType();
        List<EmployeeVO> list = gson.fromJson(employeeDataList,list_type);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        list.forEach(employeeVO -> {
            employeeDAO.insert(employeeVO);
        });
        return Response.ok(gson.toJson(list.size()+" employess inserted"),MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/post/company/id/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertEmployeeInCompany(@PathParam("param") int _company_id,String employeeData){
        DBOperationDAO dbOperationDAO = new DBOperationDAO();
        dbOperationDAO.openCurrentSession();
        List<CompanyVO> list = dbOperationDAO.getList("from VO.CompanyVO where id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        if(list.size()==0){
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("No Company with company id = "+_company_id)).build();
        }
        CompanyVO companyVO = list.get(0);
        EmployeeVO employeeVO = gson.fromJson(employeeData,EmployeeVO.class);
        employeeVO.setComanyVO(companyVO);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.insert(employeeVO);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{param}")
    public Response deleteEmployee(@PathParam("param") int _employee_id){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteById(_employee_id);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String _employee_data){
        EmployeeVO employeeVO = gson.fromJson(_employee_data,EmployeeVO.class);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.update(employeeVO,employeeVO.getId());
        return Response.ok().build();
    }






}
