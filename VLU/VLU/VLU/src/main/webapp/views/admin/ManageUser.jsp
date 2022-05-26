<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Người Dùng</title>
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
                                    <a href="${pageContext.request.contextPath}/admin/manage-user" class="active" style="font-size: 25px; font-weight: bold;">Thông Tin</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                
                <form class="templatemo-search-form" role="search">
                    <div class="input-group" style="margin-bottom: 10px;">
                        <button type="submit" class="fa fa-search"></button>
                        <input ng-model="searching" type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term" style="width: 300px; font-size: 14px;">
                    </div>
                    
                    <a href="#">
                        <button ng-click="exportToExcel('#tableToExport')" style="display: inline-block;  border-radius: 5px; background-color:#39adb4; color: white; padding: 10px; border: transparent; font-size: 14px;">
                            Xuất Danh Sách Ra Excel
                        </button>
                    </a>
                </form>
                
                <div class="templatemo-content-widget no-padding" id="tableToExport">
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
                                    <td>Phòng Ban</td>
                                    <td>
                                        <a href="" class="white-text templatemo-sort-by">Hình Ảnh</a>
                                    </td>
                                    <td>Xóa</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-repeat="course in listCourses | filter: searching" style="text-align: center;">
                                    <td>{{$index + 1}}</td>
                                    <td>{{course.learnerName}}</td>
                                    <td>{{course.phoneNumber}}</td>
                                    <td>{{course.email}}</td>
                                    <td>{{course.departmentName}}</td>
                                    <td>
                                        <img src="{{course.imageAvatar}}" />
                                    </td>
                                    <td style="text-align: center;">
                                        <button ng-click="delete(course.learnerID)" class="buttom-delete">
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
        
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <!-- Root Page -->
        <script src=".././js/admin/RootPage.js"></script>
        <script src=".././js/admin/ManageUser.js"></script>
        <script>
            ManageUserAPI('${pageContext.request.contextPath}/admin/manage-user', ${LEARNER_ACCOUNT_LIST});
        </script>
    </body>
</html>
