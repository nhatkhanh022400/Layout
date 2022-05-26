<%@page import="com.teamseven.vlu.models.AdminAccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AdminAccountError adminAccountError = (AdminAccountError) request.getAttribute("EDIT_PROFILE_ERROR");
    
    if (adminAccountError == null) {
        adminAccountError = new AdminAccountError();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cập Nhật Thông Tin</title>
        <meta name="description" content="">
        <meta name="author" content="templatemo">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet'>
        <link href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" rel="stylesheet">
        <!-- BOOTSTRAP 5 -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
        <link rel="icon" type="image/png" sizes="200x138" href=".././images/logo-vlu-removebg-preview.png">
        <!-- CSS -->
        <link href=".././css/admin/Style.css" rel="stylesheet">
        <link href=".././css/admin/Loader.css" rel="stylesheet">
    </head>
    <body>
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
                                    <a href="${pageContext.request.contextPath}/admin/update-infor" class="active" style="font-size: 25px; font-weight: bold;">Thông Tin</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                
                <div class="templatemo-content-container">
                    <div class="templatemo-content-widget white-bg">
                        <h2 class="margin-bottom-10">Cập Nhật Thông Tin</h2>

                        <form action="${pageContext.request.contextPath}/admin/update-infor" class="templatemo-login-form" method="post">
                            <div class="row form-group">
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputFirstName">Họ</label>
                                    <input type="text" class="form-control" id="inputFirstName" placeholder="Họ" name="FirstName" value="${FIRSTNAME != null ? FIRSTNAME : sessionScope.LOGIN_ADMIN.firstName}">
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getFirstName()%></span>
                                    </div>
                                </div>
                                
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputLastName">Tên</label>
                                    <input type="text" class="form-control" id="inputLastName" placeholder="Tên" name="LastName" value="${LASTNAME != null ? LASTNAME : sessionScope.LOGIN_ADMIN.lastName}">
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getLastName()%></span>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row form-group">
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputUsername">Tên người dùng</label>
                                    <input type="text" class="form-control" id="inputUsername" placeholder="Tên người dùng" name="Username" value="${USERNAME != null ? USERNAME : sessionScope.LOGIN_ADMIN.userName}">
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getUserName()%></span>
                                    </div>
                                </div>
                                
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputEmail">Email</label>
                                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="Email" value="${EMAIL != null ? EMAIL : sessionScope.LOGIN_ADMIN.email}" readonly>
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getEmail()%></span>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row form-group">
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputCurrentPassword">Mật khẩu hiện tại</label>
                                    <input type="password" class="form-control highlight" id="inputCurrentPassword" placeholder="Mật khẩu hiện tại" name="CurrentPassword">
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getCurrentPassword()%></span>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row form-group">
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputNewPassword">Mật khẩu mới</label>
                                    <input type="password" class="form-control" id="inputNewPassword" placeholder="Mật khẩu mới" name="NewPassword">
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getNewPassword()%></span>
                                    </div>
                                </div>
                                
                                <div class="col-lg-6 col-md-6 form-group">
                                    <label for="inputConfirmNewPassword">Nhập lại mật khẩu mới</label>
                                    <input type="password" class="form-control" id="inputConfirmNewPassword" placeholder="Nhập lại mật khẩu mới" name="ConfirmNewPassword">
                                    <div class="message">
                                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getConfirmNewPassword()%></span>
                                    </div>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-lg-12" id="imageAvatar">
                                    <label class="control-label templatemo-block">Ảnh Đại Diện</label>
                                    <input type="file" name="fileToUpload" id="fileToUpload" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                                </div>
                            </div>
                            <div class="form-group text-right">
                                <button type="submit" class="templatemo-blue-button">Cập Nhật</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Root Page -->
        <script src=".././js/admin/RootPage.js"></script>
        <script src=".././js/admin/bootstrap-filestyle.min.js"></script>
        <script src=".././js/admin/UpdateInfor.js"></script>
    </body>
</html>
