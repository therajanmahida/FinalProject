<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>zPharma | Home</title>

    <!-- Global stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/icons/fontawesome/styles.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/colors.css" rel="stylesheet" type="text/css">
    <!-- /global stylesheets -->


    <!-- Core JS files -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->


    <!-- Theme JS files -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/validation/validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/bootstrap_multiselect.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/inputs/touchspin.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/switch.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/switchery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/bootbox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/sweet_alert.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/tables/datatables/datatables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/tables/datatables/extensions/responsive.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/tables/datatables/extensions/jszip/jszip.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/tables/datatables/extensions/pdfmake/pdfmake.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/tables/datatables/extensions/pdfmake/vfs_fonts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/tables/datatables/extensions/buttons.min.js"></script>


    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/datatables_responsive.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/datatables_extension_buttons_html5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_modals.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/form_validation.js"></script>
    <!-- /theme JS files -->

    <script type="text/javascript">
        $(document).ready(function(){

            $('#supplier_tab').addClass('active')
            $('#supplier_database_tab').addClass('active');
            $('#supplier_block').css('display','block');
            $('#supplier_management_block').css('display_block');

            $('.datatable-responsive-main').DataTable({

                buttons: {
                    dom: {
                        button: {
                            className: 'btn btn-default'
                        }
                    },
                    buttons: [
                        'copyHtml5',
                        'excelHtml5',
                        'csvHtml5',
                        {
                            extend: 'pdfHtml5',
                            exportOptions: {
                                columns: [ 0, 1, 2, 4 ]
                            }
                        }

                    ]

                }


            });

            var data_id;

            $('.update').on('click',function(){
                var content  = $(this).closest("tr");
                data_id = content.attr('id');
                $('#supplierName').val(content.find("td:eq(0)").text());
                $('#ownerName').val(content.find("td:eq(2)").text());
                $('#gSTInNumber').val(content.find("td:eq(1)").text());
                $('#emailId').val(content.find("td:eq(3)").text());
                $('#contactNumberOne').val(content.find("td:eq(4)").text());
                $('#contactNumberTwo').val(content.find("td:eq(5)").text());
                $('#address').val(content.find("td:eq(6)").text());
                //var state = content.find("td:eq(6)").text();
                //$('option[value='+state+']').attr('selected','selected');
                var PRESELECTED = [];
                PRESELECTED.push(content.find("td:eq(7)").text());
                /*$('#state').select2({
                    val: PRESELECTED
                });*/


                $('#state').val(content.find("td:eq(7)").text()).trigger('change');
                $('#city').val(content.find("td:eq(8)").text()).trigger('change');

                $('#modal_form_horizontal').modal('show');


            });

            $('.delete').on('click',function(){
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    async: false,
                    url: "${pageContext.request.contextPath}/rest/supplier/id/"+$(this).closest('tr').attr("id"),
                    success: function(data){
                        department.push(data)
                    },
                    complete: function () {

                    }
                });


            });

            var validator = $(".form-validate-supplier").validate({
                ignore: 'input[type=hidden], .select2-search__field', // ignore hidden fields
                errorClass: 'validation-error-label',
                successClass: 'validation-valid-label',
                highlight: function(element, errorClass) {
                    $(element).removeClass(errorClass);
                },
                unhighlight: function(element, errorClass) {
                    $(element).removeClass(errorClass);
                },

                // Different components require proper error label placement
                errorPlacement: function(error, element) {

                    // Styled checkboxes, radios, bootstrap switch
                    if (element.parents('div').hasClass("checker") || element.parents('div').hasClass("choice") || element.parent().hasClass('bootstrap-switch-container') ) {
                        if(element.parents('label').hasClass('checkbox-inline') || element.parents('label').hasClass('radio-inline')) {
                            error.appendTo( element.parent().parent().parent().parent() );
                        }
                        else {
                            error.appendTo( element.parent().parent().parent().parent().parent() );
                        }
                    }

                    // Unstyled checkboxes, radios
                    else if (element.parents('div').hasClass('checkbox') || element.parents('div').hasClass('radio')) {
                        error.appendTo( element.parent().parent().parent() );
                    }

                    // Input with icons and Select2
                    else if (element.parents('div').hasClass('has-feedback') || element.hasClass('select2-hidden-accessible')) {
                        error.appendTo( element.parent() );
                    }

                    // Inline checkboxes, radios
                    else if (element.parents('label').hasClass('checkbox-inline') || element.parents('label').hasClass('radio-inline')) {
                        error.appendTo( element.parent().parent() );
                    }

                    // Input group, styled file input
                    else if (element.parent().hasClass('uploader') || element.parents().hasClass('input-group')) {
                        error.appendTo( element.parent().parent() );
                    }

                    else {
                        error.insertAfter(element);
                    }
                },
                validClass: "validation-valid-label",
                success: function(label) {
                    label.addClass("validation-valid-label").text("Success.")

                    //alert('ajax');

                },
                rules: {
                    password: {
                        minlength: 5
                    },
                    repeat_password: {
                        equalTo: "#password"
                    },
                    email: {
                        email: true
                    },
                    repeat_email: {
                        equalTo: "#email"
                    },
                    minimum_characters: {
                        minlength: 10
                    },
                    maximum_characters: {
                        maxlength: 10
                    },
                    minimum_number: {
                        min: 10
                    },
                    maximum_number: {
                        max: 10
                    },
                    number_range: {
                        range: [10, 20]
                    },
                    url: {
                        url: true
                    },
                    date: {
                        date: true
                    },
                    date_iso: {
                        dateISO: true
                    },
                    numbers: {
                        number: true,
                        minlength: 15,
                        maxlength: 15
                    },
                    contact_number_one: {
                        number: true,
                        minlength: 10,
                        maxlength: 10
                    },
                    contact_number_two: {
                        required: false,
                        number: true,
                        minlength: 10,
                        maxlength: 10
                    },
                    state: {
                        required: true
                    },
                    city: {
                        required: true
                    },
                    digits: {
                        digits: true
                    },
                    creditcard: {
                        creditcard: true
                    },
                    basic_checkbox: {
                        minlength: 2
                    },
                    styled_checkbox: {
                        minlength: 2
                    },
                    switchery_group: {
                        minlength: 2
                    },
                    switch_group: {
                        minlength: 2
                    }
                },
                messages: {
                    custom: {
                        required: "This is a custom error message"
                    },
                    agree: "Please accept our policy",
                    numbers: {
                        number: 'Please enter a valid GST-IN number.'
                    },
                    contact_number_one:{
                        number: 'Please enter a valid 10 digit mobile number',
                        maxlength: 'Please enter a valid 10 digit mobile number',
                        minlength: 'Please enter a valid 10 digit mobile number'
                    },
                    contact_number_two:{
                        number: 'Please enter a valid 10 digit mobile number',
                        maxlength: 'Please enter a valid 10 digit mobile number',
                        minlength: 'Please enter a valid 10 digit mobile number'
                    }

                },
                submitHandler: function(form) {
                    var supplier_name = $('#supplierName').val();
                    var gst_number = $('#gSTInNumber').val();
                    var owner_name = $('#ownerName').val();
                    var contact1 = $('#contactNumberOne').val();
                    var contact2 = $('#contactNumberTwo').val();
                    var email_id = $('#emailId').val();
                    var address = $('#address').val();
                    var city = $('#city').val();
                    var state = $('#state').val();

                    jsonObject = {};
                    jsonObject["id"] = data_id;
                    jsonObject["supplierName"] = supplier_name;
                    jsonObject["gSTInNumber"] = gst_number;
                    jsonObject["ownerName"] = owner_name;
                    jsonObject["contactNumberOne"] = contact1;
                    jsonObject["contactNumberTwo"] = contact2;
                    jsonObject["emailId"] = email_id;
                    jsonObject["address"] = address;
                    jsonObject["city"] = city;
                    jsonObject["state"] = state;

                    var light = $('.supplier_form_column')
                    $(light).block({
                        message: '<i class="icon-spinner spinner"></i><h4>Hi</h4>',
                        overlayCSS: {
                            backgroundColor: '#fff',
                            opacity: 0.8,
                            cursor: 'wait'
                        },
                        css: {
                            border: 0,
                            padding: 0,
                            backgroundColor: 'none'
                        }
                    });


                    $.ajax({
                        type: 'POST',
                        async: '${pageContext.request.contextPath}/rest/supplier/update/company/id/1',
                        data: JSON.stringify(jsonObject),
                        success: function(data) {
                            alert('data: ' + data);

                            var file = $('input[name="upload_file"]').get(0).files[0];

                            if(file != null){
                                var string = '${pageContext.request.contextPath}/rest/upload/file/supplier/id/'+data;
                                alert(string);

                                var formData = new FormData();
                                formData.append('file', file);
                                $.ajax({
                                    type: 'POST',
                                    async: false,
                                    url: string,
                                    data: formData,
                                    cache: false,
                                    contentType: false,
                                    processData: false,
                                    success: function(data) {


                                        new PNotify({
                                            title: 'Supplier Inserted',
                                            text: 'Check database for supplier changes.',
                                            addclass: 'bg-success'
                                        });

                                        $(light).unblock();



                                    },


                                    error: function(response) {
                                        new PNotify({
                                            title: '<strong>Error</strong>',
                                            text: 'Unable to add supplier, <br> Please try again by removing document.',
                                            addclass: 'bg-warning'
                                        });

                                    },
                                    xhr: function() {
                                        var myXhr = $.ajaxSettings.xhr();
                                        if (myXhr.upload) {
                                            myXhr.upload.addEventListener('progress', progress, false);
                                        } else {
                                            console.log('Upload progress is not supported.');
                                        }
                                        return myXhr;
                                    },
                                    complete: function(){

                                    }
                                });
                            }




                        },
                        contentType: "application/json",
                        dataType: 'json',
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            new PNotify({
                                title: '<strong>Error</strong>',
                                text: 'Unable to add supplier, <br> Please check Details',
                                addclass: 'bg-warning'
                            });
                        },
                        complete: function(){
                            $(light).unblock();
                        }
                    });


                }
            });


        })
    </script>

</head>


<body>
<!-- Main navbar -->
<div class="navbar navbar-inverse">
    <div class="navbar-header">
        <a class="navbar-brand" href="index.html"><img src="assets/images/logo_light.png" alt=""></a>

        <ul class="nav navbar-nav visible-xs-block">
            <li><a data-toggle="collapse" data-target="#navbar-mobile"><i class="icon-tree5"></i></a></li>
            <li><a class="sidebar-mobile-main-toggle"><i class="icon-paragraph-justify3"></i></a></li>
        </ul>
    </div>

    <div class="navbar-collapse collapse" id="navbar-mobile">
        <ul class="nav navbar-nav">
            <li><a class="sidebar-control sidebar-main-toggle hidden-xs"><i class="icon-paragraph-justify3"></i></a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Text link</a></li>

            <li>
                <a href="#">
                    <i class="icon-cog3"></i>
                    <span class="visible-xs-inline-block position-right">Icon link</span>
                </a>
            </li>

            <li class="dropdown dropdown-user">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    <img src="assets/images/image.png" alt="">
                    <span>Victoria</span>
                    <i class="caret"></i>
                </a>

                <ul class="dropdown-menu dropdown-menu-right">
                    <li><a href="#"><i class="icon-user-plus"></i> My profile</a></li>
                    <li><a href="#"><i class="icon-coins"></i> My balance</a></li>
                    <li><a href="#"><span class="badge badge-warning pull-right">58</span> <i class="icon-comment-discussion"></i> Messages</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="icon-cog5"></i> Account settings</a></li>
                    <li><a href="#"><i class="icon-switch2"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- /main navbar -->


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

                <div class="breadcrumb-line">
                    <ul class="breadcrumb">
                        <li><a href="dashboard.html"><i class="icon-home2 position-left"></i>DashBoard</a></li>
                    </ul>

                    <ul class="breadcrumb-elements">
                        <li><a href="#"><i class="icon-comment-discussion position-left"></i> Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="icon-gear position-left"></i>
                                Dropdown
                                <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href="#"><i class="icon-user-lock"></i> Account security</a></li>
                                <li><a href="#"><i class="icon-statistics"></i> Analytics</a></li>
                                <li><a href="#"><i class="icon-accessibility"></i> Accessibility</a></li>
                                <li class="divider"></li>
                                <li><a href="#"><i class="icon-gear"></i> All settings</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Basic responsive configuration -->
                <div class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Configuration option</h5>
                        <div class="heading-elements">
                            <ul class="icons-list">
                                <li><a data-action="collapse"></a></li>
                                <li><a data-action="reload"></a></li>
                                <li><a data-action="close"></a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="panel-body">
                        The <code>Responsive</code> extension for DataTables can be applied to a DataTable in one of two ways; with a specific <code>class name</code> on the table, or using the DataTables initialisation options. This method shows the latter, with the <code>responsive</code> option being set to the boolean value <code>true</code>. The <code>responsive</code> option can be given as a boolean value, or as an object with configuration options.
                    </div>

                    <table class="table datatable-responsive-main">
                        <thead>
                        <tr>
                            <th data-priority="1">Supplier Name</th>
                            <th data-priority="2">GST-IN Number</th>
                            <th data-priority="2">Owner Name</th>
                            <th data-priority="3">Email-Id</th>
                            <th data-priority="2">Contact #1</th>
                            <th data-priority="4">Contact #2</th>
                            <th data-priority="5">Address</th>
                            <th data-priority="6">State</th>
                            <th data-priority="7">City</th>
                            <th data-priority="1" class="text-center">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${supplier_list}" var="supplier">
                            <tr id="${supplier.id}">
                                <td class="supplier_name">${supplier.supplierName}</td>
                                <td class="gst_number">${supplier.gSTInNumber}</td>
                                <td class="owner_name">${supplier.ownerName}</td>
                                <td class="supplier_name">${supplier.emailId}</td>
                                <td class="contact_one">${supplier.contactNumberOne}</td>
                                <td class="contact_two">${supplier.contactNumberTwo}</td>
                                <td class="address">${supplier.address}</td>
                                <td class="state">${supplier.state}</td>
                                <td class="city">${supplier.city}</td>

                                <td class="text-center">
                                    <ul class="icons-list">
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                <i class="icon-menu9"></i>
                                            </a>

                                            <ul class="dropdown-menu dropdown-menu-right">
                                                <li><a class="update"><i class="icon-file-pdf"></i>&nbsp;Update</a></li>
                                                <li><a class="delete"><i class="icon-file-excel"></i>&nbsp;Delete</a></li>
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
                <!-- /basic responsive configuration -->


                <!-- Footer -->
                <div class="footer text-muted">
                    &copy; 2015. <a href="#">Limitless Web App Kit</a> by <a href="http://themeforest.net/user/Kopyov" target="_blank">Eugene Kopyov</a>
                </div>
                <!-- /footer -->

                <!-- Horizontal form modal -->
                <div id="modal_form_horizontal" class="modal fade">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h5 class="modal-title">Horizontal form</h5>
                            </div>

                            <form action="www.google.co.in" class="form-horizontal form-validate-supplier">
                                <div class="modal-body">
                                    <!-- Basic text input -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">Supplier Name<span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <input type="text" name="basic" id="supplierName" class="form-control" required="required" placeholder="Text input validation">
                                        </div>
                                    </div>
                                    <!-- /basic text input -->

                                    <!-- Numbers only -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">GST Number<span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <input type="text" name="numbers" id="gSTInNumber" class="form-control" required="required" placeholder="Enter decimal number only">
                                        </div>
                                    </div>
                                    <!-- /numbers only -->

                                    <!-- Basic text input -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">Owner Name<span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <input type="text" name="owner_name" id="ownerName" class="form-control" required="required" placeholder="Text input validation">
                                        </div>
                                    </div>
                                    <!-- /basic text input -->

                                    <!-- Email field -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">Email id <span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <input type="email" name="email" id="emailId" class="form-control" id="email" required="required" placeholder="Enter a valid email address">
                                        </div>
                                    </div>
                                    <!-- /email field -->


                                    <!-- Numbers only -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">Contact Number One <span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <input type="text" name="contact_number_one" id="contactNumberOne" class="form-control" required="required" placeholder="Enter Contact Number">
                                        </div>
                                    </div>
                                    <!-- /numbers only -->

                                    <!-- Numbers only -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">Contact Number Two</label>
                                        <div class="col-lg-9">
                                            <input type="text" name="contact_number_two" id="contactNumberTwo" class="form-control" required="" placeholder="Enter Contact Number">
                                        </div>
                                    </div>
                                    <!-- /numbers only -->

                                    <!-- Basic text input -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">Address <span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <input type="text" name="address" class="form-control" id="address" required="required" placeholder="Text input validation">
                                        </div>
                                    </div>
                                    <!-- /basic text input -->



                                    <!-- Multiple select -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">State<span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <select data-placeholder="Select a State..." id="state" name="state" class="form-control select" required="required">
                                                <option></option>
                                                <optgroup label="Mountain Time Zone">
                                                    <option value="AZ">Arizona</option>
                                                    <option value="CO">Colorado</option>
                                                    <option value="ID">Idaho</option>
                                                    <option value="WY">Wyoming</option>
                                                </optgroup>
                                                <optgroup label="Central Time Zone">
                                                    <option value="AL">Alabama</option>
                                                    <option value="IA">Iowa</option>
                                                    <option value="KS">Kansas</option>
                                                    <option value="KY">Kentucky</option>
                                                </optgroup>
                                                <optgroup label="Eastern Time Zone">
                                                    <option value="CT">Connecticut</option>
                                                    <option value="FL">Florida</option>
                                                    <option value="MA">Massachusetts</option>
                                                    <option value="WV">West Virginia</option>
                                                </optgroup>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- /multiple select -->

                                    <!-- Multiple select -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">City<span class="text-danger">*</span></label>
                                        <div class="col-lg-9">
                                            <select data-placeholder="Select a State..." name="city" id="city" class="form-control select" required="required">
                                                <option></option>
                                                <optgroup label="Mountain Time Zone">
                                                    <option value="AZ">Arizona</option>
                                                    <option value="CO">Colorado</option>
                                                    <option value="ID">Idaho</option>
                                                    <option value="WY">Wyoming</option>
                                                </optgroup>
                                                <optgroup label="Central Time Zone">
                                                    <option value="AL">Alabama</option>
                                                    <option value="IA">Iowa</option>
                                                    <option value="KS">Kansas</option>
                                                    <option value="KY">Kentucky</option>
                                                </optgroup>
                                                <optgroup label="Eastern Time Zone">
                                                    <option value="CT">Connecticut</option>
                                                    <option value="FL">Florida</option>
                                                    <option value="MA">Massachusetts</option>
                                                    <option value="WV">West Virginia</option>
                                                </optgroup>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- /multiple select -->
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Submit form</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /horizontal form modal -->

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
