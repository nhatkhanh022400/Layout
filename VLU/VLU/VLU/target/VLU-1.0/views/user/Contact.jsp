<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Liên Hệ</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- AOS -->
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <!-- CSS -->
        <link href="./css/user/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../../layouts/user/Loader.html"></jsp:include>
        <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        <section class="heading" data-aos="fade-left" data-aos-duration="40000">
            <h3>Liên Hệ</h3>
            <p>
                <a href="${pageContext.request.contextPath}/home">Trang Chủ >></a> Liên Hệ 
            </p>
        </section>

        <section class="contact" data-aos="fade-left" data-aos-duration="40000">
            <div class="icons-container">
                <div class="icons">
                    <i class="fas fa-phone"></i>
                    <h3>Số Điện Thoại</h3>
                    <p>0123456789</p>
                    <p>0227363521</p>
                </div>
                <div class="icons">
                    <i class="fas fa-envelope"></i>
                    <h3>Địa Chị Email</h3>
                    <p>abc@gmail.com</p>
                    <p>cde@gmail.com</p>
                </div>
                <div class="icons">
                    <i class="fas fa-map-marker-alt"></i>
                    <h3>Địa Chị</h3>
                    <p>Cơ sở chính: 69/68 Đặng Thùy Trâm, P. 13, Q. Bình Thạnh, TP. HCM</p>
                    <p>Cơ sở 1: 45 Nguyễn Khắc Nhu, P. Cô Giang, Q.1, TP. HCM</p>
                    <p>Cơ sở 2: 233A Phan Văn Trị, P.11, Q. Bình Thạnh, TP. HCM</p>
                </div>
            </div>
            <div class="row">
                <form action="https://formspree.io/f/xzbojdqq" method="POST">
                    <h3>Hỗ Trợ</h3>
                    <input type="text" placeholder="${sessionScope.LOGIN_USER.learnerName != null ? sessionScope.LOGIN_USER.learnerName : "Họ và Tên"}" value="${sessionScope.LOGIN_USER.learnerName}" class="box" name="Full Name">
                    <input type="number" placeholder="${sessionScope.LOGIN_USER.phoneNumber != null ? sessionScope.LOGIN_USER.phoneNumber : "Số Điện Thoại"}" value="${sessionScope.LOGIN_USER.phoneNumber}" class="box" name="Phone Number">
                    <input type="email" placeholder="${sessionScope.LOGIN_USER.email != null ? sessionScope.LOGIN_USER.email : "Email"}" value="${sessionScope.LOGIN_USER.email}" class="box" name="Email">
                    <textarea name="Lời Nhắn" placeholder="Lời Nhắn" id="" cols="30" rows="10"></textarea>
                    <button class="btn" type="submit">Gửi</button>
                </form>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7879879197285!2d106.69774151474945!3d10.827530492286856!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528f4a62fce9b%3A0xc99902aa1e26ef02!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBWxINuIExhbmcgLSBDxqEgc-G7nyAz!5e0!3m2!1svi!2s!4v1651112218047!5m2!1svi!2s" width="600" height="550" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </section>
                    
        <jsp:include page="../../layouts/user/Footer.jsp"></jsp:include>
        
        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script src="./js/user/RootPage.js"></script>
    </body>
</html>
