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
	<script type="text/javascript" src="assets/js/core/app.js"></script>
	<!-- /theme JS files -->

    <script type="text/javascript">
         $(document).ready(function(){

             $('#dashboard_tab').addClass('active');



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

					<!-- Simple panel -->
					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Simple panel</h5>
							<div class="heading-elements">
								<ul class="icons-list">
			                		<li><a data-action="collapse"></a></li>
			                		<li><a data-action="close"></a></li>
			                	</ul>
		                	</div>
						</div>

						<div class="panel-body">
							<h6 class="text-semibold">Start your development with no hassle!</h6>
							<p class="content-group">Common problem of templates is that all code is deeply integrated into the core. This limits your freedom in decreasing amount of code, i.e. it becomes pretty difficult to remove unnecessary code from the project. Limitless allows you to remove unnecessary and extra code easily just by removing the path to specific LESS file with component styling. All plugins and their options are also in separate files. Use only components you actually need!</p>

							<h6 class="text-semibold">What is this?</h6>
							<p class="content-group">Starter kit is a set of pages, useful for developers to start development process from scratch. Each layout includes base components only: layout, page kits, color system which is still optional, bootstrap files and bootstrap overrides. No extra CSS/JS files and markup. CSS files are compiled without any plugins or components. Starter kit was moved to a separate folder for better accessibility.</p>

							<h6 class="text-semibold">How does it work?</h6>
							<p>You open one of the starter pages, add necessary plugins, uncomment paths to files in components.less file, compile new CSS. That's it. I'd also recommend to open one of main pages with functionality you need and copy all paths/JS code from there to your new page, it's just faster and easier.</p>
						</div>
					</div>
					<!-- /simple panel -->


					<!-- Table -->
					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Basic table</h5>
							<div class="heading-elements">
								<ul class="icons-list">
			                		<li><a data-action="collapse"></a></li>
			                		<li><a data-action="close"></a></li>
			                	</ul>
		                	</div>
	                	</div>

	                	<div class="panel-body">
	                		Starter pages include the most basic components that may help you start your development process - basic grid example, panel, table and form layouts with standard components. Nothing extra.
	                	</div>

						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Username</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Eugene</td>
										<td>Kopyov</td>
										<td>@Kopyov</td>
									</tr>
									<tr>
										<td>2</td>
										<td>Victoria</td>
										<td>Baker</td>
										<td>@Vicky</td>
									</tr>
									<tr>
										<td>3</td>
										<td>James</td>
										<td>Alexander</td>
										<td>@Alex</td>
									</tr>
									<tr>
										<td>4</td>
										<td>Franklin</td>
										<td>Morrison</td>
										<td>@Frank</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /table -->


					<!-- Grid -->
					<div class="row">
						<div class="col-md-6">

							<!-- Horizontal form -->
							<div class="panel panel-flat">
								<div class="panel-heading">
									<h5 class="panel-title">Horizontal form</h5>
									<div class="heading-elements">
										<ul class="icons-list">
					                		<li><a data-action="collapse"></a></li>
					                		<li><a data-action="close"></a></li>
					                	</ul>
				                	</div>
			                	</div>

								<div class="panel-body">
									<form class="form-horizontal" action="#">
										<div class="form-group">
											<label class="control-label col-lg-2">Text input</label>
											<div class="col-lg-10">
												<input type="text" class="form-control">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-lg-2">Password</label>
											<div class="col-lg-10">
												<input type="password" class="form-control">
											</div>
										</div>

				                        <div class="form-group">
				                        	<label class="control-label col-lg-2">Select</label>
				                        	<div class="col-lg-10">
					                            <select name="select" class="form-control">
					                                <option value="opt1">Basic select</option>
					                                <option value="opt2">Option 2</option>
					                                <option value="opt3">Option 3</option>
					                                <option value="opt4">Option 4</option>
					                                <option value="opt5">Option 5</option>
					                                <option value="opt6">Option 6</option>
					                                <option value="opt7">Option 7</option>
					                                <option value="opt8">Option 8</option>
					                            </select>
				                            </div>
				                        </div>

										<div class="form-group">
											<label class="control-label col-lg-2">Textarea</label>
											<div class="col-lg-10">
												<textarea rows="5" cols="5" class="form-control" placeholder="Default textarea"></textarea>
											</div>
										</div>

										<div class="text-right">
											<button type="submit" class="btn btn-primary">Submit form <i class="icon-arrow-right14 position-right"></i></button>
										</div>
									</form>
								</div>
							</div>
							<!-- /horizotal form -->

						</div>

						<div class="col-md-6">

							<!-- Vertical form -->
							<div class="panel panel-flat">
								<div class="panel-heading">
									<h5 class="panel-title">Vertical form</h5>
									<div class="heading-elements">
										<ul class="icons-list">
					                		<li><a data-action="collapse"></a></li>
					                		<li><a data-action="close"></a></li>
					                	</ul>
				                	</div>
			                	</div>

								<div class="panel-body">
									<form action="#">
										<div class="form-group">
											<label>Text input</label>
											<input type="text" class="form-control">
										</div>

				                        <div class="form-group">
				                        	<label>Select</label>
				                            <select name="select" class="form-control">
				                                <option value="opt1">Basic select</option>
				                                <option value="opt2">Option 2</option>
				                                <option value="opt3">Option 3</option>
				                                <option value="opt4">Option 4</option>
				                                <option value="opt5">Option 5</option>
				                                <option value="opt6">Option 6</option>
				                                <option value="opt7">Option 7</option>
				                                <option value="opt8">Option 8</option>
				                            </select>
				                        </div>

										<div class="form-group">
											<label>Textarea</label>
											<textarea rows="4" cols="4" class="form-control" placeholder="Default textarea"></textarea>
										</div>

										<div class="text-right">
											<button type="submit" class="btn btn-primary">Submit form <i class="icon-arrow-right14 position-right"></i></button>
										</div>
									</form>
								</div>
							</div>
							<!-- /vertical form -->

						</div>
					</div>
					<!-- /grid -->


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
