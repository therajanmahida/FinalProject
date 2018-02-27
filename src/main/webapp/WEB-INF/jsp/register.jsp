<%--
  Created by IntelliJ IDEA.
  User: tarang
  Date: 26/2/18
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="../metaHeaders/commonMetaHeader.jsp"></jsp:include>

    <!-- App favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
    <!-- App title -->
    <title>Register</title>

    <jsp:include page="../cssHeader/commonCssHeader.jsp"></jsp:include>
    <jsp:include page="../scriptHeader/commonScriptHeader.jsp"></jsp:include>
</head>


<body class="bg-transparent">

<!-- HOME -->
<section>
    <div class="container-alt">
        <div class="row">
            <div class="col-sm-12">

                <div class="wrapper-page">

                    <div class="m-t-40 account-pages">
                        <div class="text-center account-logo-box">
                            <h2 class="text-uppercase">
                                <a href="index.html" class="text-success">
                                    <span><img src="assets/images/logo.png" alt="" height="36"></span>
                                </a>
                            </h2>
                            <!--<h4 class="text-uppercase font-bold m-b-0">Sign In</h4>-->
                        </div>
                        <div class="account-content">
                            <form class="form-horizontal" action="#">

                                <div class="form-group ">
                                    <div class="col-xs-12">
                                        <input class="form-control" type="email" required="" placeholder="Email">
                                    </div>
                                </div>

                                <div class="form-group ">
                                    <div class="col-xs-12">
                                        <input class="form-control" type="text" required="" placeholder="Username">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input class="form-control" type="password" required="" placeholder="Password">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <div class="checkbox checkbox-success">
                                            <input id="checkbox-signup" type="checkbox" checked="checked">
                                            <label for="checkbox-signup">I accept <a href="#">Terms and Conditions</a></label>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group account-btn text-center m-t-10">
                                    <div class="col-xs-12">
                                        <button class="btn w-md btn-danger btn-bordered waves-effect waves-light" type="submit">Register</button>
                                    </div>
                                </div>

                            </form>

                            <div class="clearfix"></div>

                        </div>
                    </div>
                    <!-- end card-box-->


                    <div class="row m-t-50">
                        <div class="col-sm-12 text-center">
                            <p class="text-muted">Already have account?<a href="login.html" class="text-primary m-l-5"><b>Sign In</b></a></p>
                        </div>
                    </div>

                </div>
                <!-- end wrapper -->

            </div>
        </div>
    </div>
</section>
<!-- END HOME -->





<jsp:include page="../scriptFooter/commonScriptJqueryFooter.jsp"></jsp:include>
<jsp:include page="../scriptFooter/commonScriptAppFooter.jsp"></jsp:include>
</body>
</html>
