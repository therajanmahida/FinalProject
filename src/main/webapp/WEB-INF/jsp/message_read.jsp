<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/editors/summernote/summernote.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/mail_list_read.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/printThis.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/jspdf.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/from_html.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/split_text_to_size.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/standard_fonts_metrics.js"></script>

    <!-- /theme JS files -->



    <script type="text/javascript">
        $(document).ready(function(){

            $('#message_tab').addClass('active');
            $('#message_inbox_tab').addClass('active');
            $('#message_block').css('display','block')

            function PrintElem(elem)
            {
                var mywindow = window.open('', 'PRINT', 'height=400,width=600');

                mywindow.document.write('<html><head><title>' + document.title  + '</title>');
                mywindow.document.write('<!-- Global stylesheets -->\n' +
                    '    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">\n' +
                    '    <link href="${pageContext.request.contextPath}/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="${pageContext.request.contextPath}/assets/css/icons/fontawesome/styles.min.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="${pageContext.request.contextPath}/assets/css/core.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="${pageContext.request.contextPath}/assets/css/components.css" rel="stylesheet" type="text/css">\n' +
                    '    <link href="${pageContext.request.contextPath}/assets/css/colors.css" rel="stylesheet" type="text/css">\n' +
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

            $('#print_button').on('click',function(){
                $('.mail-container-read').printThis({
                    importCSS: true
                });
            });

            $('#reply_button').on('click',function(e){
                var user_email_address = "${message.userFrom.username}";
                window.location.href = "${pageContext.request.contextPath}/"+"?to="+user_email_address;
                e.preventDefault()
            });



            function redirect (url) {
                var ua        = navigator.userAgent.toLowerCase(),
                    isIE      = ua.indexOf('msie') !== -1,
                    version   = parseInt(ua.substr(4, 2), 10);

                // Internet Explorer 8 and lower
                if (isIE && version < 9) {
                    var link = document.createElement('a');
                    link.href = url;
                    document.body.appendChild(link);
                    link.click();
                }

                // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like Internet Explorer 8 & lower does)
                else {
                    window.location.href = url;
                }
            }



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

                <!-- Detached content -->
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
                                            <a href="" id="reply_button" class="btn btn-default"><i class="icon-reply"></i> <span class="hidden-xs position-right">Reply</span></a>
                                            <a href="mail_write.html" class="btn btn-default"><i class="icon-reply-all"></i> <span class="hidden-xs position-right">Reply to all</span></a>
                                            <a href="mail_write.html" class="btn btn-default"><i class="icon-forward"></i> <span class="hidden-xs position-right">Forward</span></a>
                                            <a href="#" class="btn btn-default"><i class="icon-bin"></i> <span class="hidden-xs position-right">Delete</span></a>

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
                                            <p class="navbar-text">12:49 pm</p>
                                            <div class="btn-group navbar-btn">
                                                <a href="#" id="print_button" class="btn btn-default"><i class="icon-printer"></i> <span class="hidden-xs position-right">Print</span></a>
                                                <a href="#" class="btn btn-default"><i class="icon-new-tab2"></i> <span class="hidden-xs position-right">Share</span></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /mail toolbar -->


                            <!-- Mail details -->
                            <div class="media stack-media-on-mobile mail-details-read">
                                <a href="#" class="media-left">
										<span class="btn bg-teal-400 btn-rounded btn-icon btn-xlg">
											<span class="letter-icon"></span>
										</span>
                                </a>

                                <div class="media-body">
                                    <c:if test="${message.messageVO.messageSubject eq null}">
                                        <h6 class="media-heading">[NO SUBJECT]</h6>
                                    </c:if>
                                    <c:if test="${message.messageVO.messageSubject ne null}">
                                        <h6 class="media-heading">${message.messageVO.messageSubject}</h6>
                                    </c:if>
                                    <c:if test="${message.messageVO.messageSubject eq ''}">
                                        <h6 class="media-heading">[NO SUBJECT]</h6>
                                    </c:if>
                                    <div class="letter-icon-title text-semibold">${message.userFrom.employeeVO.employeeName}<a id="user_email" href="${pageContext.request.contextPath}/message-compose/?to=${message.userFrom.username}">&nbsp;&nbsp;&lt;${message.userFrom.username}&gt;</a></div>
                                </div>

                                <div class="media-right media-middle text-nowrap">
                                    <ul class="list-inline list-inline-condensed no-margin">
                                        <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/placeholder.jpg" class="img-circle img-xs" alt=""></a></li>
                                        <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/placeholder.jpg" class="img-circle img-xs" alt=""></a></li>
                                        <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/placeholder.jpg" class="img-circle img-xs" alt=""></a></li>
                                        <!--<li><span class="btn bg-teal-400 btn-xs">+26</span></li>-->
                                    </ul>
                                </div>
                            </div>
                            <!-- /mail details -->


                            <!-- Mail container -->
                            <div class="mail-container-read">

                                ${message.messageVO.message}

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
                                                <li><a href="#">Download</a></li>
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
                                                <li><a href="#">Download</a></li>
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
