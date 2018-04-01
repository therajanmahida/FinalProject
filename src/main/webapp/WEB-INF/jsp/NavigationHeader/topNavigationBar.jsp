<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13/3/18
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
