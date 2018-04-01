<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13/3/18
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


                                        <li id="supplier_registration_tab"><a href="${pageContext.request.contextPath}/supplier/registration">Registration</a></li>
                                        <li id="supplier_database_tab"><a href="${pageContext.request.contextPath}/supplier/database">Database</a> </li>


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
                            <a href="#"><i class="icon-bubble-lines3"></i> <span>Message</span><span class="label label-info">${sessionScope.get("unread_message")}</span> </a>
                            <ul id="message_block">
                                <li id="message_overview_tab"><a href="#"><i class="icon-primitive-dot"></i>Overview</a></li>
                                <li id="message_inbox_tab"><a href="${pageContext.request.contextPath}/message/inbox"><i class="icon-inbox-alt"></i>Inbox<span class="label label-default">${sessionScope.get("total_message")}</span> </a></li>
                                <li id="message_compose_tab"><a href="${pageContext.request.contextPath}/message/compose"><i class="icon-pencil4"></i>Compose</a></li>
                                <li id="message_sent_tab"><a href="${pageContext.request.contextPath}/"><i class="fa fa-send"></i>Sent</a></li>
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
                                <li id="document_create_tab"><a href="${pageContext.request.contextPath}/document/create"><i class="icon-pencil5"></i>Create</a></li>
                                <li id="document_files_tab"><a href="${pageContext.request.contextPath}/document/files"><i class="icon-file-text3"></i>Files</a></li>
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