<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header" data-aos="slide-down" data-aos-duration="40000">
    <a href="${pageContext.request.contextPath}/home" class="logo">
        <img src="./images/logo-footer.png" alt="logo">
    </a>

    <div id="menu-btn" class="fas fa-bars"></div>

    <nav class="navbar">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/home">Trang Chủ</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course">Khóa Đào Tạo</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/contact">Liên Hệ</a>
            </li>
            <li>
                <div>
                    <i class="fas fa-user-circle"></i>
                </div>
                <ul>
                    <c:if test="${sessionScope.LOGIN_USER == null}">
                        <li>
                            <a href="${pageContext.request.contextPath}/login">Đăng Nhập</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.LOGIN_USER != null}">
                        <li>
                            <a href="${pageContext.request.contextPath}/profile">Thông Tin</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a>
                        </li>
                    </c:if>
                </ul>
            </li>
        </ul>
    </nav>
</header>
