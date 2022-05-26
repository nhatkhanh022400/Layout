<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Khóa Học</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- AOS  -->
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <!-- Slick Carousel  -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <!-- CSS -->
        <link href="./css/user/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body ng-app="myapp">
        <jsp:include page="../../layouts/user/Loader.html"></jsp:include>
        <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>

        <!-- Header Section Ends -->
        <section class="heading">
            <h3>Khoá Học</h3>
            <p><a href="${pageContext.request.contextPath}/home">Trang Chủ >></a>Khóa Học</p>
        </section>

        <!-- Course 1 section starts  -->
        <div class="search-box">
            <div class="input-box">
                <input type="text" placeholder="Tìm Kiếm ..." ng-model="searching">
            </div>
        </div>

        <!-- ---------------------------- Khóa Đào Tạo Hiện Có -------------------------------------- -->
        <div ng-controller="myCtrl">
            <div class="title-course">
                <h2>Khóa Đào Tạo Hiện Có</h2>
            </div>

            <section class="teachers" data-aos="fade-left" data-aos-duration="40000">
                <div class="box" dir-paginate="course in courses | filter:searching | itemsPerPage:4">
                    <div class="image">
                        <img src="data:image/png;base64,{{course.imageCourse}}" alt="">
                        <div class="share">
                            <a href="${pageContext.request.contextPath}/course-detail?cid={{course.courseID}}">
                                <button>Chi Tiết</button>
                            </a>

                            <div class="status">
                                {{course.status == 0 ? "Sắp Diễn Ra" : "Đang Diễn Ra"}} <br>
                                {{course.startDate}}
                            </div>
                        </div>
                    </div>
                    <div class="content">
                        <h3>{{course.courseName}}</h3>
                        <span>{{course.mentorID}}</span>
                    </div>
                </div>
            </section>
            <dir-pagination-controls class="pagination"></dir-pagination-controls>
        </div>

        <!-- ---------------------------- Khóa Đào Tạo Sắp Mở -------------------------------------- -->
        <div class="soon-course" ng-controller="myCtrls">
            <div class="title-course" >
                <h2>Khóa Đào Tạo Sắp Diễn Ra</h2>
            </div>
            <div class="image-slider">
                <div class="image-item" ng-repeat="course in courses">
                    <div class="image">
                        <img src="data:image/png;base64,{{course.imageCourse}}" alt="" />
                    </div>
                    <div class="status">
                        <h3 class="image-title">{{course.courseName}}</h3>
                        <p>Trạng Thái: {{course.status == 0 ? "Sắp Diễn Ra" : "Đang Diễn Ra"}}</p>
                        <p>Bắt Đầu: {{course.startDate}}</p>
                        <p>Người dạy: {{course.mentorID}}</p>
                        <a href="${pageContext.request.contextPath}/course-detail?cid={{course.courseID}}"><button class="btn">Chi Tiết</button></a>
                    </div>
                </div>
            </div>
        </div>
                    
        <jsp:include page="../../layouts/user/Footer.jsp"></jsp:include>
        
        <!-- Custom JS File Link -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <!-- Root Page -->
        <script src="./js/user/RootPage.js"></script>
        <script src="./js/user/dirPagination.js"></script>
        <script src="./js/user/Course.js"></script>
        <script>
            UpcomingCourseAPI(${UPCOMING_COURSE_LIST});
            ExistingCourseAPI(${EXISTING_COURSE_LIST});
        </script>
    </body>
</html>
