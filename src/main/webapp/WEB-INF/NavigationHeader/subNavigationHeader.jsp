<%--
  Created by IntelliJ IDEA.
  User: tarang
  Date: 1/3/18
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <div class="container">

        <!-- Page-Title -->
        <div class="row">
            <div class="col-sm-12">
                <div class="page-title-box">
                    <div class="btn-group pull-right">
                        <ol class="breadcrumb hide-phone p-0 m-0">



                            <c:forEach var="page" items="${bread_crumb}">
                                <c:if test="${page.url ne null}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}${page.url}">${page.value}</a>
                                    </li>
                                </c:if>
                                <c:if test="${page.url eq null}">
                                    <li class="active">
                                            ${page.value}
                                    </li>
                                </c:if>
                            </c:forEach>


                        </ol>
                    </div>
                    <h4 class="page-title">${requestScope.get("page_name")}</h4>
                </div>
            </div>
        </div>
        <!-- end page title end breadcrumb -->


        <jsp:include page="../companyFooter/companyFooter.jsp"></jsp:include>

    </div> <!-- end container -->
</div>
<!-- end wrapper -->
