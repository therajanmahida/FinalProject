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
    <link href="assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="assets/css/icons/fontawesome/styles.min.css" rel="stylesheet" type="text/css">
    <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="assets/css/colors.css" rel="stylesheet" type="text/css">
    <!-- /global stylesheets -->

    <!-- Core JS files -->
    <script type="text/javascript" src="assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->

    <!-- Theme JS files -->
    <script type="text/javascript" src="assets/js/plugins/notifications/bootbox.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/notifications/sweet_alert.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="assets/js/core/libraries/jasny_bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/uniform.min.js"></script>

    <script type="text/javascript" src="assets/js/core/app.js"></script>
    <script type="text/javascript" src="assets/js/pages/mail_list.js"></script>
    <script type="text/javascript" src="assets/js/pages/components_modals.js"></script>
    <!-- /theme JS files -->

    <script type="text/javascript">
        $(document).ready(function(){

            $('#message_tab').addClass('active');
            $('#message_sent_tab').addClass('active');
            $('#message_block').css('display','block');

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
                alert('Do the delete ajax call here');

                var unreadmessage = $(".table tr");
                unreadmessage.each(function(){
                    var selected = $(this).find('input').closest('span').attr('class');
                    if(selected == 'checked'){
                        $(this).remove();
                    }
                });

                $('#modal_theme_warning').modal('hide');
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

        <!-- Main sidebar -->
        <div class="sidebar sidebar-main">
            <div class="sidebar-content">

                <!-- User menu -->
                <div class="sidebar-user">
                    <div class="category-content">
                        <div class="media">
                            <a href="#" class="media-left"><img src="assets/images/image.png" class="img-circle img-sm" alt=""></a>
                            <div class="media-body">
                                <span class="media-heading text-semibold">Victoria Baker</span>
                                <div class="text-size-mini text-muted">
                                    <i class="icon-pin text-size-small"></i> &nbsp;Santa Ana, CA
                                </div>
                            </div>

                            <div class="media-right media-middle">
                                <ul class="icons-list">
                                    <li>
                                        <a href="#"><i class="icon-cog3"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /user menu -->


                <!-- Main navigation -->
                <div class="sidebar-category sidebar-category-visible">
                    <div class="category-content no-padding">
                        <ul class="navigation navigation-main navigation-accordion">

                            <!-- Main -->
                            <li class="navigation-header"><span>Main</span> <i class="icon-menu" title="Main pages"></i></li>
                            <li id="dashboard_tab"><a href="dashboard.html"><i class="icon-home4"></i> <span>Dashboard</span></a></li>
                            <li id="staff_tab">
                                <a href="#"><i class="icon-users"></i> <span>Staff</span></a>
                                <ul id="employee_block">
                                    <li id="employee_tab">
                                        <a href="#">Employee</a>
                                        <ul id="employee_sub_block">
                                            <li id="employee_overview_tab"><a href="employee_overview.html">Overview</a></li>
                                            <li id="employee_registration_tab"><a href="employee_registration_one.html">Registration</a></li>
                                            <li id="employee_list_tab"><a href="employee_database.html">Database</a></li>
                                        </ul>

                                    </li>

                                    <li class="navigation-divider"></li>
                                    <li id="employee_task_tab"><a href="employee_tasks.html">Tasks</a></li>

                                </ul>
                            </li>
                            <li id="finance_tab">
                                <a href="#"><i class="icon-cash"></i> <span>Finance</span></a>
                                <ul id="finance_block">
                                    <li id="finance_transaction_tab"><a href="#">Transaction</a></li>
                                    <li id="finance_payments_tab"><a href="finance_payments.html">Payments</a></li>
                                    <li id="finance_client_order_tab"><a href="finance_client_order.html">Client Order</a></li>
                                    <li class="navigation-divider"></li>
                                    <li id="finance_monthly_reports_tab"><a href="finance_monthly_reports.html">Report</a></li>

                                </ul>
                            </li>
                            <li id="outlet_tab">
                                <a href="#"><i class="icon-office"></i> <span>Outlet</span></a>
                                <ul id="outlet_block">
                                    <li id="outlet_overview_tab"><a href="outelet_overview.html">Overview</a></li>
                                    <li id="outlet_payments_tab"><a href="outlet_payments.html">Payments</a></li>
                                    <li id="outlet_client_order_tab"><a href="outlet_client_order.html">Client Order</a></li>
                                    <li class="navigation-divider"></li>
                                    <li id="outelt_inventory_stocks_tab"><a href="outlet_inventory_stocks.html">Inventory Stocks</a></li>
                                </ul>
                            </li>
                            <li id="supplier_tab">
                                <a href="#"><i class="icon-store2"></i> <span>Supplier</span></a>
                                <ul id="supplier_block">
                                    <li id="supplier_overview_tab"><a href="#">Overview</a></li>
                                    <li>
                                        <a href="#">Management</a>
                                        <ul id="supplier_management_block">
                                            <li id="supplier_registration_tab"><a href="supplier_registration.html">Registration</a></li>
                                            <li id="supplier_database_tab"><a href="supplier_database.html">Database</a> </li>
                                        </ul>
                                    </li>
                                    <li class="navigation-divider"></li>
                                    <li id="supplier_outstanding_bills_tab"><a href="supplier_outstanding_bills.html">Outstanding Bills</a></li>
                                    <li id="supplier_report_tab"><a href="supplier_report.html">Reports</a></li>
                                </ul>
                            </li>
                            <li id="drugs_tab">
                                <a href="#"><i class="fa fa-medkit"></i> <span>Drugs</span></a>
                                <ul id="drug_block">
                                    <li id="drug_overview_tab"><a href="drug_overview.html">Overview</a></li>
                                    <li>
                                        <a href="#">Management</a>
                                        <ul id="drug_management_block">
                                            <li id="drug_add_tab"><a href="drug_add.html">Add</a></li>
                                            <li id="drug_database_tab"><a href="drug_database.html">Database</a></li>
                                        </ul>
                                    </li>
                                    <li class="navigation-divider"></li>
                                    <li>
                                        <a href="">Drug Info</a>
                                    <li id="drug_info_search_tab"><a href="drug_info_search.html">Drug Search</a></li>
                                    <li id="drug_info_database_tab"><a href="drug_info_database.html">Global Database</a></li>
                                    </li>
                                </ul>
                            </li>
                            <li id="bill_tab">
                                <a href="#"><i class="fa fa-credit-card"></i> <span>Bill</span></a>
                                <ul id="bill_block">
                                    <li id="bill_overview_tab"><a href="#">Overview</a></li>
                                    <li id="bill_payments.tab"><a href="bill_payment.html">Payment</a></li>
                                    <li id="bill_client_bill_tab"><a href="bill_client_bill.html">Client</a></li>
                                    <li id ="bill_supplier_bill_tab"><a href="bill_supplier_bill.html">Supplier</a></li>
                                    <li class="navigation-divider"></li>
                                    <li id="bill_settings_tab"><a href="bill_settings.html">Settings</a></li>
                                </ul>
                            </li>
                            <li id="message_tab">
                                <a href="#"><i class="icon-bubble-lines3"></i> <span>Message</span><span class="label label-info">5</span> </a>
                                <ul id="message_block">
                                    <li id="message_overview_tab"><a href="#"><i class="icon-primitive-dot"></i>Overview</a></li>
                                    <li id="message_inbox_tab"><a href="message_inbox.html"><i class="icon-inbox-alt"></i>Inbox</a></li>
                                    <li id="message_compose_tab"><a href="message_compose.html"><i class="icon-pencil4"></i>Compose</a></li>
                                    <li id="message_sent_tab"><a href="message_sent.html"><i class="fa fa-send"></i>Sent</a></li>
                                    <li class="navigation-divider"></li>
                                </ul>
                            </li>
                            <li id="notification_tab">
                                <a href="#"><i class="icon-bubble-notification"></i><span>Notification</span><span class="label label-danger">55</span> </a>
                                <ul id="notification_block">
                                    <li id="notification_outstanding_tab">
                                        <a href="notification_outstanding.html"> Outstanding<span class="label label-danger text-size-large">55</span></a>
                                    </li>
                                </ul>
                            </li>
                            <li id="document_tab">
                                <a href="#"><i class="icon-magazine"></i> <span>Document</span></a>
                                <ul id="document_block">
                                    <li id="document_create_tab"><a href="document_create.html"><i class="icon-pencil5"></i>Create</a></li>
                                    <li id="document_files_tab"><a href="document_files.html"><i class="icon-file-text3"></i>Files</a></li>
                                    <li  class="navigation-divider"></li>
                                    <li id="documents_deleted_tab"><a href="document_deleted.html"><i class="icon-bin2"></i>Deleted</a></li>
                                </ul>
                            </li>

                            <li><a href="../changelog.html"><i class="icon-list-unordered"></i> <span>Changelog</span></a></li>
                            <!-- /main -->

                        </ul>
                    </div>
                </div>
                <!-- /main navigation -->

            </div>
        </div>
        <!-- /main sidebar -->


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
                        <h6 class="panel-title">Sent Messages:</h6>

                        <div class="heading-elements not-collapsible">
                            <span class="label bg-blue heading-text">259 new today</span>
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
                                        <li class="divider"></li>
                                        <li><a id="unselect_all_button" href="#">Clear selection</a></li>
                                    </ul>
                                </div>

                                <div class="btn-group navbar-btn">
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
                            <tr class="unread">
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/brands/spotify.png" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Spotify</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">On Tower-hill, as you go down &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">To the London docks, you may have seen a crippled beggar (or KEDGER, as the sailors say) holding a painted board before him, representing the tragic scene in which he lost his leg</span>
                                </td>
                                <td class="table-inbox-attachment">

                                </td>
                                <td class="table-inbox-time">
                                    11:09 pm
                                </td>
                            </tr>

                            <tr class="unread">
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
											<span class="btn bg-warning-400 btn-rounded btn-icon btn-xs">
												<span class="letter-icon"></span>
											</span>
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">James Alexander</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject"><span class="label bg-success position-left">Promo</span> There are three whales and three boats &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">And one of the boats (presumed to contain the missing leg in all its original integrity) is being crunched by the jaws of the foremost whale</span>
                                </td>
                                <td class="table-inbox-attachment">
                                    <i class="icon-attachment text-muted"></i>
                                </td>
                                <td class="table-inbox-time">
                                    10:21 pm
                                </td>
                            </tr>

                            <tr class="unread">
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-full2 text-warning-300"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/placeholder.jpg" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Nathan Jacobson</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">Any time these ten years, they tell me, has that man held up &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">That picture, and exhibited that stump to an incredulous world. But the time of his justification has now come. His three whales are as good whales as were ever published in Wapping, at any rate; and his stump</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    8:37 pm
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-full2 text-warning-300"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
											<span class="btn bg-indigo-400 btn-rounded btn-icon btn-xs">
												<span class="letter-icon"></span>
											</span>
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Margo Baker</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">Throughout the Pacific, and also in Nantucket, and New Bedford &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">and Sag Harbor, you will come across lively sketches of whales and whaling-scenes, graven by the fishermen themselves on Sperm Whale-teeth, or ladies' busks wrought out of the Right Whale-bone</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    4:28 am
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/brands/dribbble.png" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Dribbble</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">The whalemen call the numerous little ingenious contrivances &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">They elaborately carve out of the rough material, in their hours of ocean leisure. Some of them have little boxes of dentistical-looking implements</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    Dec 5
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
											<span class="btn bg-brown-400 btn-rounded btn-icon btn-xs">
												<span class="letter-icon"></span>
											</span>
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Hanna Dorman</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">Some of them have little boxes of dentistical-looking implements &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">Specially intended for the skrimshandering business. But, in general, they toil with their jack-knives alone; and, with that almost omnipotent tool of the sailor</span>
                                </td>
                                <td class="table-inbox-attachment">
                                    <i class="icon-attachment text-muted"></i>
                                </td>
                                <td class="table-inbox-time">
                                    Dec 5
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/brands/twitter.png" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Twitter</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject"><span class="label bg-indigo-400 position-left">Order</span> Long exile from Christendom &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">And civilization inevitably restores a man to that condition in which God placed him, i.e. what is called savagery</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    Dec 4
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-full2 text-warning-300"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
											<span class="btn bg-pink-400 btn-rounded btn-icon btn-xs">
												<span class="letter-icon"></span>
											</span>
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Vanessa Aurelius</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">Your true whale-hunter is as much a savage as an Iroquois &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">I myself am a savage, owning no allegiance but to the King of the Cannibals; and ready at any moment to rebel against him. Now, one of the peculiar characteristics of the savage in his domestic hours</span>
                                </td>
                                <td class="table-inbox-attachment">
                                    <i class="icon-attachment text-muted"></i>
                                </td>
                                <td class="table-inbox-time">
                                    Dec 4
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/placeholder.jpg" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">William Brenson</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">An ancient Hawaiian war-club or spear-paddle &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">In its full multiplicity and elaboration of carving, is as great a trophy of human perseverance as a Latin lexicon. For, with but a bit of broken sea-shell or a shark's tooth</span>
                                </td>
                                <td class="table-inbox-attachment">
                                    <i class="icon-attachment text-muted"></i>
                                </td>
                                <td class="table-inbox-time">
                                    Dec 4
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/brands/facebook.png" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Facebook</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">As with the Hawaiian savage, so with the white sailor-savage &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">With the same marvellous patience, and with the same single shark's tooth, of his one poor jack-knife, he will carve you a bit of bone sculpture, not quite as workmanlike</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    Dec 3
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-full2 text-warning-300"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/placeholder.jpg" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Vicky Barna</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject"><span class="label bg-pink-400 position-left">Track</span> Achilles's shield &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">Wooden whales, or whales cut in profile out of the small dark slabs of the noble South Sea war-wood, are frequently met with in the forecastles of American whalers. Some of them are done with much accuracy</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    Dec 2
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/brands/youtube.png" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Youtube</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">At some old gable-roofed country houses &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">You will see brass whales hung by the tail for knockers to the road-side door. When the porter is sleepy, the anvil-headed whale would be best. But these knocking whales are seldom remarkable as faithful essays</span>
                                </td>
                                <td class="table-inbox-attachment">
                                    <i class="icon-attachment text-muted"></i>
                                </td>
                                <td class="table-inbox-time">
                                    Nov 30
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/placeholder.jpg" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Tony Gurrano</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">On the spires of some old-fashioned churches &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">You will see sheet-iron whales placed there for weather-cocks; but they are so elevated, and besides that are to all intents and purposes so labelled with "HANDS OFF!" you cannot examine them</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    Nov 28
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-empty3 text-muted"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
											<span class="btn bg-danger-400 btn-rounded btn-icon btn-xs">
												<span class="letter-icon"></span>
											</span>
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Barbara Walden</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">In bony, ribby regions of the earth &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">Where at the base of high broken cliffs masses of rock lie strewn in fantastic groupings upon the plain, you will often discover images as of the petrified forms</span>
                                </td>
                                <td class="table-inbox-attachment"></td>
                                <td class="table-inbox-time">
                                    Nov 28
                                </td>
                            </tr>

                            <tr>
                                <td class="table-inbox-checkbox rowlink-skip">
                                    <input type="checkbox" class="styled">
                                </td>
                                <td class="table-inbox-star rowlink-skip">
                                    <a href="mail_read.html">
                                        <i class="icon-star-full2 text-warning-300"></i>
                                    </a>
                                </td>
                                <td class="table-inbox-image">
                                    <img src="assets/images/brands/amazon.png" class="img-circle img-xs" alt="">
                                </td>
                                <td class="table-inbox-name">
                                    <a href="#">
                                        <div class="letter-icon-title text-default">Amazon</div>
                                    </a>
                                </td>
                                <td class="table-inbox-message">
                                    <span class="table-inbox-subject">Here and there from some lucky point of view &nbsp;-&nbsp;</span>
                                    <span class="table-inbox-preview">You will catch passing glimpses of the profiles of whales defined along the undulating ridges. But you must be a thorough whaleman, to see these sights; and not only that, but if you wish to return to such a sight again</span>
                                </td>
                                <td class="table-inbox-attachment">
                                    <i class="icon-attachment text-muted"></i>
                                </td>
                                <td class="table-inbox-time">
                                    Nov 27
                                </td>
                            </tr>
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
                                <hr>

                                <h6 class="text-semibold">Message list:</h6>
                                <p>Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
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

</body>
</html>
