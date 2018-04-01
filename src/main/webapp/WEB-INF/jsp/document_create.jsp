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


    <!-- Theme JS files -->

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/editors/summernote/summernote.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/forms/styling/uniform.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/loaders/progressbar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/notifications/pnotify.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/editor_summernote.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/print/html2canvas.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pages/components_loaders.js"></script>
    <!-- /theme JS files -->

    <script type="text/javascript">
        $(document).ready(function(){

            $('#document_tab').addClass('active');
            $('#document_create_tab').addClass('active');
            $('#document_block').css('display','block');

            $('#save_button').on('click',function(){
                //alert('saved');


                var dark = $('#editor-window');
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
                    jsondata["username"] = "1";
                    jsondata["documentContent"] = val;
                    jsondata["screen_shot"] = dataUrl;
                    //alert(JSON.stringify(jsondata));
                    $.ajax({
                        type: 'POST',
                        async: false,
                        url: 'http://localhost:8080/rest/document/post',
                        data: JSON.stringify(jsondata),
                        success: function(data) {
                            //alert('data: ' + data);
                            $(dark).unblock();
                            new PNotify({
                                title: '<strong><i class="fa fa-check-square"></i>&nbsp;&nbsp;&nbsp;Document Saved</strong>',
                                text: 'Check me out! I\'m a notice.',
                                addclass: 'bg-success'
                            });
                        },
                        contentType: "application/json",
                        dataType: 'json',
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            new PNotify({
                                title: '<strong>Error</strong>',
                                text: 'Unable to save document, <br> Please try after sometime.',
                                addclass: 'bg-warning'
                            });
                        },
                        complete: function(){
                            $(dark).unblock();
                        }
                    });


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




                <!-- Summernote click to edit -->
                <div class="panel panel-flat" id="editor-window">
                    <div class="panel-heading">
                        <h5 class="panel-title">Create new doucment</h5>
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
                                        <button type="button" id="edit" class="btn btn-primary"><i class="icon-pencil3 position-left"></i> Edit</button>
                                        <button type="button" id="save_button" class="btn btn-success"><i class="icon-checkmark3 position-left"></i> Save</button>
                                    </span>
                                </div>
                            </div>
                        </div>

                        <br>
                        <br>

                        <div class="form-group">

                        <div class="click2edit">
                            <h2>Apollo 11</h2>
                            <div class="pull-right" style="margin-left: 20px;"><img alt="Saturn V carrying Apollo 11" class="right" src="http://c.cksource.com/a/1/img/sample.jpg"></div>

                            <p><strong>Apollo 11</strong> was the spaceflight that landed the first humans, Americans <a href="#">Neil Armstrong</a> and <a href="#">Buzz Aldrin</a>, on the Moon on July 20, 1969, at 20:18 UTC. Armstrong became the first to step onto the lunar surface 6 hours later on July 21 at 02:56 UTC.</p>

                            <p class="mb-15">Armstrong spent about <s>three and a half</s> two and a half hours outside the spacecraft, Aldrin slightly less; and together they collected 47.5 pounds (21.5&nbsp;kg) of lunar material for return to Earth. A third member of the mission, <a href="#">Michael Collins</a>, piloted the <a href="#">command</a> spacecraft alone in lunar orbit until Armstrong and Aldrin returned to it for the trip back to Earth.</p>

                            <h5 class="text-semibold">Technical details</h5>
                            <p>Launched by a <strong>Saturn V</strong> rocket from <a href="#">Kennedy Space Center</a> in Merritt Island, Florida on July 16, Apollo 11 was the fifth manned mission of <a href="#">NASA</a>'s Apollo program. The Apollo spacecraft had three parts:</p>
                            <ol>
                                <li><strong>Command Module</strong> with a cabin for the three astronauts which was the only part which landed back on Earth</li>
                                <li><strong>Service Module</strong> which supported the Command Module with propulsion, electrical power, oxygen and water</li>
                                <li><strong>Lunar Module</strong> for landing on the Moon.</li>
                            </ol>
                            <p class="mb-15">After being sent to the Moon by the Saturn V's upper stage, the astronauts separated the spacecraft from it and travelled for three days until they entered into lunar orbit. Armstrong and Aldrin then moved into the Lunar Module and landed in the <a href="#">Sea of Tranquility</a>. They stayed a total of about 21 and a half hours on the lunar surface. After lifting off in the upper part of the Lunar Module and rejoining Collins in the Command Module, they returned to Earth and landed in the <a href="#">Pacific Ocean</a> on July 24.</p>

                            <h5 class="text-semibold">Misson crew</h5>
                            <div class="table-responsive mb-15">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>Position</th>
                                        <th>Astronaut</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>Commander</td>
                                        <td>Neil A. Armstrong</td>
                                    </tr>
                                    <tr>
                                        <td>Command Module Pilot</td>
                                        <td>Michael Collins</td>
                                    </tr>
                                    <tr>
                                        <td>Lunar Module Pilot</td>
                                        <td>Edwin "Buzz" E. Aldrin, Jr.</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                            Source: <a href="http://en.wikipedia.org/wiki/Apollo_11">Wikipedia.org</a>
                        </div>
                    </div>
                </div>
                </div>
                <!-- /summernote click to edit -->





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
