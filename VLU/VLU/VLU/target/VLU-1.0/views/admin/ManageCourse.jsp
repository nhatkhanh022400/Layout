<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Khóa Đào Tạo</title>
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
                                    <a href="${pageContext.request.contextPath}/admin/manage-course" class="active" style="font-size: 25px; font-weight: bold;">Thông Tin</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>

                <form class="templatemo-search-form" role="search" style="transform: translate(0px, 30px);">
                    <div class="input-group" style="margin-bottom: 10px;">
                        <button type="submit" class="fa fa-search"></button>
                        <input ng-model="searching" type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term" style="width: 310px;">
                    </div>

                    <button onclick="openForm()" style="display: inline-block; border-radius: 5px; background-color:#39adb4;  padding: 10px; border: transparent; margin-right: 15px; color: #fff; font-size: 14px;">
                        Thêm Khóa Đào Tạo
                    </button>

                    <button ng-click="exportToExcel('#tableToExport')" style="display: inline-block;  border-radius: 5px; background-color:#39adb4; color: white; padding: 10px; border: transparent; font-size: 14px;">
                        Xuất Danh Sách Ra Excel
                    </button>
                </form>

                <div class="templatemo-content-container" id="tableToExport">
                    <div class="templatemo-flex-row flex-content-row">
                        <div class="templatemo-content-widget no-padding ">
                            <div class="panel panel-default table-responsive">
                                <table class="table table-striped table-bordered templatemo-user-table">
                                    <thead>
                                        <tr style="text-align: center; font-size: 14px;">
                                            <td>STT</td>
                                            <td>Tên Khóa Đào Tạo</td>
                                            <td>Trạng Thái</td>
                                            <td>Ngày Bắt Đầu</td>
                                            <td>Ngày Kết Thúc</td>
                                            <td>Mô Tả</td>
                                            <td>Giảng Viên Dạy</td>
                                            <td>SĐT</td>
                                            <td>Email</td>
                                            <td>Danh Sách Học Viên</td>
                                            <td>Chỉnh sửa</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr ng-repeat="course in listCourses | filter: searching">
                                            <td>{{$index + 1}}</td>
                                            <td>{{course.courseName}}</td>
                                            <td>{{course.status == 0 ? "Sắp Diễn Ra" : "Đang Diễn Ra"}}</td>
                                            <td>{{course.startDate | date:"dd/MM/yyyy"}}</td>
                                            <td>{{course.endDate | date:"dd/MM/yyyy"}}</td>
                                            <td style="display: block; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 100px; height: 100%">
                                                {{course.courseDetailDescription}}
                                            </td>
                                            <td>{{course.mentorName}}</td>
                                            <td>{{course.mentorPhone}}</td>
                                            <td>{{course.mentorEmail}}</td>
                                            <td>
                                                <button onclick="openShow()" class="templatemo-edit-btn">Xem Thêm</button>
                                            </td>
                                            <td>
                                                <button onclick="openFormDemo()" ng-click="edit($index)" class="buttom-edit">
                                                    <i class="fas fa-edit" aria-hidden="true"></i>
                                                </button>
                                                <button ng-click="delete(course.courseID)" class="buttom-delete">
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
        </div>
        
        <!-- ===================================== Pop-up Show List Student ============================================ -->
        <season class="add-edit">
            <div class="templatemo-flex-row flex-content-row" id="showmore">
                <div class="col-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="text-uppercase">Danh sách người học</h2>
                        </div>
                        
                        <div class="list" style="padding: 20px;">
                            <table id="tableToLearner" class="table table-striped table-bordered templatemo-user-table" style="margin-bottom: 20px;">
                                <thead>
                                    <tr style="text-align: center; font-size: 14px;">
                                        <td>STT</td>
                                        <td>Tên Người Học</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="course in listCourses | filter: searching" style="text-align: center;">
                                        <td>{{$index + 1}}</td>
                                        <td>{{course.listLearner}}</td>
                                    </tr>
                                </tbody>
                            </table>

                            <button class="templatemo-blue-button " type="submit" onclick="closeShow()" ng-click="cancel()" style="color: white; font-size: 14px;">
                                Đóng
                            </button>

                            <button ng-click="exportToLearner('#tableToLearner')" style="display: inline-block;  border-radius: 0px; background-color:#39adb4; color: white; padding: 10px; border: transparent; font-size: 14px;">Xuất
                                Danh Sách Ra Học Viên
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </season>
    
        <!-- ===================================== Pop-up Add $ Edit Course============================================ -->
        <season class="add-edit">
            <div class="templatemo-flex-row flex-content-row" id="add-edit">
                <div class="col-1">
                    <div class="panel panel-default margin-10">
                        <div class="panel-heading">
                            <h2 class="text-uppercase">Thêm và Sửa Khóa Đào Tạo</h2>
                        </div>
                        
                        <div class="panel-body">
                            <form Khoa CNTT="index.html" class="templatemo-login-form">
                                <div class="form-group">
                                    <label for="inpuName">Tên Khóa Đào Tạo</label>
                                    <input ng-model="test.courseName" type="text" class="form-control" id="inputName" placeholder="Nhập Tên Khóa Đào Tạo">
                                </div>
                                
                                <div class="form-group">
                                    <label for="inputStatus">Trạng Thái Khóa Đào Tạo</label>
                                    <select ng-model="test.status" class="form-control">
                                        <option value="Sắp diễn ra">Sắp diễn ra</option>
                                        <option value="Đang diễn ra">Đang diễn ra</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="inputPhone">Ngày Bắt Đầu</label>
                                    <input ng-model="test.startDate" type="date" class="form-control" placeholder="Nhập Ngày Bắt Đầu" id="inputPhone">
                                </div>

                                <div class="form-group">
                                    <label for="inputUndo">Ngày Kết Thúc</label>
                                    <input ng-model="test.endDate" type="date" class="form-control" id="inputUndo" placeholder="Nhập Ngày Kết Thúc">
                                </div>

                                <div class="form-group">
                                    <label for="inputPassword">Giảng Viên</label>
                                    <select ng-model="test.mentorName" type="text" class="form-control" id="inputPassword">
                                        <option ng-repeat="teacher in teacherList" value="{{teacher.mentorID}}">{{teacher.mentorName}}</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="inputImage">Hình Ảnh</label>
                                    <div class="avatar-wrapper">
                                        <img class="profile-pic" src="" />
                                        <div class="upload-button">
                                            <i class="fa fa-arrow-circle-up" aria-hidden="true"></i>
                                        </div>
                                        <input class="file-upload" type="file" accept="image/*" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputDer">Mô Tả</label>
                                    <textarea ng-model="test.courseDetailDescription" type="text" class="form-control" id="inputDer" placeholder="Nhập Mô Tả"></textarea>
                                </div>

                                <div class="form-group">
                                    <button id="add" onclick="closeForm()" ng-click="save()" type="submit" class="templatemo-blue-button">
                                        Thêm
                                    </button>

                                    <button id="update" onclick="closeForm()" ng-click="update()" type="submit" class="templatemo-blue-button">
                                        Cập Nhật
                                    </button>

                                    <button onclick="closeForm()" ng-click="cancel()" class="templatemo-blue-button" type="submit">
                                        Ðóng
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </season>

    <!-- JQUERY -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <!-- Root Page -->
    <script src=".././js/admin/RootPage.js"></script>
    <script src=".././js/admin/ManageCourse.js"></script>
    <script>
         ManageCourseAPI('${pageContext.request.contextPath}/admin/manage-course', ${MENTOR_LIST}, ${MANAGE_COURSE_LIST});
    </script>
</body>
</html>
