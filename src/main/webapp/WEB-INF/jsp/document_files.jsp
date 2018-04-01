<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <!--Theme JS files -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/loaders/progressbar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/editors/summernote/summernote.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/bootbox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/sweet_alert.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/switchery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/media/fancybox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/pnotify.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_thumbnails.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/html2canvas.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_modals.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/editor_summernote.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_loaders.js"></script>

    <!-- /theme JS files -->

    <script type="text/javascript">
        $(document).ready(function(){

            $('#document_tab').addClass('active');
            $('#document_files_tab').addClass('active');
            $('#document_block').css('display','block');

            /*html2canvas(document.querySelector('#panel')).then(function(canvas) {

                var dataUrl = canvas.toDataURL();
                //alert(dataUrl);
                var  imageFoo = document.createElement('img');
                imageFoo.src = dataUrl;


                // Style your image here
                imageFoo.style.width = '200px';
                imageFoo.style.height = '200px';
                imageFoo.className = 'img-responsive'

                // After you are done styling it, append it to the BODY element
                var thumnail = $('.document');
                thumnail.each(function(){
                    $(this).append(imageFoo);
                })
                //document.body.appendChild(imageFoo);
            });*/

            var documentlist;

            $.fn.extend({

                getDocumentTemplate : function (image_id,data_src) {
                    var template = "<div class=\"thumbnail\" id="+ image_id +">\n" +
                        "                                    <div class=\"thumb\">\n" +
                        "                                        <div  class=\"document img-responsive\">\n" +
                        "\n" + $.fn.getImage(data_src) +
                        "                                        </div>\n" +
                        "                                        <div class=\"caption-overflow\">\n" +
                        "                                                    <span>\n" +
                        "                                                        <a href=\"#\" class=\"btn btn-info btn-sm edit-document-button\">Edit</a>\n" +
                        "                                                        <a href=\"#\" class=\"btn btn-info btn-sm remove-document-button\">Remove</a>\n" +
                        "                                                    </span>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "\n" +
                        "                                    <div class=\"caption\">\n" +
                        "                                        <h6 class=\"text-semibold no-margin-top\">Thumbnail title</h6>\n" +
                        "                                        Picture removal detract earnest is by. Ever read tell year give may men call its. Replying an marianne do it an entrance advanced.\n" +
                        "                                    </div>\n" +
                        "                                </div>";

                    return template;


                }




            });

            $.fn.extend({
                getImage : function (data_src) {
                    var image = new Image();
                    image.src = data_src;
                    image.style.width = '200px';
                    image.style.height = '200px';
                    //image.className = 'img-thumbnail';
                    return image.outerHTML;
                }
            });

            $.ajax({
                type: "GET",
                dataType: "json",
                async: false,
                url: "http://localhost:8080/rest/document/user/1",
                success: function(data){
                    //alert(data.length);
                    documentlist = data;
                    var half_content = data.length%4;
                    var outer_loop = (data.length - half_content)/4;
                    //alert(outer_loop);
                    for( var i = 0; i<data.length;i++) {
                        $('#panel').append("<div class=\"col-md-3\">" + $.fn.getDocumentTemplate(data[i]["id"],data[i]["screen_shot"]) + "<\div>");


                    }




                },
                error: function (data) {


                }
            });

            var current_document_id;
            var second = false;
            $('.edit-document-button').on('click',function(){
                current_document_id = $(this).closest('.thumbnail').attr('id');
                //$('.click2edit').summernote({focus: true});
                $('#modal_default').modal({
                    backdrop: 'static'
                });
                $('#modal_default').modal('show');
                for(var i = 0;i<documentlist.length;i++){
                    //alert(documentlist[i]);
                    //alert(documentlist[i]["id"]);
                    if(documentlist[i]["id"] == $(this).closest('.thumbnail').attr('id')){

                        if(second === true){
                            $('.note-editable').append(documentlist[i]["documentContent"]);
                        }
                        $('.click2edit').append(documentlist[i]["documentContent"]);
                        $('.click2edit').summernote({
                            dialogsInBody: true,
                            focus: true
                        });
                        break;
                    }
                    second = true;
                }
            });

            $('#modal_default').on('show.bs.modal',function(e){


            });

            $('#modal_default').on('hidden.bs.modal', function () {
                $('.note-editable').empty();
            });

            $('.remove-document-button').on('click',function(){
                var id = $(this).closest('.thumbnail').attr('id');
                var delete_element = $(this).closest('.thumbnail').closest('.col-md-3');
                swal({
                        title: "Delete Document",
                        text: "Are you sure you want to delete document?",
                        type: "info",
                        showCancelButton: true,
                        closeOnConfirm: false,
                        confirmButtonColor: "#2196F3",
                        showLoaderOnConfirm: true
                    },
                    function(isConfirm) {
                        if(isConfirm === true) {
                            $.ajax({
                                url: "http://localhost:8080/rest/document/delete/"+id,
                                success: function (data) {
                                    //alert(JSON.stringify(data));
                                    delete_element.remove()
                                    swal({
                                        title: "Document deleted.",
                                        confirmButtonColor: "#2196F3"
                                    });

                                },
                                error: function(data){
                                    swal({
                                        title: "Unable to delete document.",
                                        confirmButtonColor: "#2196F3"
                                    });
                                }
                            });
                        }
                        /*setTimeout(function() {
                            swal({
                                title: "Ajax request finished!",
                                confirmButtonColor: "#2196F3"
                            });
                        }, 2000);*/

                    });

            });

            $('#save_button').on('click',function(){
               //alert('saved');


                var dark = $('#modal_default');
                $(dark).block({
                    message: '<i class="icon-spinner spinner"></i>',
                    overlayCSS: {
                        backgroundColor: '#1B2024',
                        opacity: 0.85,
                        cursor: 'wait'
                    },
                    css: {
                        border: 0,
                        padding: 0,
                        backgroundColor: 'none',
                        color: '#fff'
                    }
                });

                var val = $('.note-editable').html();
                var dataUrl;

                html2canvas(document.querySelector('.note-editable')).then(function(canvas) {
                    dataUrl = canvas.toDataURL();
                    //alert(dataUrl);

                    jsondata = {};
                    jsondata["id"] = current_document_id;
                    jsondata["username"] = "1";
                    jsondata["documentContent"] = val;
                    jsondata["screen_shot"] = dataUrl;
                    //alert(JSON.stringify(jsondata));
                    $.ajax({
                        type: 'POST',
                        async: false,
                        url: 'http://localhost:8080/rest/document/update',
                        data: JSON.stringify(jsondata),
                        success: function(data) {
                           // alert('data: ' + data);
                            $(dark).unblock();
                            new PNotify({
                                title: '<strong><i class="fa fa-check-square"></i>&nbsp;&nbsp;&nbsp;Document Updated</strong>',
                                text: 'Check me out! I\'m a notice.',
                                addclass: 'bg-success'
                            });

                        },
                        contentType: "application/json",
                        dataType: 'json',
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            new PNotify({
                                title: '<strong>Error</strong>',
                                text: 'Unable to update document, <br> Please try after sometime.',
                                addclass: 'bg-warning'
                            });
                        },
                        complete: function(data){
                            $(dark).unblock();
                            alert('completed');
                        }
                    });


                });



            });
        });
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

                <!-- Simple panel -->
                <div class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Documents</h5>
                        <div class="heading-elements">
                            <ul class="icons-list">
                                <li><a data-action="collapse"></a></li>
                                <li><a data-action="close"></a></li>
                            </ul>
                        </div>
                    </div>

                    <div id="panel" class="panel-body">


                    </div>



                    </div>
                </div>
                <!-- /simple panel -->





                <!-- Footer -->
                <div class="footer text-muted">
                    &copy; 2015. <a href="#">Limitless Web App Kit</a> by <a href="http://themeforest.net/user/Kopyov" target="_blank">Eugene Kopyov</a>
                </div>
                <!-- /footer -->

                <!-- Basic modal -->
                <div id="modal_default" class="modal fade" style="overflow: auto">
                    <div class="modal-dialog modal-full" style="overflow: auto">
                        <div class="modal-content" style="overflow: auto">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h5 class="modal-title">Edit Document</h5>
                            </div>

                            <div class="modal-body">
                                <div class="panel panel-flat">
                                    <div class="panel-heading">
                                        <h5 class="panel-title"></h5>
                                        <div class="heading-elements">
                                            <ul class="icons-list">
                                                <li><a class="" data-action="collapse"></a></li>
                                                <li><a data-action="reload"></a></li>
                                                <li><a data-action="close"></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="panel-body">

                                        <div class="form-group">
                                            <div class="col-lg-12">
                                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default btn-icon text-size-large" type="button">Title</button>
                                    </span>
                                                    <input type="text" class="form-control" placeholder="Enter Document Title">
                                                    <span class="input-group-btn">
                                        <!--<button type="button" id="edit" class="btn btn-primary"><i class="icon-pencil3 position-left"></i> Edit</button>-->
                                        <button type="button" id="save_button" class="btn btn-success"><i class="icon-checkmark3 position-left"></i> Save</button>
                                    </span>
                                                </div>
                                            </div>
                                        </div>

                                        <br>
                                        <br>

                                        <div class="form-group">

                                            <div class="click2edit">



                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /summernote click to edit -->
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /basic modal -->

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
