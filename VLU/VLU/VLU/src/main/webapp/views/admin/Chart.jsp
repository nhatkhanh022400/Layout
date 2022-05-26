<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Khóa Học</title>
        <meta name="description" content="">
        <meta name="author" content="templatemo">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
        <link rel="icon" type="image/png" sizes="200x138" href=".././images/logo-vlu-removebg-preview.png">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
        <!-- CSS -->
        <link href=".././css/admin/bootstrap.min.css" rel="stylesheet">
        <link href=".././css/admin/Style.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="../../layouts/admin/Loader.html"></jsp:include>
        <!-- Left column -->
        <div class="templatemo-flex-row">
            <jsp:include page="../../layouts/admin/NavBar.jsp"></jsp:include>
            <div class="templatemo-content col-1 light-gray-bg">
                <div class="templatemo-top-nav-container">
                    <div class="row">
                        <nav class="templatemo-top-nav col-lg-12 col-md-12">
                            <ul class="text-uppercase">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/chart" class="active" style="font-size: 25px; font-weight: bold;">Thông Tin</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>

                <div class="templatemo-content-container">
                    <div class="templatemo-content-widget white-bg">
                        <h2 class="margin-bottom-10">Thống Kê Theo Tháng</h2>
                        <div class="panel panel-default no-border">
                            <div class="panel-heading border-radius-10">
                                <h2>Biểu Đồ Thống Kê</h2>
                            </div>
                            <div class="panel-body">
                                <div class="templatemo-flex-row flex-content-row">
                                    <div class="col-1">
                                        <div id="area_chart_div" class="templatemo-chart"></div>
                                        <h3 class="text-center margin-bottom-5">Biểu Đồ Thống Kê Tình Trạng Khóa Học Theo Tháng</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden">
                    <!-- overflow hidden for iPad mini landscape view-->
                    <div class="col-1 templatemo-overflow-hidden">
                        <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                            <i class="fa fa-times"></i>
                            <div class="templatemo-flex-row flex-content-row">
                                <div class="col-1 col-lg-6 col-md-12">
                                    <h2 class="text-center">Phần Trăm<span class="badge">Mới</span></h2>
                                    <div id="pie_chart_div" class="templatemo-chart"></div>
                                </div>
                                <div class="col-1 col-lg-6 col-md-12">
                                    <h2 class="text-center">So Sánh Tỉ Lệ<span class="badge">Mới</span></h2>
                                    <div id="bar_chart_div" class="templatemo-chart"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Root Page -->
        <script src=".././js/admin/RootPage.js"></script>
        <script src=".././js/admin/ChartPage.js"></script>
    </body>
</html>
