<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>zPharma | Home</title>

    <!-- Global stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css" media="all">
    <link href="${pageContext.request.contextPath}/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css" media="all">
    <link href="${pageContext.request.contextPath}/assets/css/icons/fontawesome/styles.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="${pageContext.request.contextPath}/assets/css/core.css" rel="stylesheet" type="text/css" media="all">
    <link href="${pageContext.request.contextPath}/assets/css/components.css" rel="stylesheet" type="text/css" media="all">
    <link href="${pageContext.request.contextPath}/assets/css/colors.css" rel="stylesheet" type="text/css" media="all">
    <!-- /global stylesheets -->

    <!-- Core JS files -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/libraries/bootstrap.min.js"></script>
    <!-- /core JS files -->

    <!-- Theme JS files -->
    <!-- Theme JS files -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/bootbox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/sweet_alert.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/uploaders/fileinput/plugins/purify.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/uploaders/fileinput/plugins/sortable.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/uploaders/fileinput/fileinput.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/editors/summernote/summernote.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/pnotify.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/mail_list_write.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/printThis.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/jspdf.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/from_html.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/split_text_to_size.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/standard_fonts_metrics.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/uploader_bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_modals.js"></script>
    <!-- /theme JS files -->



    <script type="text/javascript">
        $(document).ready(function(){

            $('#message_tab').addClass('active');
            $('#message_compose_tab').addClass('active');
            $('#message_block').css('display','block');

            function PrintElem(elem)
            {
                var mywindow = window.open('', 'PRINT', 'height=400,width=600');

                mywindow.document.write('<html><head><title>' + document.title  + '</title>');
                mywindow.document.write('<!-- Global stylesheets -->\n' +
                    '    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">\n' +
                    '    <link href="assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="assets/css/icons/fontawesome/styles.min.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="assets/css/core.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="assets/css/components.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="assets/css/colors.css" rel="stylesheet" type="text/css">\n' +
                    '    <!-- /global stylesheets -->');
                mywindow.document.write('')
                mywindow.document.write('</head><body >');
                mywindow.document.write('<h1>' + document.title  + '</h1>');
                mywindow.document.write(document.getElementById(elem).innerHTML);
                mywindow.document.write('</body></html>');

                mywindow.document.close(); // necessary for IE >= 10
                mywindow.focus(); // necessary for IE >= 10*/

                mywindow.print();
                mywindow.close();

                return true;
            }

            var getUrlParameter = function getUrlParameter(sParam) {
                var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                    sURLVariables = sPageURL.split('&'),
                    sParameterName,
                    i;

                for (i = 0; i < sURLVariables.length; i++) {
                    sParameterName = sURLVariables[i].split('=');

                    if (sParameterName[0] === sParam) {
                        return sParameterName[1] === undefined ? true : sParameterName[1];
                    }
                }
            };

            $('#print_button').on('click',function(){
                $('.note-editable').printThis({
                    importCSS: true
                });
            });

            var to = getUrlParameter('to');
            $('#recipient_input').val(to);

            $('#send-mail-button').on('click',function(){

                var message_content = $('.note-editable').html();
                var userTo = $('#recipient_input').val();
                var userFrom = "admin@croods.com";
                var subject = $('#email_subject').val();

                jsonMessage = {};
                jsonMessage["message"] = message_content;
                jsonMessage["messageSubject"] = subject;

                jsonSendMessage = {};
                jsonSendMessage["messageVO"] = jsonMessage;

                //alert(JSON.stringify(jsonSendMessage));
                //alert(userFrom+" "+userTo);
                //alert('http://localhost:8080/rest/messageto/company/id/1/userto/'+userTo+"/userfrom/"+userFrom);
                $.ajax({
                    type: 'POST',
                    async: false,
                    url: 'http://localhost:8080/rest/messageto/company/id/1/userto/'+userTo+"/userfrom/"+userFrom,
                    data: JSON.stringify(jsonSendMessage),
                    success: function(data) {
                       // alert('data: ' + data);

                        new PNotify({
                            title: '<strong><i class="fa fa-check-square"></i>&nbsp;&nbsp;&nbsp;Mail Sent</strong>',
                            text: 'Check me out! I\'m a notice.',
                            addclass: 'bg-success'
                        });
                    },
                    contentType: "application/json",
                    dataType: 'json',
                    error: function(data) {
                        //alert(data["responseText"]);
                        new PNotify({
                            title: '<strong>Error</strong>',
                            text: 'Unable to send mail, <br>'+data["status"],
                            addclass: 'bg-warning'
                        });
                    },
                    complete: function(data){
                        alert(data);

                    }
                });
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
<div id="container" class="page-container">

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



                <!-- Detached Contect-->
                <div class="container-detached">
                    <div class="content-detached">

                        <!-- Single mail -->
                        <div class="panel panel-white">

                            <!-- Mail toolbar -->
                            <div class="panel-toolbar panel-toolbar-inbox">
                                <div class="navbar navbar-default">
                                    <ul class="nav navbar-nav visible-xs-block no-border">
                                        <li>
                                            <a class="text-center collapsed" data-toggle="collapse" data-target="#inbox-toolbar-toggle-single">
                                                <i class="icon-circle-down2"></i>
                                            </a>
                                        </li>
                                    </ul>

                                    <div class="navbar-collapse collapse" id="inbox-toolbar-toggle-single">
                                        <div class="btn-group navbar-btn">
                                            <button type="button" id="send-mail-button" class="btn bg-blue"><i class="icon-checkmark3 position-left"></i> Send mail</button>
                                        </div>

                                        <div class="btn-group navbar-btn">
                                            <button type="button" class="btn btn-default"><i class="icon-plus2"></i> <span class="hidden-xs position-right">Save</span></button>
                                            <button type="button" class="btn btn-default"><i class="icon-cross2"></i> <span class="hidden-xs position-right">Cancel</span></button>

                                            <div class="btn-group">
                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                                    <i class="icon-menu7"></i>
                                                    <span class="caret"></span>
                                                </button>

                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Action</a></li>
                                                    <li><a href="#">Another action</a></li>
                                                    <li><a href="#">Something else here</a></li>
                                                    <li><a href="#">One more line</a></li>
                                                </ul>
                                            </div>
                                        </div>

                                        <div class="pull-right-lg">
                                            <div class="btn-group navbar-btn">
                                                <button id="print_button" type="button" class="btn btn-default"><i class="icon-printer"></i> <span class="hidden-xs position-right">Print</span></button>
                                                <button type="button" class="btn btn-default"><i class="icon-new-tab2"></i> <span class="hidden-xs position-right">Share</span></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /mail toolbar -->


                            <!-- Mail details -->
                            <div class="table-responsive mail-details-write">
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <td style="width: 150px">To:</td>
                                        <td class="no-padding"><input type="text" id="recipient_input" class="form-control" placeholder="Add recipients"></td>
                                        <td style="width: 250px" class="text-right">
                                            <ul class="list-inline list-inline-separate no-margin">
                                                <li><a href="#">Copy</a></li>
                                                <li><a href="#">Hidden copy</a></li>
                                            </ul>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Subject:</td>
                                        <td class="no-padding"><input type="text" id="email_subject" class="form-control" placeholder="Add subject"></td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <ul class="list-inline no-margin">
                                                <li><a href="" data-toggle="" data-target=""><i class="icon-attachment position-left"></i> Attach files</a></li>
                                            </ul>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /mail details -->


                            <!-- Mail container -->
                            <div class="mail-container-write">
                                <div class="summernote">



                                </div>
                            </div>
                            <!-- /mail container -->


                            <!-- Attachments -->
                            <div class="mail-attachments-container">
                                <h6 class="mail-attachments-heading">2 Attachments</h6>

                                <ul class="mail-attachments">
                                    <li>
											<span class="mail-attachments-preview">
												<i class="icon-file-pdf icon-2x"></i>
											</span>

                                        <div class="mail-attachments-content">
                                            <span class="text-semibold">new_december_offers.pdf</span>

                                            <ul class="list-inline list-inline-condensed no-margin">
                                                <li class="text-muted">174 KB</li>
                                                <li><a href="#">View</a></li>
                                                <li><a href="#">Remove</a></li>
                                            </ul>
                                        </div>
                                    </li>

                                    <li>
											<span class="mail-attachments-preview">
												<i class="icon-file-pdf icon-2x"></i>
											</span>

                                        <div class="mail-attachments-content">
                                            <span class="text-semibold">assignment_letter.pdf</span>

                                            <ul class="list-inline list-inline-condensed no-margin">
                                                <li class="text-muted">736 KB</li>
                                                <li><a href="#">View</a></li>
                                                <li><a href="#">Remove</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!-- /attachments -->

                        </div>
                        <!-- /single mail -->

                    </div>
                </div>
                <!-- /detached content -->


                <!-- Footer -->
                <div class="footer text-muted">
                    &copy; 2015. <a href="#">Limitless Web App Kit</a> by <a href="http://themeforest.net/user/Kopyov" target="_blank">Eugene Kopyov</a>
                </div>
                <!-- /footer -->

                <!-- Basic modal -->
                <div id="modal_default" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h5 class="modal-title">Basic modal</h5>
                            </div>

                            <div class="modal-body">

                                <div class="form-group">
                                    <label class="col-lg-2 control-label text-semibold">AJAX upload:</label>
                                    <div class="col-lg-10">
                                        <input type="file" class="file-input-ajax" multiple="multiple">
                                        <span class="help-block">This scenario uses asynchronous/parallel uploads. Uploading itself is turned off in live preview.</span>
                                    </div>
                                </div>


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
