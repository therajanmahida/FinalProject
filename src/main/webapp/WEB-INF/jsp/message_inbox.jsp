<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/pnotify.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/bootbox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/sweet_alert.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/libraries/jasny_bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/mail_list.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_modals.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_notifications_pnotify.js"></script>
    <!-- /theme JS files -->

    <script type="text/javascript">
        $(document).ready(function(){

            $('#message_tab').addClass('active');
            $('#message_inbox_tab').addClass('active');
            $('#message_block').css('display','block')

            //mail selector based on main check box
            $('#select_main').on('click',function(){
                var selected = $(this).closest('span').attr('class');
                if(selected === 'checked'){

                    $.fn.mailSelect('all');


                }else{

                    $.fn.mailSelect('none');

                }
            });


            //mail selector
            $.fn.extend({
                mailSelect: function(y){
                    var input = $('table input[type=checkbox]');
                    input.each(function(){
                        var obj = $(this).closest('span');
                        var selected = $(this).closest('span').attr('class');
                        if(y === 'all'){
                            obj.addClass('checked');
                        }else{
                            if( y === 'none'){
                                obj.removeClass('checked');
                            }
                        }
                    })

                }
            });

            //via button select all button select all
            $('#select_all_button').on('click',function(){
                $.fn.mailSelect('all');
            });

            $('#unselect_all_button').on('click',function(){
                $.fn.mailSelect('none');
            });

            $('#select_unread_button').on('click',function(){
                var unreadmessage = $('.table .unread');
                unreadmessage.each(function(){
                   var input = $(this).find('input');
                    var obj = input.closest('span');
                    obj.addClass('checked');
                });
            });

            $('#select_read_button').on('click',function(){
                var unreadmessage = $(".table tr:not('.unread')");
                unreadmessage.each(function(){
                    var input = $(this).find('input');
                    var obj = input.closest('span');
                    obj.addClass('checked');
                });
            });

           $('#message_delete_confirm_button').on('click',function(){


               var unreadmessage = $(".table tr");
               var error_status = false;
               var sucess_status = false;
               unreadmessage.each(function(){
                   var selected = $(this).find('input').closest('span').attr('class');
                   if(selected == 'checked'){
                       sucess_status = false;
                       //alert("${pageContext.request.contextPath}/rest/messageto/delete/id/"+$(this).closest("tr").attr("id"));
                       $.ajax({
                           type: "GET",
                           dataType: "json",
                           async: false,
                           url: "${pageContext.request.contextPath}/rest/messageto/delete/id/"+$(this).closest("tr").attr("id"),
                           success: function(){
                               sucess_status = true;
                               $(this).remove();
                           },
                           error: function(){

                               error_status == true;

                           },
                           complete: function () {

                           }
                       });

                       if(sucess_status == true){
                           $(this).remove();
                       }

                   }

               });

               $('#modal_theme_warning').modal('hide');
           });


            $('.email-click').on('click',function(){
                //alert('hi');
                var message_id = $(this).closest("tr").attr('id');
                $('input[name=doc_id]').val(message_id);
                //$('#document_selected').submit();
                window.location.replace("/message/read/?doc_id="+message_id);
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



                <!--Single line-->
                <div class="panel panel-white">
                    <div class="panel-heading">
                        <h6 class="panel-title">My Inbox (single line)</h6>

                        <div class="heading-elements not-collapsible">
                            <span class="label bg-blue heading-text">${sessionScope.get("new_message_today")} new today</span>
                        </div>
                    </div>

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
                                    <button type="button" class="btn btn-default btn-icon btn-checkbox-all">
                                        <input id="select_main" type="checkbox" class="styled">
                                    </button>

                                    <button type="button" class="btn btn-default btn-icon dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                    </button>

                                    <ul class="dropdown-menu">
                                        <li><a id="select_all_button" href="#">Select all</a></li>
                                        <li><a id="select_read_button" href="#">Select read</a></li>
                                        <li><a id="select_unread_button" href="#">Select unread</a></li>
                                        <li class="divider"></li>
                                        <li><a id="unselect_all_button" href="#">Clear selection</a></li>
                                    </ul>
                                </div>

                                <div class="btn-group navbar-btn">
                                    <a href="/message/compose" type="button" class="btn btn-default"><i class="icon-pencil7"></i> <span class="hidden-xs position-right">Compose</span></a>
                                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal_theme_warning"><i class="icon-bin"></i> <span class="hidden-xs position-right">Delete</span></button>

                                </div>

                                <div class="navbar-right">
                                    <p class="navbar-text"><span class="text-semibold">1-50</span> of <span class="text-semibold">528</span></p>

                                    <div class="btn-group navbar-left navbar-btn">
                                        <button type="button" class="btn btn-default btn-icon disabled"><i class="icon-arrow-left12"></i></button>
                                        <button type="button" class="btn btn-default btn-icon"><i class="icon-arrow-right13"></i></button>
                                    </div>

                                    <div class="btn-group navbar-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <i class="icon-cog3"></i>
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
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-inbox">
                            <tbody data-link="row" class="rowlink">


                            <c:forEach items="${message_list}" var="message">
                                <c:if test="${message.isRead eq 0}">
                                    <tr class="unread email-layout" id="${message.id}">
                                </c:if>
                                <c:if test="${message.isRead eq 1}">
                                    <tr class="email-layout" id="${message.id}">
                                </c:if>


                                    <td class="table-inbox-checkbox rowlink-skip">
                                        <input type="checkbox" class="styled">
                                    </td>
                                    <td class="table-inbox-star rowlink-skip">
                                        <a>
                                            <i class="icon-star-empty3 text-muted"></i>
                                        </a>
                                    </td>
                                    <div class="email-click">
                                        <td class="table-inbox-image email-click">
                                            <c:set var="senderEmail" value="${message.userFrom.username}" scope="request"></c:set>
                                            <%
                                                String senderE = (String)request.getAttribute("senderEmail");
                                                int index  = ((int)senderE.charAt(0))%4;
                                                switch (index){
                                                    case 0 : request.setAttribute("email-icon-color","blue");
                                                             break;
                                                    case 1 : request.setAttribute("email-icon-color","green");
                                                             break;
                                                    case 2 : request.setAttribute("email-icon-color","warning");
                                                             break;
                                                    case 3 : request.setAttribute("email-icon-color","indigo");
                                                             break;

                                                }

                                            %>


                                                <span class="btn bg-${requestScope.get("email-icon-color")}-400 btn-rounded btn-icon btn-xs">
                                                    <span class="letter-icon"></span>
                                                </span>
                                        </td>
                                        <td class="table-inbox-name email-click">
                                            <a>
                                                <div class="letter-icon-title text-default">${message.userFrom.username}</div>
                                            </a>
                                        </td>
                                        <td class="table-inbox-message email-click">
                                            <c:if test="${message.messageVO.messageSubject eq null}">
                                                <span class="table-inbox-subject">[NO SUBJECT]</span>
                                            </c:if>
                                            <c:if test="${message.messageVO.messageSubject ne null}">
                                                <span class="table-inbox-subject">${message.messageVO.messageSubject}</span>
                                            </c:if>
                                            <c:if test="${message.messageVO.messageSubject eq ''}">
                                                <span class="table-inbox-subject">[NO SUBJECT]</span>
                                            </c:if>
                                            <!--<span class="table-inbox-preview">To the London docks, you may have seen a crippled beggar (or KEDGER, as the sailors say) holding a painted board before him, representing the tragic scene in which he lost his leg</span>-->
                                        </td>
                                        <td class="table-inbox-attachment email-click">

                                        </td>
                                        <td class="table-inbox-time email-click">
                                            <c:set var="date" value="${message.messageVO.messageDate}" scope="request" />
                                            <c:set var="time" value="${message.messageVO.messageTime}" scope="request" />

                                            <%

                                                String now = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                                                Date now_date = new SimpleDateFormat("dd-MM-yyyy").parse(now);
                                                Date document = (Date)request.getAttribute("date");
                                                String date;
                                                if(document.compareTo(now_date) < 0){
                                                     date = new SimpleDateFormat("MMM dd").format(request.getAttribute("date"));
                                                }else{
                                                     date = new SimpleDateFormat("HH:mm a").format(request.getAttribute("time"));
                                                }

                                            %>
                                            <% out.print(date); %>
                                        </td>
                                    </div>
                                </tr>
                            </c:forEach>







                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /single line -->



                <!-- Footer -->
                <div class="footer text-muted">
                    &copy; 2015. <a href="#">Limitless Web App Kit</a> by <a href="http://themeforest.net/user/Kopyov" target="_blank">Eugene Kopyov</a>
                </div>
                <!-- /footer -->

                <!-- Warning modal -->
                <div id="modal_theme_warning" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header bg-warning">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h6 class="modal-title">Delete Email</h6>
                            </div>

                            <div class="modal-body">
                                <h6 class="text-semibold">Warning: </h6>
                                <p>Once the email is deleted shall not be recovered back.</p>

                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                                <button id="message_delete_confirm_button" type="button" class="btn btn-warning">Confirm Delete</button>
                            </div>

                        </div>

                    </div>
                </div>
                <!-- /warning modal -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->
    <form style="display: none" id="document_selected" action="${pageContext.request.contextPath}/message-read" method="post">
        <input type="text" name="doc_id"/>
    </form>
</body>
</html>
