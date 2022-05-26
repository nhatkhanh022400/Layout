<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Profile</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <!-- CSS -->
        <link href="./css/user/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body ng-app="user-app">
        <jsp:include page="../../layouts/user/Loader.html"></jsp:include>
        <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>

        <!-------------------------------------- Profile -------------------------------------- -->
        <div class="containers rounded bg-white mt-5 mb-5" data-aos="slide-down" data-aos-duration="40000">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px" src="${sessionScope.LOGIN_USER.imageAvatar}" />
                        <span class="font-weight-bold">${sessionScope.LOGIN_USER.learnerName}</span>
                        <span class="text-black-50">${sessionScope.LOGIN_USER.email}</span><span> </span>
                    </div>
                </div>
                    
                <div class="col-md-5 border-right">
                    <div class="p-3">
                        <div class="d-flex justify-content-between align-items-center mb-3 fs-1">
                            <h1 class="text-right">Thông Tin Cá Nhân</h1>
                        </div>

                        <div class="right">
                            <div class="info_data">
                                <div class="data">
                                    <h4>Họ và Tên</h4>
                                    <p>${sessionScope.LOGIN_USER.learnerName}</p>
                                </div>

                                <div class="data">
                                    <h4>Ngày Sinh</h4>
                                    <p><fmt:formatDate value="${sessionScope.LOGIN_USER.dateOfBirth}" pattern="dd-MM-yyyy"/></p>
                                </div>

                                <div class="data">
                                    <h4>Số Điện Thoại</h4>
                                    <p>${sessionScope.LOGIN_USER.phoneNumber}</p>
                                </div>

                                <div class="data">
                                    <h4>Phòng Ban</h4>
                                    <p>${DEPARTMENT}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/edit-user">
                            <button class="btn btn-primary profile-button" type="button" style="font-size: 13px">
                                Chỉnh Sửa
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- ----------------------------------- Hiện khóa đã học ----------------------------- -->
        <section class="heading" data-aos="slide-left" data-aos-duration="40000">
            <h3>Học Bên Trong Trường</h3>
        </section>

        <section class="blog" data-aos="slide-left" data-aos-duration="40000" ng-controller="abc">
            <div class="box" ng-repeat="inside in insides">
                <div class="images">
                    <img src="{{inside.img}}" alt="" />
                </div>
                <div class="content">
                    <div class="icons">
                        <a href="#"> Bắt đầu: {{inside.dayStart}} <br> Kết Thúc: {{inside.dayEnd}}</a>
                        <a href="#"> <i class="fas fa-user"></i> {{inside.teach}} </a>
                    </div>
                    <h3>{{inside.title}}</h3>
                </div>
            </div>
        </section>

        <!-- ---------------------------------- Hiện khóa bên ngoài --------------------------- -->
        <section class="heading" data-aos="slide-left" data-aos-duration="40000">
            <h3> Học Bên Ngoài</h3>
        </section>

        <section class="blog" data-aos="slide-left" data-aos-duration="40000" ng-controller="abcd">
            <div class="box" ng-repeat="outside in outsides">
                <div class="images">
                    <img src="data:image/png;base64,{{outside.certificateImage}}" alt="" />
                </div>
                <div class="content">
                    <div class="icons">
                        <a href="#"> <i class="fas fa-clock"></i> {{outside.startDate}}</a>
                        <a href="#"> <i class="fas fa-clock"></i> {{outside.endDate}} </a>
                    </div>
                    <h3>{{outside.otherCourseName}}</h3>
                </div>
            </div>
        </section>
        
        <jsp:include page="../../layouts/user/Footer.jsp"></jsp:include>
        
        <!-- Custom JS File Link -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <!-- Root Page -->
        <script src="./js/user/RootPage.js"></script>
        <script src="./js/user/Profile.js"></script>
        <script>
            getAPICompleteCourse(${LIST_COMPLETE_COURSE});
            getAPIOtherCourse(${LIST_OTHER_COURSE});
        </script>
    </body>
</html>
