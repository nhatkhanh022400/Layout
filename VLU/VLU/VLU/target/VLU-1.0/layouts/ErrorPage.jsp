<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Error Page</title>
        <link rel="stylesheet" href="./css/ErrorPage.css">
    </head>
    <body>
        <div class="container1">
            <h2>Lỗi! Không thể truy cập.</h2>
            <h1 style="background-image: url(./images/bg.jpg)">404</h1>
            <p>Bạn không thể truy cập vào trang lúc này.</p>
            <a class="btn" href="${pageContext.request.contextPath}/home">Quay về trang chủ</a>
        </div>
    </body>
</html>
