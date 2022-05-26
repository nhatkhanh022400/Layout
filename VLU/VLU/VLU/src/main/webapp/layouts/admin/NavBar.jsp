<%@page import="com.teamseven.vlu.models.AdminAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AdminAccount adminAccount = (AdminAccount) request.getSession().getAttribute("LOGIN_ADMIN");
    String imageAvatar;
    
    if (adminAccount.getImageAvatar() != null) {
        imageAvatar = "data:image/png;base64," + adminAccount.getImageAvatar();
    } else {
        imageAvatar = ".././images/profile-photo.jpg";
    }
%>
<div class="templatemo-sidebar">
    <header class="templatemo-site-header">
        <a href="${pageContext.request.contextPath}/admin/chart">
            <img src=".././images/logo-footer.png" alt="">
        </a>
    </header>
    
    <div class="profile-photo-container">
        <img src="<%=imageAvatar%>" alt="Profile Photo" class="img-responsive">
        <div class="profile-photo-overlay"></div>
    </div>
    
    <!-- Search box -->
    <div class="mobile-menu-icon">
        <i class="fa fa-bars"></i>
    </div>
    
    <nav class="templatemo-left-nav">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/admin/chart" >
                    <i class="fa fa-database fa-fw"></i>Thống Kê
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/manage-course">
                    <i class="fa fa-graduation-cap" aria-hidden="true"></i>Quản Lý Khóa Học
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/manage-user">
                    <i class="fa fa-user" aria-hidden="true"></i>Quản Lý Người Dùng
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/manage-teacher">
                    <i class="fa fa-users" aria-hidden="true"></i>Quản Lý Giảng Viên
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/manage-department">
                    <i class="fa fa-home" aria-hidden="true"></i>Quản Lý Phòng Ban
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/update-infor">
                    <i class="fa fa-server" aria-hidden="true"></i>Cập Nhật Thông Tin
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/logout">
                    <i class="fa fa-window-close" aria-hidden="true"></i>Đăng Xuất
                </a>
            </li>
        </ul>
    </nav>
</div>