<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>goods.html
<head>
    <meta charset="utf-8">
    <title>订单详情</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/backstage/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/backstage/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backstage/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/backstage/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${pageContext.request.contextPath}/backstage/css/style.css" rel="stylesheet">

    <!-- gLightbox gallery-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/vendor/glightbox/css/glightbox.min.css">
    <!-- Range slider-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/vendor/nouislider/nouislider.min.css">
    <!-- Choices CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/vendor/choices.js/public/assets/styles/choices.min.css">
    <!-- Swiper slider-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/vendor/swiper/swiper-bundle.min.css">
    <!-- Google fonts-->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Libre+Franklin:wght@300;400;700&amp;display=swap">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@300;400;800&amp;display=swap">
    <!-- theme stylesheet-->
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
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary">某购物平台</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div
                            class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1">
                        </div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">随乡饺子馆</h6>
                        <span>商家</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="toIndexServlet?merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>首页</a>
                    <a href="toMerchantInfoServlet?merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-th me-2"></i>商家信息</a>
                    <a href="toGoodsServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>商品管理</a>
                    <a href="toOrderServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>订单管理</a>
                    <a href="setting.html" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>设置</a>
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
                <div class="navbar-nav align-items-center ms-auto">

                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="${pageContext.request.contextPath}/img/avatar/${merchant.photo}" alt=""
                                 style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">${merchant.name}</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="info.html" class="dropdown-item">商家信息</a>
                            <a href="setting.html" class="dropdown-item">设置</a>
                            <a href="#" class="dropdown-item">退出登录</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->

            <div class="container-fluid pt-4 px-4">
                <form action="">
                    <div class="row mb-5">
                        <div class="col-lg-6">
                            <!-- PRODUCT SLIDER-->
                            <div class="row m-sm-0">
                                <div class="col-sm-2 p-sm-0 order-2 order-sm-1 mt-2 mt-sm-0 px-xl-2">
                                    <div
                                        class="swiper product-slider-thumbs swiper-initialized swiper-vertical swiper-pointer-events swiper-thumbs">
                                        <div class="swiper-wrapper" id="swiper-wrapper-6d944e741cdfca44"
                                            aria-live="polite" style="transform: translate3d(0px, 0px, 0px);">
                                            <div class="swiper-slide h-auto mb-3 swiper-thumb-item swiper-slide-visible swiper-slide-active swiper-slide-thumb-active"
                                                role="group" aria-label="1 / 4" style="height: 371px;"><img
                                                    class="w-100" src="${pageContext.request.contextPath}/img/picture/${photo1}" alt="...">
                                            </div>
                                            <div class="swiper-slide h-auto mb-3 swiper-thumb-item swiper-slide-visible swiper-slide-next"
                                                role="group" aria-label="2 / 4" style="height: 371px;">
                                                <img class="w-100" src="${pageContext.request.contextPath}/img/picture/${photo2}" alt="...">
                                            </div>
                                            <div class="swiper-slide h-auto mb-3 swiper-thumb-item swiper-slide-visible"
                                                role="group" aria-label="3 / 4" style="height: 371px;">
                                                <img class="w-100" src="${pageContext.request.contextPath}/img/picture/${photo3}" alt="...">
                                            </div>
                                            <div class="swiper-slide h-auto mb-3 swiper-thumb-item  swiper-slide-visible"
                                                role="group" aria-label="4 / 4" style="height: 371px;">
                                                <img class="w-100" src="${pageContext.request.contextPath}/img/picture/${photo4}" alt="...">
                                            </div>

                                        </div>
                                        <span class="swiper-notification" aria-live="assertive"
                                            aria-atomic="true"></span>
                                    </div>
                                </div>
                                <div class="col-sm-10 order-1 order-sm-2">
                                    <div
                                        class="swiper product-slider swiper-initialized swiper-horizontal swiper-pointer-events">
                                        <div class="swiper-wrapper" id="swiper-wrapper-5b7c5e2f834832e9"
                                            aria-live="polite" style="transform: translate3d(0px, 0px, 0px);">
                                            <div class="swiper-slide h-auto swiper-slide-active" role="group"
                                                 aria-label="1 / 4" style="width: 428px;"><a
                                                    class="glightbox product-view" href="${pageContext.request.contextPath}/img/picture/${photo1}"
                                                    data-gallery="gallery2" data-glightbox="Product item 1"><img id="downPhoto1"
                                                                                                                 class="img-fluid" src="${pageContext.request.contextPath}/img/picture/${photo1}" alt="..."></a>
                                            </div>
                                            <div class="swiper-slide h-auto swiper-slide-next" role="group"
                                                 aria-label="2 / 4" style="width: 428px;"><a
                                                    class="glightbox product-view" href="${pageContext.request.contextPath}/img/picture/${photo2}"
                                                    data-gallery="gallery2" data-glightbox="Product item 2"><img id="downPhoto2"
                                                                                                                 class="img-fluid" src="${pageContext.request.contextPath}/img/picture/${photo2}" alt="..."></a>
                                            </div>
                                            <div class="swiper-slide h-auto" role="group" aria-label="3 / 4"
                                                 style="width: 428px;"><a class="glightbox product-view"
                                                                          href="${pageContext.request.contextPath}/img/picture/${photo3}" data-gallery="gallery2"
                                                                          data-glightbox="Product item 3"><img id="downPhoto3"
                                                                                                               class="img-fluid" src="${pageContext.request.contextPath}/img/picture/${photo3}" alt="..."></a>
                                            </div>
                                            <div class="swiper-slide h-auto" role="group" aria-label="4 / 4"
                                                 style="width: 428px;"><a class="glightbox product-view"
                                                                          href="${pageContext.request.contextPath}/img/picture/${photo4}" data-gallery="gallery2"
                                                                          data-glightbox="Product item 4"><img id="downPhoto4"
                                                                                                               class="img-fluid" src="${pageContext.request.contextPath}/img/picture/${photo4}" alt="..."></a>
                                            </div>
                                        </div>
                                        <span class="swiper-notification" aria-live="assertive"
                                            aria-atomic="true"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- PRODUCT DETAILS-->
                        <div class="col-lg-6">
                            <div class="row mb-3">
                                <strong class="col-sm-4">商品编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${goods.g_id}</strong>
                            </div>
                            <div class="row mb-3">
                                <strong class="col-sm-4">商品名称·：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${goods.name}</strong>
                            </div>
                            <div class="row mb-3">
                                <strong class="col-sm-4">数量：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${orderDetails.count}个</strong>
                            </div>
                            <div class="row mb-3">
                                <strong class="col-sm-4">小计：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${orderDetails.money}元</strong>
                            </div>

                        </div>
                    </div>
                </form>

            </div>


        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/chart/chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/easing/easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/waypoints/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/tempusdominus/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
    <!-- Template Javascript -->


    <script src="${pageContext.request.contextPath}/backstage/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/vendor/nouislider/nouislider.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/vendor/choices.js/public/assets/scripts/choices.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/js/front.js"></script>

    <script src="${pageContext.request.contextPath}/backstage/js/main.js"></script>

</body>

</html>