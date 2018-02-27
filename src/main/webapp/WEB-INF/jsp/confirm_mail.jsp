<%--
  Created by IntelliJ IDEA.
  User: tarang
  Date: 27/2/18
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Mail</title>
    <jsp:include page="../metaHeaders/commonMetaHeader.jsp"></jsp:include>

    <!-- App favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
    <!-- App title -->
    <title>Login</title>

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
                                <div class="text-center m-b-20">
                                    <div class="m-b-20">
                                        <div class="checkmark">
                                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                 viewBox="0 0 161.2 161.2" enable-background="new 0 0 161.2 161.2" xml:space="preserve">
                                                        <path class="path" fill="none" stroke="#4bd396" stroke-miterlimit="10" d="M425.9,52.1L425.9,52.1c-2.2-2.6-6-2.6-8.3-0.1l-42.7,46.2l-14.3-16.4
                                                            c-2.3-2.7-6.2-2.7-8.6-0.1c-1.9,2.1-2,5.6-0.1,7.7l17.6,20.3c0.2,0.3,0.4,0.6,0.6,0.9c1.8,2,4.4,2.5,6.6,1.4c0.7-0.3,1.4-0.8,2-1.5
                                                            c0.3-0.3,0.5-0.6,0.7-0.9l46.3-50.1C427.7,57.5,427.7,54.2,425.9,52.1z"/>
                                                <circle class="path" fill="none" stroke="#4bd396" stroke-width="4" stroke-miterlimit="10" cx="80.6" cy="80.6" r="62.1"/>
                                                <polyline class="path" fill="none" stroke="#4bd396" stroke-width="6" stroke-linecap="round" stroke-miterlimit="10" points="113,52.8
                                                            74.1,108.4 48.2,86.4 "/>

                                                <circle class="spin" fill="none" stroke="#4bd396" stroke-width="4" stroke-miterlimit="10" stroke-dasharray="12.2175,12.2175" cx="80.6" cy="80.6" r="73.9"/>

                                                    </svg>
                                        </div>
                                    </div>

                                    <p class="text-muted font-13 m-t-10"> A email has been send to <b>youremail@domain.com</b>. Please check for an email from company and click on the included link to reset your password. </p>
                                </div>

                            </div>
                        </div>
                        <!-- end card-box-->


                        <div class="row m-t-30">
                            <div class="col-sm-12 text-center">
                                <p class="text-muted">Return to <a href="page-login.html" class="text-primary m-l-5"><b>Sign In</b></a></p>
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
