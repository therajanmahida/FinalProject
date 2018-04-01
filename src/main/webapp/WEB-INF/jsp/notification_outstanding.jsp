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
    <script type="text/javascript" src="assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/core/libraries/bootstrap.min.js"></script>
    <!-- /core JS files -->


    <!-- Theme JS files -->
    <script type="text/javascript" src="assets/js/plugins/tables/datatables/datatables.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/tables/datatables/extensions/buttons.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/notifications/sweet_alert.min.js"></script>

    <script type="text/javascript" src="assets/js/core/app.js"></script>
    <script type="text/javascript" src="assets/js/pages/datatables_extension_buttons_init.js"></script>
    <!-- /theme JS files -->


    <script type="text/javascript">
        $(document).ready(function(){

            $('#notification_tab').addClass('active');
            $('#notification_outstanding_tab').addClass('active');
            $('#notification_block').css('display','block');


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

                <!-- Custom button -->
                <div class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Custom button</h5>
                        <div class="heading-elements">
                            <ul class="icons-list">
                                <li><a data-action="collapse"></a></li>
                                <li><a data-action="reload"></a></li>
                                <li><a data-action="close"></a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="panel-body">
                        This example shows a single button that is specified using the <code>buttons.buttons.text</code> and <code>buttons.buttons.action</code> parameters only - it simply shows an alert when activated, but any Javascript function could be run when the button is activated. All parameters are optional, and each plug-in button type can also specify its own parameters. Also this example shows how buttons can have optional classes.
                    </div>

                    <table class="table datatable-button-init-custom">
                        <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Job Title</th>
                            <th>DOB</th>
                            <th>Status</th>
                            <th>Salary</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Marth</td>
                            <td><a href="#">Enright</a></td>
                            <td>Traffic Court Referee</td>
                            <td>22 Jun 1972</td>
                            <td><span class="label label-success">Active</span></td>
                            <td>$85,600</td>
                        </tr>
                        <tr>
                            <td>Jackelyn</td>
                            <td>Weible</td>
                            <td><a href="#">Airline Transport Pilot</a></td>
                            <td>3 Oct 1981</td>
                            <td><span class="label label-default">Inactive</span></td>
                            <td>$106,450</td>
                        </tr>
                        <tr>
                            <td>Aura</td>
                            <td>Hard</td>
                            <td>Business Services Sales Representative</td>
                            <td>19 Apr 1969</td>
                            <td><span class="label label-danger">Suspended</span></td>
                            <td>$237,500</td>
                        </tr>
                        <tr>
                            <td>Nathalie</td>
                            <td><a href="#">Pretty</a></td>
                            <td>Drywall Stripper</td>
                            <td>13 Dec 1977</td>
                            <td><span class="label label-info">Pending</span></td>
                            <td>$198,500</td>
                        </tr>
                        <tr>
                            <td>Sharan</td>
                            <td>Leland</td>
                            <td>Aviation Tactical Readiness Officer</td>
                            <td>30 Dec 1991</td>
                            <td><span class="label label-default">Inactive</span></td>
                            <td>$470,600</td>
                        </tr>
                        <tr>
                            <td>Maxine</td>
                            <td><a href="#">Woldt</a></td>
                            <td><a href="#">Business Services Sales Representative</a></td>
                            <td>17 Oct 1987</td>
                            <td><span class="label label-info">Pending</span></td>
                            <td>$90,560</td>
                        </tr>
                        <tr>
                            <td>Sylvia</td>
                            <td><a href="#">Mcgaughy</a></td>
                            <td>Hemodialysis Technician</td>
                            <td>11 Nov 1983</td>
                            <td><span class="label label-danger">Suspended</span></td>
                            <td>$103,600</td>
                        </tr>
                        <tr>
                            <td>Lizzee</td>
                            <td><a href="#">Goodlow</a></td>
                            <td>Technical Services Librarian</td>
                            <td>1 Nov 1961</td>
                            <td><span class="label label-danger">Suspended</span></td>
                            <td>$205,500</td>
                        </tr>
                        <tr>
                            <td>Kennedy</td>
                            <td>Haley</td>
                            <td>Senior Marketing Designer</td>
                            <td>18 Dec 1960</td>
                            <td><span class="label label-success">Active</span></td>
                            <td>$137,500</td>
                        </tr>
                        <tr>
                            <td>Chantal</td>
                            <td><a href="#">Nailor</a></td>
                            <td>Technical Services Librarian</td>
                            <td>10 Jan 1980</td>
                            <td><span class="label label-default">Inactive</span></td>
                            <td>$372,000</td>
                        </tr>
                        <tr>
                            <td>Delma</td>
                            <td>Bonds</td>
                            <td>Lead Brand Manager</td>
                            <td>21 Dec 1968</td>
                            <td><span class="label label-info">Pending</span></td>
                            <td>$162,700</td>
                        </tr>
                        <tr>
                            <td>Roland</td>
                            <td>Salmos</td>
                            <td><a href="#">Senior Program Developer</a></td>
                            <td>5 Jun 1986</td>
                            <td><span class="label label-default">Inactive</span></td>
                            <td>$433,060</td>
                        </tr>
                        <tr>
                            <td>Coy</td>
                            <td>Wollard</td>
                            <td>Customer Service Operator</td>
                            <td>12 Oct 1982</td>
                            <td><span class="label label-success">Active</span></td>
                            <td>$86,000</td>
                        </tr>
                        <tr>
                            <td>Maxwell</td>
                            <td>Maben</td>
                            <td>Regional Representative</td>
                            <td>25 Feb 1988</td>
                            <td><span class="label label-danger">Suspended</span></td>
                            <td>$130,500</td>
                        </tr>
                        <tr>
                            <td>Cicely</td>
                            <td>Sigler</td>
                            <td><a href="#">Senior Research Officer</a></td>
                            <td>15 Mar 1960</td>
                            <td><span class="label label-info">Pending</span></td>
                            <td>$159,000</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /custom button -->

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
