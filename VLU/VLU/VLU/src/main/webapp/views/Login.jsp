<%@page import="com.teamseven.vlu.models.AdminAccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AdminAccountError adminAccountError = (AdminAccountError) request.getAttribute("LOGIN_ACCOUNT_ERROR");

    if (adminAccountError == null) {
        adminAccountError = new AdminAccountError();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Đăng Nhập</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- CSS -->
        <link href="./css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="bg-signup">
            <div class="signup" data-aos="zoom-in-down">
                <div class="logo">
                    <img src="./images/logo-01.png" alt="logo">
                </div>
                <h1 class="signup-heading">Đăng Nhập</h1>
                <div class="row">
                    <div class="col-6">
                        <button onclick="location.href = '${pageContext.request.contextPath}/login-microsoft'" class="signup-social">
                            <span class="signup-social-text">
                                <i class="fa-brands fa-windows" style="font-size: 35px; margin-right: 10px; transform: translateY(13px);"></i>
                                Đăng Nhập Với 365 Office
                            </span>
                        </button>
                    </div>
                    <div class="col-6">
                        <button onclick="location.href = 'https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/VLU/login-google&response_type=code&client_id=1065893457116-6apdtrraksjqf6odsrikl377b0m1c97t.apps.googleusercontent.com&approval_prompt=force'" class="signup-social col-6">
                            <span class="signup-social-text">
                                <i class="fa-brands fa-google" style="font-size: 35px; margin-right: 10px; transform: translateY(13px);"></i>
                                Đăng Nhập Với Google
                            </span>
                        </button>
                    </div>
                </div>
                <div class="signup-or">
                    <span>Or</span>
                </div>
                <form action="${pageContext.request.contextPath}/login" class="signup-form" autocomplete="off" method="post">
                    <label for="fullname" class="signup-label">Email</label>
                    <input type="email" id="fullname" class="signup-input" placeholder="Ex: johndoe@gmai.com" name="email" value="${EMAIL != null ? EMAIL : ""}">
                    <div class="message">
                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getEmail()%></span>
                    </div>
                    <label for="password" class="signup-label">Password</label>
                    <input type="password" id="password" class="signup-input" placeholder="Password" name="password">
                    <div class="message">
                        <span class="error_message" id="username_error_signin"><%=adminAccountError.getCurrentPassword()%></span>
                    </div>
                    <button class="signup-submit" type="submit">Đăng Nhập</button>
                </form>
            </div>
        </div>

        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script>
            AOS.init();
            console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
                console.log("%cVLU front-end was built with HTML, CSS, and lots of love. \n\nVLU back-end was built with SQL Server, and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/VLU/home"), "color: #29c4a9;font-size: 14px;");
        </script>
    </body>
</html>
