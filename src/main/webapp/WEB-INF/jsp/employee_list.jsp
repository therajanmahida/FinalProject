<!--Created by IntelliJ IDEA.
User: root
Date: 13/3/18
Time: 10:34 PM
To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="metaHeaders/metaHeader.jsp"></jsp:include>

    <title>Employee List</title>

    <jsp:include page="cssHeader/globalSheetStyles.jsp"></jsp:include>

    <jsp:include page="scriptHeader/coreJsFile.jsp"></jsp:include>

    <jsp:include page="scriptHeader/employee_list_theme.jsp"></jsp:include>

        <script type="text/javascript">
            $(document).ready(function () {
                    var tab = $('#staff')
                    tab.addClass('active');
                    var tab = $('#employee_list')
                    tab.addClass('active');
                    var tab = $('#staffblock');
                    tab.css('display', 'block');


                $.fn.extend({
                    getEmployee : function (id) {
                        var employee;
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            async: false,
                            url: "${pageContext.request.contextPath}/rest/employee/id/"+id,
                            success: function(data){
                                employee = data;
                            },
                            complete: function () {

                            }
                        });

                        return employee;
                    }
                });


                    $('#modal_form_vertical').on('show.bs.modal', function(e) {

                        var employee_id = e.relatedTarget.id;
                        var employee = $.fn.getEmployee(employee_id);
                        var employeeString = JSON.stringify(employee);
                        $('#form_name').val(employee["employeeName"]);
                        $('#form_desingation option').each(function () {
                            if(employee["designation"] === $(this).val()){
                                $(this).attr("selected");
                            }else{
                                $(this).removeAttr('selected');
                            }
                        })
                    });


                });




        </script>
</head>

<body>

<jsp:include page="NavigationHeader/topNavigationBar.jsp"></jsp:include>


<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <jsp:include page="SideBar/sideBar.jsp"></jsp:include>

        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Page header -->
            <div class="page-header page-header-default">
                <div class="page-header-content">
                    <div class="page-title">
                        <h4><i class="icon-arrow-left52 position-left"></i> <span class="text-semibold">Employee-List</span></h4>
                    </div>

                    <div class="heading-elements">
                        <div class="heading-btn-group">
                            <a href="#" class="btn btn-link btn-float has-text"><i class="icon-bars-alt text-primary"></i><span>Statistics</span></a>
                            <a href="#" class="btn btn-link btn-float has-text"><i class="icon-calculator text-primary"></i> <span>Invoices</span></a>
                            <a href="#" class="btn btn-link btn-float has-text"><i class="icon-calendar5 text-primary"></i> <span>Schedule</span></a>
                        </div>
                    </div>
                </div>

                <jsp:include page="NavigationHeader/breadCrumbLine.jsp"></jsp:include>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Basic datatable -->
                <div class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Employee List</h5>
                        <div class="heading-elements">
                            <ul class="icons-list">
                                <li><a data-action="collapse"></a></li>
                                <li><a data-action="reload"></a></li>
                                <li><a data-action="close"></a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="panel-body">
                        The <code>DataTables</code> is a highly flexible tool, based upon the foundations of progressive enhancement, and will add advanced interaction controls to any HTML table. DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function. Searching, ordering, paging etc goodness will be immediately added to the table, as shown in this example. <strong>Datatables support all available table styling.</strong>
                    </div>

                    <table class="table datatable-button-print-columns">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Designation</th>
                            <th>Contact #1</th>
                            <th>Department</th>
                            <th>Outlet</th>
                            <th>Address</th>
                            <th class="text-center">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${employee_list}" var="employee">
                                <input type="text" value="${employee.id}" style="display: none">
                                <tr>
                                    <td>${employee.employeeName}</td>
                                    <c:if test="${employee.designation eq 'HEAD'}">
                                        <td><span class="label label-primary">${employee.designation}</span></td>
                                    </c:if>
                                    <c:if test="${employee.designation eq 'SENIOR'}">
                                        <td><span class="label label-info">${employee.designation}</span></td>
                                    </c:if>
                                    <c:if test="${employee.designation eq 'JUNIOR'}">
                                        <td><span class="label label-success">${employee.designation}</span></td>
                                    </c:if>
                                    <td>${employee.contactNumberOne}</td>
                                    <td>
                                    <c:forEach items="${employee.departmentVO}" var="department">
                                        <span class="label label-info">${department.departmentName}</span>
                                    </c:forEach>
                                    </td>
                                    <td>${employee.outletVO.outletName}</td>
                                    <td>${employee.address}</td>
                                    <td class="text-center">
                                        <ul class="icons-list">
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                    <i class="icon-menu9"></i>
                                                </a>

                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li class="update"><button id="${employee.id}" class="btn btn-link" data-toggle="modal" data-target="#modal_form_vertical"><i class="icon-file-upload"></i> Update</button> </li>
                                                    <li><a href="#"><i class="icon-file-pdf"></i> Export to .pdf</a></li>
                                                    <li><a href="#"><i class="icon-file-excel"></i> Export to .csv</a></li>
                                                    <li><a href="#"><i class="icon-file-word"></i> Export to .doc</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /basic datatable -->

                <!-- Vertical form modal -->
                <div id="modal_form_vertical" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h5 class="modal-title">Vertical form</h5>
                            </div>

                            <form action="#">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label>Employee-Name<span class="text-danger">*</span> </label>
                                                <input id="form_name" type="text" placeholder="Enter Name" class="form-control">
                                            </div>

                                            <div class="form-group col-sm-6">
                                                <label>Default select</label>
                                                <select id ="form_desingation" class="bootstrap-select" data-width="100%">
                                                    <option value="HEAD">HEAD</option>
                                                    <option value="SENIOR">SENIOR</option>
                                                    <option value="JUNIOR">JUNIOR</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label>Address line 1</label>
                                                <input type="text" placeholder="Ring street 12" class="form-control">
                                            </div>

                                            <div class="col-sm-6">
                                                <label>Address line 2</label>
                                                <input type="text" placeholder="building D, flat #67" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <label>City</label>
                                                <input type="text" placeholder="Munich" class="form-control">
                                            </div>

                                            <div class="col-sm-4">
                                                <label>State/Province</label>
                                                <input type="text" placeholder="Bayern" class="form-control">
                                            </div>

                                            <div class="col-sm-4">
                                                <label>ZIP code</label>
                                                <input type="text" placeholder="1031" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label>Email</label>
                                                <input type="text" placeholder="eugene@kopyov.com" class="form-control">
                                                <span class="help-block">name@domain.com</span>
                                            </div>

                                            <div class="col-sm-6">
                                                <label>Phone #</label>
                                                <input type="text" placeholder="+99-99-9999-9999" data-mask="+99-99-9999-9999" class="form-control">
                                                <span class="help-block">+99-99-9999-9999</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Submit form</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /vertical form modal -->





                <!-- Footer -->
                <div class="footer text-muted">
                    &copy; 2015. <a href="#">Limitless Web App Kit</a> by <a href="http://themeforest.net/user/Kopyov" target="_blank">Eugene Kopyov</a>
                </div>
                <!-- /footer -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>
</html>
