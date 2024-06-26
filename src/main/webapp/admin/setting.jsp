<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
<head>
    <meta charset="utf-8">
    <title>设置</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/admin/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/admin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet">
</head>

<body>
<div class="container-fluid position-relative bg-white d-flex p-0">
    <!-- Spinner Start -->
    <div id="spinner"
         class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Sidebar Start -->
    <div class="sidebar pe-4 pb-3">
        <nav class="navbar bg-light navbar-light">
            <a href="buyer.html" class="navbar-brand mx-4 mb-3">
                <h3 class="text-primary">某购物平台</h3>
            </a>
            <div class="d-flex align-items-center ms-4 mb-4">
                <div class="position-relative">
                    <img class="rounded-circle" src="${pageContext.request.contextPath}/img/avatar/垃圾.jpg" alt="" style="width: 40px; height: 40px;">
                    <div
                            class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1">
                    </div>
                </div>
                <div class="ms-3">
                    <h6 class="mb-0">管理员</h6>
                </div>
            </div>
            <div class="navbar-nav w-100">
                <a href="${pageContext.request.contextPath}/toAdminBuyerServlet?start=0" class="nav-item nav-link"><i class="fa fa-th me-2"></i>用户管理</a>
                <a href="${pageContext.request.contextPath}/toAdminMerchantServlet?start=0" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>商家管理</a>
                <a href="${pageContext.request.contextPath}/toAdminGoodsServlet?start=0" class="nav-item nav-link"><i class="fa fa-table me-2"></i>商品管理</a>
                <a href="${pageContext.request.contextPath}/admin/setting.jsp" class="nav-item nav-link active"><i class="fa fa-chart-bar me-2"></i>设置</a>
            </div>
        </nav>
    </div>
    <!-- Sidebar End -->


    <!-- Content Start -->
    <div class="content">
        <!-- Navbar Start -->
        <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
            <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
            </a>
            <a href="#" class="sidebar-toggler flex-shrink-0">
                <i class="fa fa-bars"></i>
            </a>
        </nav>
        <!-- Navbar End -->

            <div class="container-fluid pt-4 px-4">
                <div class="row d-flex justify-content-center">
                    <div class="bg-light rounded h-100 p-4 col col-xl-6">
                        <h6 class="mb-4">账号安全</h6>
                        <form action="${pageContext.request.contextPath}/doUpdateAdminPasswordServlet">
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">新密码</label>
                                <input type="password" class="form-control" id="lostPassword" name="password">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">新密码</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" name="password1">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword2" class="form-label">确认密码</label>
                                <input type="password" class="form-control" id="exampleInputPassword2" name="password2">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword2" class="form-label text-danger" id="warning">${warning}</label>
                            </div>
                            <button type="submit" class="btn btn-primary">确认修改</button>
                        </form>
                    </div>

                </div>

            </div>
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/chart/chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/easing/easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/waypoints/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/tempusdominus/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/admin/js/main.js"></script>
</body>

</html>