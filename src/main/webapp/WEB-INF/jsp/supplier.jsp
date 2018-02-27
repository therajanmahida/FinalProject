<%--
  Created by IntelliJ IDEA.
  User: tarang
  Date: 27/2/18
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../metaHeaders/commonMetaHeader.jsp"></jsp:include>


    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <title>Supplier</title>

    <!-- App css -->
    <jsp:include page="../cssHeader/commonCssHeader.jsp"></jsp:include>
    <jsp:include page="../cssHeader/homeCssHeader.jsp"></jsp:include>



    <jsp:include page="../scriptHeader/commonScriptHeader.jsp"></jsp:include>
</head>
<body>

    <jsp:include page="../NavigationHeader/navigationBarHeader.jsp"></jsp:include>



    <!-- Page-Title -->
    <div class="row">
        <div class="col-sm-12">
            <div class="page-title-box">
                <div class="btn-group pull-right">
                    <ol class="breadcrumb hide-phone p-0 m-0">
                        <li>
                            <a href="#">Zircos</a>
                        </li>
                        <li>
                            <a href="#">Pages</a>
                        </li>
                        <li class="active">
                            Starter Page
                        </li>
                    </ol>
                </div>
                <h4 class="page-title">Starter Page</h4>
            </div>
        </div>
    </div>
    <!-- end page title end breadcrumb -->



    <jsp:include page="../companyFooter/companyFooter.jsp"></jsp:include>


    <jsp:include page="../scriptFooter/commonScriptJqueryFooter.jsp"></jsp:include>

    <script src="../plugins/switchery/switchery.min.js"></script>

    <jsp:include page="../scriptFooter/commonScriptAppFooter.jsp"></jsp:include>
    <script type="text/javascript">
        $(document).ready(function(){
            var _message_tab = $('#supplier_tab');
            _message_tab.addClass("active");


        });
    </script>
</body>
</html>
