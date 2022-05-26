<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Giảng Viên</title>
        <meta name="description" content="">
        <meta name="author" content="templatemo">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta:wght@300&family=Roboto+Condensed&display=swap" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet'>
        <link href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" rel="stylesheet">
        <link rel="icon" type="image/png" sizes="200x138" href=".././images/logo-vlu-removebg-preview.png">
        <!-- CSS -->
        <link href=".././css/admin/bootstrap.min.css" rel="stylesheet">
        <link href=".././css/admin/Style.css" rel="stylesheet">
    </head>
    <body ng-app="myapp" ng-controller="viewCril">
        <jsp:include page="../../layouts/admin/Loader.html"></jsp:include>
        
        <!-- Left column -->
        <div class="templatemo-flex-row">
            <jsp:include page="../../layouts/admin/NavBar.jsp"></jsp:include>

            <!-- Main content -->
            <div class="templatemo-content col-1 light-gray-bg">
                <div class="templatemo-top-nav-container">
                    <div class="row">
                        <nav class="templatemo-top-nav col-lg-12 col-md-12">
                            <ul class="text-uppercase">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/manage-teacher" class="active" style="font-size: 25px; font-weight: bold;">Thông Tin</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>

                <form class="templatemo-search-form" role="search" style="transform: translate(0px, 30px);">
                    <div class="input-group" style="margin-bottom: 10px;">
                        <button type="submit" class="fa fa-search"></button>
                        <input ng-model="searching" type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term" style="width: 289px;">
                    </div>

                    <a href="#">
                        <button ng-click="exportToExcel('#tableToExport')" style="display: inline-block;  border-radius: 5px; background-color:#39adb4; color: white; padding: 10px; border: transparent; font-size: 14px; margin-right: 15px;">
                            Xuất Danh Sách Ra Excel
                        </button>
                    </a>

                    <button onclick="openForm()" style="display: inline-block; border-radius: 5px; background-color:#39adb4; color: white; padding: 10px; border: transparent; color: #fff; font-size: 14px;">
                        Thêm Giảng Viên
                    </button>
                </form>

                <div class="templatemo-content-container" id="tableToExport">
                    <div class="templatemo-content-widget no-padding">
                        <div class="panel panel-default table-responsive">
                            <table class="table table-striped table-bordered templatemo-user-table">
                                <thead>
                                    <tr style="text-align: center;">
                                        <td>
                                            <a href="" class="white-text templatemo-sort-by">STT</a>
                                        </td>
                                        <td>
                                            <a href="" class="white-text templatemo-sort-by">Họ và Tên</a>
                                        </td>
                                        <td>
                                            <a href="" class="white-text templatemo-sort-by">SĐT</a>
                                        </td>
                                        <td>
                                            <a href="" class="white-text templatemo-sort-by">Email</a>
                                        </td>
                                        <td>Chỉnh sửa</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="course in listCourses| filter: searching">
                                        <td>{{$index + 1}}</td>
                                        <td>{{course.mentorName}}</td>
                                        <td>{{course.mentorPhone}}</td>
                                        <td>{{course.mentorEmail}}</td>
                                        <td style="text-align: center;">
                                            <button ng-click="edit($index)" onclick="openFormDemo()" class="buttom-edit">
                                                <i class="fas fa-edit" aria-hidden="true"></i>
                                            </button>
                                            <button ng-click="delete(course.mentorID)" class="buttom-delete">
                                                <i class="fa fa-trash" aria-hidden="true"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- =====================================pop-up add $ edit course============================================ -->
        <section id="add-edit">
            <div class="templatemo-flex-row flex-content-row">
                <div class="col-1">
                    <div class="panel panel-default margin-11">
                        <div class="panel-heading">
                            <h2 class="text-uppercase">Thêm Giảng Viên</h2>
                        </div>
                        
                        <div class="panel-body">
                            <form Khoa CNTT="index.html" class="templatemo-login-form">
                                <div class="form-group">
                                    <label for="inpuName">Họ và Tên</label>
                                    <input ng-model="test.mentorName" type="text" class="form-control" id="inputName" placeholder="Nhập Họ và Tên">
                                </div>

                                <div class="form-group">
                                    <label for="inputPhone">Số Điện Thoại</label>
                                    <input ng-model="test.mentorPhone" type="tel" class="form-control" placeholder="Nhập SĐT" id="inputPhone">
                                </div>

                                <div class="form-group">
                                    <label for="inputEmail">Email</label>
                                    <input ng-model="test.mentorEmail" type="email" class="form-control" id="inputEmail" placeholder="Nhập Email">
                                </div>

                                <div class="form-group">
                                    <button id="add" onclick="closeForm()" ng-click="save()" style="color: white;" type="submit" class="templatemo-blue-button">
                                        Thêm
                                    </button>

                                    <button id="update" onclick="closeForm()" ng-click="update()" style="color: white;" type="submit" class="templatemo-blue-button">
                                        Cập Nhật
                                    </button>

                                    <button class="templatemo-blue-button" type="submit" onclick="closeForm()" ng-click="cancel()" style="color: white;">
                                        Ðóng
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <!-- Root Page -->
        <script src=".././js/admin/RootPage.js"></script>
        <script src=".././js/admin/ManageTeacher.js"></script>
        <script>
            ManageTeacherAPI('${pageContext.request.contextPath}/admin/manage-teacher', ${MENTOR_LIST});
        </script>
    </body>
</html>
