<%@ page import="VO.BreadCrumbVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="VO.StateCity" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13/3/18
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="metaHeaders/metaHeader.jsp"></jsp:include>

    <title>Employee Registration</title>

    <jsp:include page="cssHeader/globalSheetStyles.jsp"></jsp:include>
    <jsp:include page="scriptHeader/coreJsFile.jsp"></jsp:include>
    <jsp:include page="scriptHeader/employee_registration_theme.jsp"></jsp:include>



    <script type="text/javascript">
        $(document).ready(function () {
            var tab = $('#staff')
            tab.addClass('active');
            var tab = $('#employee')
            tab.addClass('active');
            var tab = $('#staffblock');
            tab.css('display','block');

            $("#city").select2({
                placeholder: "Select a city",
                allowClear: true
            });

            $("#state").select2({
                placeholder: "Select a state",
                allowClear: true
            });

            $("#designation").select2({
                placeholder: "Select a designation",
                allowClear: true
            });

            $("#currentStatus").select2({
                placeholder: "Select a Working status",
                allowClear: true
            });

            $.fn.extend({
                populateDepartment: function(){
                    var selected = $(this);
                    var department = [];

                   selected.each(function(){
                       $.ajax({
                           type: "GET",
                            dataType: "json",
                            async: false,
                            url: "${pageContext.request.contextPath}/rest/department/id/"+$(this).attr("id"),
                            success: function(data){
                                department.push(data)
                            },
                            complete: function () {

                            }
                        });


                    });
                    alert(JSON.stringify(department));
                    return department;
                }
            });

            $.fn.extend({
                populateCompany : function () {
                    var company;
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        async: false,
                        url: "${pageContext.request.contextPath}/rest/company/id/1",
                        success: function(data){
                            company = data;
                        },
                        complete: function () {

                        }
                    });

                    return company;
                }
            });

            $.fn.extend({
                mobileNumberExist: function (number) {
                    //alert("${pageContext.request.contextPath}/rest/employee/company/id/1/contact/"+number);
                    var returnValue;
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        async: false,
                        url: "${pageContext.request.contextPath}/rest/employee/company/id/1/contact/"+number,
                        success: function(data){
                            if(JSON.stringify(data) === "\"yes\""){
                                new PNotify({
                                    title: '<strong>Mobile Number Error</strong>',
                                    text: 'Mobile number <strong>one</strong> already present, <br> Please change mobile details',
                                    addclass: 'bg-warning'
                                });
                                returnValue = true;
                            }
                            else{
                                returnValue = false;
                            }

                        },
                        error: function (data) {
                            new PNotify({
                                title: '<strong>Unable to check mobile number</strong>',
                                text: 'Error connecting to server for mobile validation, <br> Please try after sometime.',
                                addclass: 'bg-warning'
                            });

                            returnValue = true;

                        }
                    });

                    return returnValue;
                }
            });

            $.fn.extend({
                makejson: function (message) {
                    var json = {};

                    //Department
                    var selected = $('#departementVO :selected');
                    var department = selected.populateDepartment();

                    //Company
                    var company = $.fn.populateCompany();

                    var employeeName = $('#employeeName').val();


                    json["id"] = 1;
                    json["employeeName"] = employeeName;
                    json["designation"] = $('#designation').val();
                    json["date"] = $('#date').val();

                    var contactNumber = $('#contactNumberOne').val();
                    var result = $.fn.mobileNumberExist(contactNumber);
                    if(true === result){
                        return true;
                    }
                    json["contactNumberOne"] = contactNumber;


                    var contactNumberTwo = $('#contactNumberTwo').val();
                    result = $.fn.mobileNumberExist(contactNumberTwo);
                    if(true === result){
                        return true;
                    }
                    json["contactNumberTwo"] = contactNumberTwo;

                    json["address"] = $('#address').val();
                    json["city"] = $('#city').val();
                    json["state"] = $('#state').val();
                    json["aadhaarNo"] = $('#aadharNO').val();
                    json["joiningDate"] = $('#joiningDate').val();
                    json["currentStatus"] = $('#currentStatus').val();
                    json["companyVO"] = company;
                    json["departmentVO"] = department;


                    alert(JSON.stringify(json));


                    $.ajax({
                        type: 'POST',
                        async: false,
                        url: '${pageContext.request.contextPath}/rest/employee/post',
                        data: JSON.stringify(json),
                        success: function(data) {
                            alert('data: ' + data);
                            new PNotify({
                                title: 'Success notice',
                                text: 'Check me out! I\'m a notice.',
                                icon: 'icon-checkmark3',
                                type: 'success'
                            });
                        },
                        contentType: "application/json",
                        dataType: 'json',
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            new PNotify({
                                title: '<strong>Error</strong>',
                                text: 'Unable to add employee, <br> Please check Details',
                                addclass: 'bg-warning'
                            });
                        }
                    });




                }
            });

            $.fn.func = function () {
                alert('james');
            };


            $( "#empform" ).submit(function( event ) {
                $('#empform').makejson('hi');
                event.preventDefault();
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
                        <h4><i class="icon-arrow-left52 position-left"></i> <span class="text-semibold">Starters</span> - 2 Columns</h4>
                    </div>

                    <div class="heading-elements">
                        <a href="#" class="btn btn-labeled btn-labeled-right bg-blue heading-btn">Button <b><i class="icon-menu7"></i></b></a>
                    </div>
                </div>

                <jsp:include page="NavigationHeader/breadCrumbLine.jsp"></jsp:include>

            </div>
            <!-- /page header -->



            <!-- Content area -->
            <div class="content">
                <!-- Vertical form options -->
                <div class="row">
                    <div class="col-md-1"></div>

                    <div class="col-md-10">

                        <!-- Basic layout-->
                        <form action="#" id="empform" class="form-horizontal form-validate-jquery" method="post" >
                            <div class="panel panel-flat">
                                <div class="panel-heading">
                                    <h5 class="panel-title">Basic layout</h5>
                                    <div class="heading-elements">
                                        <ul class="icons-list">
                                            <li><a data-action="collapse"></a></li>
                                            <li><a data-action="reload"></a></li>
                                            <li><a data-action="close"></a></li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="panel-body">
                                    <div class="form-group">
                                        <label>Name:<span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" id="employeeName" name="basic" required autofocus placeholder="Eugene Kopyov">
                                    </div>

                                    <div class="form-group">
                                        <label>Address:<span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" id="address" name="address" required autofocus placeholder="Address">
                                    </div>

                                    <div class="form-group">
                                        <label>State:</label>
                                        <select class="select" name="state" id="state" required autofocus>
                                            <option value="" >Select State</option>
                                            <optgroup label="States">
                                                <c:forEach items="${state_city}" var="palce">
                                                    <option value="${palce.stateName}">${palce.stateName}</option>
                                                </c:forEach>
                                            </optgroup>

                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>City:</label>
                                        <select class="select" name="city" id="city" required  autofocus>
                                            <option value="" >Select City</option>
                                            <c:forEach items="${state_city}" var="place">
                                                <optgroup label="${place.stateName}">
                                                    <c:forEach items="${place.cityName}" var="city">
                                                        <option value="${city}">${city}</option>
                                                    </c:forEach>
                                                </optgroup>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>Designation:</label>
                                        <select class="select" id="designation" required  autofocus>
                                            <option value="" >Select Designation</option>

                                            <optgroup label="Designation">
                                                <option value="HEAD">HEAD</option>
                                                <option value="SENIOR">SENIOR</option>
                                                <option value="JUNIOR">JUNIOR</option>
                                            </optgroup>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>Your avatar:</label>
                                        <input type="file" class="file-styled" >
                                        <span class="help-block">Accepted formats: gif, png, jpg. Max file size 2Mb</span>
                                    </div>

                                    <div class="form-group">
                                        <label>Tags:</label>
                                        <select multiple="multiple"  data-placeholder="Enter tags" class="select-icons">
                                            <optgroup label="Services">
                                                <option value="wordpress2" data-icon="wordpress2">Wordpress</option>
                                                <option value="tumblr2" data-icon="tumblr2">Tumblr</option>
                                                <option value="stumbleupon" data-icon="stumbleupon">Stumble upon</option>
                                                <option value="pinterest2" data-icon="pinterest2">Pinterest</option>
                                                <option value="lastfm2" data-icon="lastfm2">Lastfm</option>
                                            </optgroup>
                                            <optgroup label="File types">
                                                <option value="pdf" data-icon="file-pdf">PDF</option>
                                                <option value="word" data-icon="file-word">Word</option>
                                                <option value="excel" data-icon="file-excel">Excel</option>
                                                <option value="openoffice" data-icon="file-openoffice">Open office</option>
                                            </optgroup>
                                            <optgroup label="Browsers">
                                                <option value="chrome" data-icon="chrome" selected="selected">Chrome</option>
                                                <option value="firefox" data-icon="firefox" selected="selected">Firefox</option>
                                                <option value="safari" data-icon="safari">Safari</option>
                                                <option value="opera" data-icon="opera">Opera</option>
                                                <option value="IE" data-icon="IE">IE</option>
                                            </optgroup>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>AdhaarNumber:</label>
                                        <input type="text" class="form-control" id="aadharNO" placeholder="AdharNumber"  autofocus>
                                    </div>

                                    <div class="form-group">
                                        <label>Contact Number 1:</label>
                                        <input type="text" id="contactNumberOne" class="form-control" placeholder="09XXXXXXXX"  autofocus>
                                    </div>

                                    <div class="form-group">
                                        <label>Contact Number 2:</label>
                                        <input type="text" id="contactNumberTwo" class="form-control" placeholder="09XXXXXXXX" autofocus>
                                    </div>

                                    <div class="form-group">
                                        <label>BirthDate Date: </label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar22"></i></span>
                                            <% Date date = new Date();%>
                                            <% String string = new SimpleDateFormat("MM/dd/yyyy").format(date); %>
                                            <input type="text" id="date" class="form-control daterange-single" value="<% out.print(string);%>"  autofocus>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Joining Date: </label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar22"></i></span>
                                            <input type="text" id="joiningDate" class="form-control daterange-single" value="<% out.print(string);%>">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Leaving Date: </label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar22"></i></span>
                                            <input type="text" id="leavingDate" class="form-control daterange-single" value="" placeholder="leaving date" autofocus>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Working Staus:</label>
                                        <select class="select" id="currentStatus" required  autofocus>
                                            <option value="">Select Working Status</option>

                                            <optgroup label="Status">
                                                <option value="CURRENT">CURRENT</option>
                                                <option value="EX">EX</option>
                                            </optgroup>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>Department:</label>
                                        <div class="multi-select-full">
                                            <select class="multiselect-select-all" name="department" id="departementVO" multiple="multiple">
                                                <c:forEach items="${department_list}" var="department">
                                                    <option value="${department.departmentName}" id="${department.id}">${department.departmentName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Outlet:</label>
                                        <c:if test="${fn:length(outlet_list) eq 0}">
                                            <div class="multi-select-full">
                                                <select class="multiselect" multiple="multiple" id="outletVO">
                                                    <option value="None">None</option>
                                                </select>
                                            </div>
                                        </c:if>
                                        <c:if test="${fn:length(outlet_list) ne 0}">
                                            <div class="multi-select-full">
                                                <select class="multiselect-select-all" multiple="multiple" id="outletVO">
                                                    <c:forEach items="${outlet_list}" var="outlet">
                                                        <option value="${outlet.outletName}">${outlet.outletName}</option>
                                                    </c:forEach>
                                                    <option value="None">None</option>
                                                </select>
                                            </div>
                                        </c:if>

                                    </div>

                                    <div class="form-group">
                                        <label>Salary:</label>
                                        <c:if test="${fn:length(salary_list) eq 0}">
                                            <div class="multi-select-full">
                                                <select class="multiselect" multiple="multiple" id="salaryVO">
                                                    <option value="None">None</option>
                                                </select>
                                            </div>
                                        </c:if>
                                        <c:if test="${fn:length(salary_list) ne 0}">
                                            <div class="multi-select-full">
                                                <select class="multiselect-select-all" multiple="multiple" id="salaryVO">
                                                    <c:forEach items="${salary_list}" var="salary">
                                                        <option value="${salary.salaryName}">${salary.salaryName}</option>
                                                    </c:forEach>
                                                    <option value="None">None</option>
                                                </select>
                                            </div>
                                        </c:if>

                                    </div>

                                    <div class="text-right">
                                        <button type="submit" class="btn btn-primary">Submit form <i class="icon-arrow-right14 position-right"></i></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <!-- /basic layout -->

                    </div>

                    <div class="col-md-1"></div>
                </div>
                <!-- /vertical form options -->
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
