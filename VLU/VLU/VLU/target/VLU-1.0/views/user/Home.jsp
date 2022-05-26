<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang Chủ</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/logo-vlu-removebg-preview.png">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- AOS -->
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <!-- Slick Carousel -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <!-- CSS -->
        <link href="./css/user/Style.css" rel="stylesheet"/>
    </head>
    <body>
        <jsp:include page="../../layouts/user/Loader.html"></jsp:include>
        <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        <section class="heading" data-aos="flip-up" data-aos-duration="40000" style="background-image: url(./images/heading-bg.png)">
            <h3>Trang Chủ</h3>
        </section>
        
        <!-- Chuyển Slide -->
        <div class="slider">
            <div class="image-slider">
                <div class="image-item">
                    <div class="image">
                        <img src="https://www.vanlanguni.edu.vn/images/2020/banner/cs3-01.jpg" alt="" />
                    </div>
                </div>
                <div class="image-item">
                    <div class="image">
                        <img src="https://www.vanlanguni.edu.vn/images/2020/banner/hd-02.jpg" alt="" />
                    </div>
                </div>
                <div class="image-item">
                    <div class="image">
                        <img src="https://www.vanlanguni.edu.vn/images/2020/banner/hd-06.jpg" alt="" />
                    </div>
                </div>
            </div>
        </div>
        <!-- End Chuyển Slide -->
        
        <!-- Home Section Starts -->
        <section class="home">
            <div class="image" data-aos="flip-down" data-aos-duration="40000">
                <img src="./images/home-img.png" alt="">
            </div>
            <div class="content" data-aos="flip-up" data-aos-duration="40000">
                <h3>GIỚI THIỆU CHUNG</h3>
                <p>Cảm ơn quí thầy cô đã đến với khóa học ngắn hạn của Trường Đại Học Văn Lang.</p>
                <p>Khóa học ngắn hạn là một dạng đào tạo được cấp phép tổ chức giảng dạy với thời gian ngắn (dưới 6 tháng). Nhằm để
                    bổ sung, bồi dưỡng kiến thức, kỹ năng về một ngành nghề. Khóa học ngắn hạn thường dành cho những giảng viên không
                    có thời gian, điều kiện để tham gia các khóa học dài hạn. Đây được xem là một giải pháp ít tốn kém nhưng vẫn đảm
                    bảo được lượng kiến thức nhằm phục vụ cho công việc</p>
                <p>Những khóa học như thế này tạo cái nhìn tổng quan cho các giảng viên, từ đó có thể tự nâng cao với những kỹ năng</p>
                <p>Mặc dù khóa học ngắn hạn chỉ diễn ra vài tháng, nhưng luôn đảm bảo được lượng kiến thức cần thiết cho học viên.
                    Chính vì thế, để học và bồi dưỡng các kiến thức, kỹ năng mềm người ta thường chọn các khóa học ngắn hạn.
                </p>
            </div>
        </section>
        <!-- End Home Section Starts -->
        
        <!-- About Section Starts -->
        <section class="about">
            <div class="content" data-aos="slide-left" data-aos-duration="40000">
                <h3>Đội ngũ giảng viên</h3>
                <p>Đội ngũ giảng viên của Trường Đại học Văn Lang công cộng đa số là các giảng viên trẻ, năng động có trình độ và
                    tâm huyết với nghề. Hầu hết, đội ngũ giảng viên của trường có trình độ Tiến sĩ, Thạc sĩ được đào tạo tại những
                    trường đại học hàng đầu trên thế giới. Đã có trên 85% giảng viên có trình độ sau đại học với gần 20 giáo sư, phó
                    giáo sư; gần 20 Tiến sĩ; 47 thạc sĩ. Như vậy, tỷ lệ giảng viên có trình độ Giáo sư, Phó Giáo sư chiếm 20%, tỷ lệ
                    giảng viên có trình độ Tiến sĩ, Thạc sĩ trở lên chiếm 85% trong tổng số giảng viên của trường - một tỷ lệ rất ít
                    trong các trường đại học ở Việt Nam hiện nay.
                </p>
            </div>
            <div class="image" data-aos="slide-right" data-aos-duration="40000">
                <img src="https://images.unsplash.com/photo-1524178232363-1fb2b075b655?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8dGVhY2hlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60" alt="">
            </div>
        </section>
        
        <section class="about">
            <div class="image" data-aos="slide-right" data-aos-duration="40000">
                <img src="https://images.unsplash.com/photo-1488190211105-8b0e65b80b4e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fHN0dWR5fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60" alt="">
            </div>
            <div class="content" data-aos="slide-left" data-aos-duration="40000">
                <h3>TẦM NHÌN</h3>
                <p>Trở thành khóa học có ý cho các giảng viên, CBCNV trong Trường Đại học Văn Lang. Tạo ra môi trường học tập chuyên
                    nghiệp. Giúp các giảng viên, CBNCV có thể củng cố và nâng cao kiến thức cho bản thân. Để môi trường làm việc trong
                    trường tiến bộ hơn theo từng ngày.
                </p>
            </div>
        </section>
        
        <section class="about">
            <div class="content" data-aos="slide-right" data-aos-duration="40000">
                <h3>SỨ MỆNH</h3>
                <p>• Hỗ trợ các giảng viên đang muốn nâng cao thêm kiến thức của bản thân</p>
                <p>• Giới thiệu các khóa học bổ ích cho các giảng viên, CBCNV trong trường có thể học hỏi và trao dồi thêm kiến thức</p>
                <a href="${pageContext.request.contextPath}/course" class="btn">Bắt Đầu</a>
            </div>
            <div class="image" data-aos="slide-left" data-aos-duration="40000">
                <img src="https://images.unsplash.com/photo-1522202176988-66273c2fd55f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8c3R1ZHlpbmd8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60" alt="">
            </div>
        </section>
        <!-- End About Section Starts -->
        
        <!-- Categories Section Starts  -->
        <section class="trending">Top 5 Khóa Đào Tạo Thịnh Hành</section>
        <section class="category" data-aos="fade-right" data-aos-duration="40000">
            <a href="#" class="box">
              <img src="./images/category-1.png" alt="">
              <h3>Tin Học Quản Trị</h3>
            </a>

            <a href="#" class="box">
              <img src="./images/category-2.png" alt="">
              <h3>AI</h3>
            </a>

            <a href="#" class="box">
              <img src="./images/category-3.png" alt="">
              <h3>Quản Trị Kinh Doanh</h3>
            </a>

            <a href="#" class="box">
              <img src="./images/category-4.png" alt="">
              <h3>Quan Hệ Quần Chúng</h3>
            </a>

            <a href="#" class="box">
              <img src="./images/category-5.png" alt="">
              <h3>Diện Toán Đám Mây</h3>
            </a>
        </section>
        <jsp:include page="../../layouts/user/Footer.jsp"></jsp:include>
        
        <!-- Custom JS File Link -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <!-- Root Page -->
        <script src="./js/user/RootPage.js"></script>
        <script src="./js/user/HomePage.js"></script>
    </body>
</html>
