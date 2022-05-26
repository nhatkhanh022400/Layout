<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Phòng Ban</title>
        <meta name="description" content="">
        <meta name="author" content="templatemo">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta:wght@300&family=Roboto+Condensed&display=swap" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
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
                                    <a href="${pageContext.request.contextPath}/admin/manage-department" class="active" style="font-size: 25px; font-weight: bold;">Thông Tin</a>
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

                    <button onclick="openForm()" style="display: inline-block; border-radius: 5px; background-color:#39adb4; color: white; padding: 10px; border: transparent; color: #fff; font-size: 14px;">
                        Thêm Phòng Ban
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
                                            <a href="" class="white-text templatemo-sort-by">Tên Phòng Ban</a>
                                        </td>
                                        <td>Chỉnh sửa</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr style="text-align: center;" ng-repeat="department in listDepartments | filter: searching">
                                        <td>{{$index + 1}}</td>
                                        <td>{{department.departmentName}}</td>
                                        <td style="text-align: center;">
                                            <button ng-click="edit($index)" onclick="openFormDemo()" class="buttom-edit">
                                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                            </button>
                                            <button ng-click="delete(department.departmentID)" class="buttom-delete">
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
                                
        <!-- ============================================= Pop Up ====================================== -->
        <section id="add-edit" style="padding: 10% 25%;">
            <div class="templatemo-flex-row flex-content-row">
                <div class="col-1">
                    <div class="panel panel-default margin-11">
                        <div class="panel-heading">
                            <h2 class="text-uppercase">Thêm Phòng Ban</h2>
                        </div>
                        <div class="panel-body">
                            <form Khoa CNTT="index.html" class="templatemo-login-form">
                                <div class="form-group">
                                    <label for="inpuName">Tên Phòng Ban</label>
                                    <input ng-model="test.departmentName" type="text" class="form-control" id="inputName" placeholder="Nhập Tên Phòng Ban">
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
        <script src=".././js/admin/ManageDepartment.js"></script>
        <script>
            ManageDepartmentAPI('${pageContext.request.contextPath}/admin/manage-department', ${DEPARTMENT_LIST});
        </script>
    </body>
</html>
