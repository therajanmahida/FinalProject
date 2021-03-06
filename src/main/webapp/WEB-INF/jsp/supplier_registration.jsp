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
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/uploaders/fileinput/plugins/purify.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/uploaders/fileinput/plugins/sortable.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/uploaders/fileinput/fileinput.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/libraries/jquery_ui/interactions.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/loaders/progressbar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/pnotify.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/validation/validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/bootstrap_multiselect.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/inputs/touchspin.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/switch.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/switchery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>


    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/form_layouts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/form_validation.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_loaders.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/uploader_bootstrap.js"></script>
    <!-- /theme JS files -->


    <script type="text/javascript">
        $(document).ready(function(){
            function progress(e) {
                if (e.lengthComputable) {
                    //$('#progress_percent').css(Math.floor((e.loaded * 100) / e.total));
                    $('.progress-bar').width(((e.loaded*100)/e.total)+'%');

                }
            }

            $('#supplier_tab').addClass('active');
            $('#supplier_registration_tab').addClass('active');
            $('#supplier_block').css('display','block');
            $('#supplier_management_block').css('display','block');

            // Modal template
            var modalTemplateMain = '<div class="modal-dialog modal-lg" role="document">\n' +
                '  <div class="modal-content">\n' +
                '    <div class="modal-header">\n' +
                '      <div class="kv-zoom-actions btn-group">{toggleheader}{fullscreen}{borderless}{close}</div>\n' +
                '      <h6 class="modal-title">{heading} <small><span class="kv-zoom-title"></span></small></h6>\n' +
                '    </div>\n' +
                '    <div class="modal-body">\n' +
                '      <div class="floating-buttons btn-group"></div>\n' +
                '      <div class="kv-zoom-body file-zoom-content"></div>\n' + '{prev} {next}\n' +
                '    </div>\n' +
                '  </div>\n' +
                '</div>\n';

            // Buttons inside zoom modal
            var previewZoomButtonClassesMain = {
                toggleheader: 'btn btn-default btn-icon btn-xs btn-header-toggle',
                fullscreen: 'btn btn-default btn-icon btn-xs',
                borderless: 'btn btn-default btn-icon btn-xs',
                close: 'btn btn-default btn-icon btn-xs'
            };

            // Icons inside zoom modal classes
            var previewZoomButtonIconsMain = {
                prev: '<i class="icon-arrow-left32"></i>',
                next: '<i class="icon-arrow-right32"></i>',
                toggleheader: '<i class="icon-menu-open"></i>',
                fullscreen: '<i class="icon-screen-full"></i>',
                borderless: '<i class="icon-alignment-unalign"></i>',
                close: '<i class="icon-cross3"></i>'
            };

            // File actions
            var fileActionSettingsMain = {
                zoomClass: 'btn btn-link btn-xs btn-icon',
                zoomIcon: '<i class="icon-zoomin3"></i>',
                dragClass: 'btn btn-link btn-xs btn-icon',
                dragIcon: '<i class="icon-three-bars"></i>',
                removeClass: 'btn btn-link btn-icon btn-xs',
                removeIcon: '<i class="icon-trash"></i>',
                indicatorNew: '<i class="icon-file-plus text-slate"></i>',
                indicatorSuccess: '<i class="icon-checkmark3 file-icon-large text-success"></i>',
                indicatorError: '<i class="icon-cross2 text-danger"></i>',
                indicatorLoading: '<i class="icon-spinner2 spinner text-muted"></i>'
            };


            $(".file-input-extensions-main").fileinput({
                browseLabel: 'Browse',
                browseClass: 'btn btn-info',
                uploadClass: 'btn btn-default',
                browseIcon: '<i class="icon-file-plus"></i>',
                uploadIcon: '<i class="icon-file-upload2"></i>',
                removeIcon: '<i class="icon-cross3"></i>',
                layoutTemplates: {
                    icon: '<i class="icon-file-check"></i>',
                    modal: modalTemplateMain
                },
                maxFilesNum: 10,
                maxFileSize: 1024,
                allowedFileExtensions: ["jpg", "gif", "png", "pdf"],
                initialCaption: "No file selected",
                previewZoomButtonClasses: previewZoomButtonClassesMain,
                previewZoomButtonIcons: previewZoomButtonIconsMain,
                fileActionSettings: fileActionSettingsMain
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
                        async: false,
                        url: 'http://localhost:8080/rest/supplier/post/company/id/1',
                        data: JSON.stringify(jsonObject),
                        success: function(data) {
                            alert('data: ' + data);

                            var file = $('input[name="upload_file"]').get(0).files[0];

                            if(file != null){
                                var string = 'http://localhost:8080/rest/upload/file/supplier/id/'+data;
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

            $('#reset_supplier_form').on('click', function() {
                validator.resetForm();
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

                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8 supplier_form_column">
                        <form action="#" class="form-horizontal form-validate-supplier">
                            <div class="panel panel-flat">
                                <div class="panel-heading">
                                    <h5 class="panel-title">Supplier Registration</h5>
                                    <div class="heading-elements">
                                        <ul class="icons-list">
                                            <li><a data-action="collapse"></a></li>
                                            <li><a data-action="reload"></a></li>
                                            <li><a data-action="close"></a></li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="panel-body">

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




                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Specify file extensions:</label>
                                        <div class="col-lg-9">
                                            <input type="file" class="file-input-extensions-main" name="upload_file">
                                            <span class="help-block">Allow only specific file extensions. In this example only <code>jpg</code>, <code>gif</code>, <code>png</code> and <code>txt</code> extensions are allowed.</span>
                                        </div>
                                    </div>




                                    <div class="text-right">
                                        <button type="reset" class="btn btn-default" id="reset_supplier_form">Reset <i class="icon-reload-alt position-right"></i></button>
                                        <button type="submit" class="btn btn-primary">Submit <i class="icon-arrow-right14 position-right"></i></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <!-- /basic layout -->
                    </div>
                    <div class="col-md-2"></div>
                </div>

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
