
<!DOCTYPE html>
<html>

<!-- Mirrored from coderthemes.com/zircos_1.6/menu_2/page-starter.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 19 Dec 2016 04:21:55 GMT -->
<head>
    <jsp:include page="../metaHeaders/commonMetaHeader.jsp"></jsp:include>


    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <title>Zircos - Responsive Admin Dashboard Template</title>

    <!-- App css -->
    <jsp:include page="../cssHeader/commonCssHeader.jsp"></jsp:include>
    <jsp:include page="../cssHeader/homeCssHeader.jsp"></jsp:include>



    <jsp:include page="../scriptHeader/commonScriptHeader.jsp"></jsp:include>

</head>


<body>


    <jsp:include page="../NavigationHeader/navigationBarHeader.jsp"></jsp:include>


    <div class="row" style="margin-top: 40px">

        <div id="check" class="btn btn-primary">Hi</div>
        <div id="output"></div>

    </div>


    <jsp:include page="../companyFooter/companyFooter.jsp"></jsp:include>

    <jsp:include page="../scriptFooter/commonScriptJqueryFooter.jsp"></jsp:include>

    <script src="../plugins/switchery/switchery.min.js"></script>

    <jsp:include page="../scriptFooter/commonScriptAppFooter.jsp"></jsp:include>

    <script type="text/javascript">
        $(document).ready(function(){
            var button = $('#check');
            button.on("click",function () {

                $('#output').load("finance");
            });


        });
    </script>


</body>

<!-- Mirrored from coderthemes.com/zircos_1.6/menu_2/page-starter.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 19 Dec 2016 04:21:55 GMT -->
</html>