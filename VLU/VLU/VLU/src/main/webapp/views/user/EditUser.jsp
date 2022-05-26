<%@page import="com.teamseven.vlu.models.LearnerAccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    LearnerAccountError learnerAccountError = (LearnerAccountError) request.getAttribute("EDIT_PROFILE_ERROR");
    
    if (learnerAccountError == null) {
        learnerAccountError = new LearnerAccountError();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Edit Profile</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <!-- CSS -->
        <link href="./css/user/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../../layouts/user/Loader.html"></jsp:include>
        <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        
        <!--------------------------------------Profile-------------------------------------- -->                            
        <section style="padding: 0 30rem;">
            <div class="containers rounded bg-white mt-5 mb-5 text-center" data-aos="slide-down" data-aos-duration="40000">
                <div class="row">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px" src="${sessionScope.LOGIN_USER.imageAvatar}"/>
                        <span class="font-weight-bold" style="font-size: 20px;">${sessionScope.LOGIN_USER.learnerName}</span>
                        <span class="text-black-50" style="font-size: 16px;">${sessionScope.LOGIN_USER.email}</span>
                    </div>
                </div>
            </div>

            <form action="${pageContext.request.contextPath}/edit-user" method="post" id="profileForm">
                <div class="p-5 border-bottom">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-center align-items-center mb-3">
                            <h2>Thông Tin Cá Nhân</h2>
                        </div>

                        <div class="row mt-2">
                            <div class="col-md-12 mt-4">
                                <label class="labels">Họ và Tên</label>
                                <input type="text" class="form-control" value="${sessionScope.LOGIN_USER.learnerName != null ? sessionScope.LOGIN_USER.learnerName : FULLNAME}" name="FullName" />
                                <div class="message">
                                    <span class="error_message" id="username_error_signin"><%=learnerAccountError.getLearnerName()%></span>
                                </div>
                            </div>

                            <div class="col-md-12 mt-4">
                                <label class="labels">Ngày Sinh</label>
                                <input type="date" class="form-control" value="<fmt:formatDate value="${sessionScope.LOGIN_USER.dateOfBirth}" pattern="dd-MM-yyyy"/>" name="DateOfBirth"/>
                            </div>
                        
                            <div class="col-md-12 mt-4">
                                <label class="labels">Số Điện Thoại</label>
                                <input type="text" class="form-control" value="${sessionScope.LOGIN_USER.phoneNumber != null ? sessionScope.LOGIN_USER.phoneNumber : PHONENUMBER}" name="PhoneNumber" />
                                <div class="message">
                                    <span class="error_message" id="username_error_signin"><%=learnerAccountError.getPhoneNumber()%></span>
                                </div>
                            </div>

                            <div class="col-md-12 mt-4">
                                <label class="labels" for="department">Phòng Ban</label>
                                <select id="department" class="form-control" value="${DEPARTMENT}" name="Department">
                                    <c:forEach items="${DEPARTMENT_LIST}" var="department">
                                        <option value="${department.departmentID}">${department.departmentName}</option>
                                    </c:forEach>
                                </select>
                                <div class="message">
                                    <span class="error_message" id="username_error_signin"><%=learnerAccountError.getDepartment()%></span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="mt-5 text-center">
                        <button id="btn1" class="btn btn-primary profile-button" type="button" style="font-size: 13px">
                            Cập Nhật
                        </button>
                    </div>
                </div>
            </form>

            <form action="${pageContext.request.contextPath}/edit-user" method="post" id="courseForm">
                <div class="p-5 border-bottom">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-center align-items-center mb-3">
                            <h2>Thêm Khóa Học</h2>
                        </div>
                    
                        <div class="col-md-12">
                            <label class="labels">Tên Khóa Đào Tạo</label>
                            <input type="text" class="form-control" placeholder="Nhập Tên Khóa Đào Tạo" value="" name="OtherCourseName" />
                        </div>
                        <br />
                        
                        <div class="col-md-12">
                            <label class="labels">Ngày Bắt Đầu</label>
                            <input type="date" class="form-control" placeholder="Ngày Bắt Đầu" name="StartDate" />
                        </div>
                        <br>
                        
                        <div class="col-md-12">
                            <label class="labels">Ngày Kết Thúc</label>
                            <input type="date" class="form-control" placeholder="Ngày Kết Thúc" name="EndDate" />
                        </div>
                        <br>
                        
                        <div class="col-md-12" id="upload-image">
                            <label class="labels">Ảnh Khóa Đào Tạo</label>
                            <div class="avatar-wrapper">
                                <img class="profile-pic" src="" />
                                <div class="upload-button">
                                    <i class="fa fa-arrow-circle-up" aria-hidden="true"></i>
                                </div>
                                <input class="file-upload" type="file" accept="image/*" />
                            </div>
                        </div>
                        <br>
                        
                        <div class="mt-5 text-center">
                            <button id="btn2" class="btn btn-primary profile-button" type="submit" style="font-size: 13px">
                                Thêm Khóa Đào Tạo
                            </button>
                        </div>
                    </div>
                </div>
            </form>
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
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!-- Root Page -->
        <script src="./js/user/RootPage.js"></script>
        <script src="./js/user/EditUser.js"></script>
    </body>
</html>
