<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chi Tiết Khóa Học </title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- AOS  -->
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <!-- CSS -->
        <link href="./css/user/RootPage.css" rel="stylesheet" type="text/css"/>
        <link href="./css/user/NavBar.css" rel="stylesheet" type="text/css"/>
        <link href="./css/user/Loader.css" rel="stylesheet" type="text/css"/>
        <link href="./css/user/Footer.css" rel="stylesheet" type="text/css"/>
        <link href="./css/user/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../../layouts/user/Loader.html"></jsp:include>
        <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>

            <!-- header section ends -->
            <section class="heading" data-aos="fade-left" data-aos-duration="40000">
                <h3>Chi Tiết Khóa Học</h3>
                <p> <a href="${pageContext.request.contextPath}/home">Trang Chủ >></a> <a href="${pageContext.request.contextPath}/course">Khóa Học >></a> Chi Tiết Khóa Học </p>
        </section>

        <!-- ---------------------------------------- Course Detail --------------------------------- -->
        <div class="container" data-aos="fade-left" data-aos-duration="40000">
            <div class="profile">
                <img src="data:image/png;base64,${COURSE.imageCourse}" alt="">
                <h1>${COURSE.courseName}</h1>
            </div>

            <div class="information" data-aos="fade-left" data-aos-duration="40000">
                <div class="about">
                    <h3 class="titling">Mô Tả</h3>
                    <p>${COURSE_DETAIL.courseDetailDescription}</p>
                    <div class="box-container">
                        <div class="boxing">
                            <h3> <span>Ngày Bắt Đầu:  </span> <fmt:formatDate value="${COURSE.startDate}" pattern="dd-MM-yyyy"/> </h3>
                            <h3> <span>Ngày Kết Thúc:  </span> <fmt:formatDate value="${COURSE.endDate}" pattern="dd-MM-yyyy"/> </h3>
                            <h3> <span>Trạng Thái:  </span> ${COURSE.status == 0 ? "Sắp Diễn Ra" : "Đang Diễn Ra"} </h3>
                            <h3> <span>Giảng Viên: </span> ${MENTOR.mentorName} </h3>
                        </div>
                    </div>
                </div>
                        <br><br>

                <div class="contact" data-aos="fade-left" data-aos-duration="40000">
                    <h3 class="titling">Thông Tin Giảng Viên</h3>
                    <div class="box-container">
                        <div class="boxing">
                            <i class="fas fa-phone"></i>
                            <div class="info">
                                <h3>Số Điện Thoại</h3>
                                <p>${MENTOR.mentorPhone}</p>
                            </div>
                        </div>

                        <div class="boxing">
                            <i class="fas fa-envelope"></i>
                            <div class="info">
                                <h3>Email</h3>
                                <p>${MENTOR.mentorEmail}</p>
                            </div>
                        </div>
                    </div>
                </div>

                <c:if test="${HAS_ENROLL == null}">
                    <button onclick="buttonAddCourse('${sessionScope.LOGIN_USER.learnerID}', '${COURSE.courseID}', '${pageContext.request.contextPath}/course-detail')" class="btn" id="enroll">Tham Gia</button>
                </c:if>
            </div>
        </div>
        <jsp:include page="../../layouts/user/Footer.jsp"></jsp:include>

        <!-- Custom JS File Link -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <!-- Root Page -->
        <script src="./js/user/RootPage.js"></script>
        <script src="./js/user/CourseDetail.js"></script>
    </body>
</html>
