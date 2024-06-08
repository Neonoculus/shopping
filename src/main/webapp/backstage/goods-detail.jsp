<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>goods.html
<head>
    <meta charset="utf-8">
    <title>商品详情</title>
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
                        <img class="rounded-circle" src="${pageContext.request.contextPath}/img/avatar/${merchant.photo}" alt="" style="width: 40px; height: 40px;">
                        <div
                                class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1">
                        </div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">${merchant.name}</h6>
                        <span>商家</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="toIndexServlet?merchant=${merchant.m_id}" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>首页</a>
                    <a href="toMerchantInfoServlet?merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-th me-2"></i>商家信息</a>
                    <a href="toGoodsServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>商品管理</a>
                    <a href="order.html" class="nav-item nav-link"><i class="fa fa-table me-2"></i>订单管理</a>
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
                                                <div>
                                                    <button type="button" class="btn btn-sm btn-secondary" onclick="clearImageContent(this)"
                                                            style="padding: 0; background-color: white; color: black; border: 0;">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                             fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
                                                            <path
                                                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z">
                                                            </path>
                                                            <path
                                                                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z">
                                                            </path>
                                                        </svg>
                                                    </button>
                                                    <div class="swiper-slide h-auto swiper-thumb-item swiper-slide-visible swiper-slide-active swiper-slide-thumb-active"
                                                         role="group" aria-label="1 / 4" style="height: 371px;"><img id="upPhoto1"
                                                            class="w-100" src="${pageContext.request.contextPath}/img/picture/${phtot1}" alt="..."></div>
                                                </div>
                                                <div>
                                                    <button type="button" class="btn btn-sm btn-secondary" onclick="clearImageContent(this)"
                                                            style="padding: 0; background-color: white; color: black; border: 0;">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                             fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
                                                            <path
                                                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z">
                                                            </path>
                                                            <path
                                                                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z">
                                                            </path>
                                                        </svg>
                                                    </button>
                                                    <div class="swiper-slide h-auto swiper-thumb-item swiper-slide-visible swiper-slide-next"
                                                         role="group" aria-label="2 / 4" style="height: 371px;">
                                                        <img class="w-100" id="upPhoto2" src="${pageContext.request.contextPath}/img/picture/${phtot2}" alt="...">
                                                    </div>
                                                </div>
                                                <div>
                                                    <button type="button" class="btn btn-sm btn-secondary" onclick="clearImageContent(this)"
                                                            style="padding: 0; background-color: white; color: black; border: 0;">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                             fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
                                                            <path
                                                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z">
                                                            </path>
                                                            <path
                                                                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z">
                                                            </path>
                                                        </svg>
                                                    </button>
                                                    <div class="swiper-slide h-auto swiper-thumb-item swiper-slide-visible"
                                                         role="group" aria-label="3 / 4" style="height: 371px;">
                                                        <img class="w-100" id="upPhoto3" src="${pageContext.request.contextPath}/img/picture/${phtot3}" alt="...">
                                                    </div>

                                                </div>
                                                <div>
                                                    <button type="button" class="btn btn-sm btn-secondary" onclick="clearImageContent(this)"
                                                            style="padding: 0; background-color: white; color: black; border: 0;">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                             fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
                                                            <path
                                                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z">
                                                            </path>
                                                            <path
                                                                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z">
                                                            </path>
                                                        </svg>
                                                    </button>
                                                    <div class="swiper-slide h-auto swiper-thumb-item  swiper-slide-visible"
                                                         role="group" aria-label="4 / 4" style="height: 371px;">
                                                        <img class="w-100" id="upPhoto4" src="${pageContext.request.contextPath}/img/picture/${phtot4}" alt="...">
                                                    </div>
                                                </div>

                                            <c:if test="${phtot4==null}">
                                                <div class="swiper-slide h-auto swiper-thumb-item mt-3 swiper-slide-visible"
                                                     style="height: 371px;">
                                                    <div>
                                                        <input type="file" id="photoInput"
                                                               style=" position: absolute; opacity: 0; width: 100%; height: 100%;">
                                                        <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                                                             class="bi bi-plus-square" viewBox="0 0 16 16">
                                                            <path
                                                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
                                                            <path
                                                                    d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
                                                        </svg>
                                                    </div>

                                                </div>
                                            </c:if>


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
                                                        class="glightbox product-view" href="img/product-detail-2.jpg"
                                                        data-gallery="gallery2" data-glightbox="Product item 1"><img
                                                        class="img-fluid" src="img/product-detail-2.jpg" alt="..."></a>
                                                </div>
                                                <div class="swiper-slide h-auto swiper-slide-next" role="group"
                                                     aria-label="2 / 4" style="width: 428px;"><a
                                                        class="glightbox product-view" href="img/product-detail-2.jpg"
                                                        data-gallery="gallery2" data-glightbox="Product item 2"><img
                                                        class="img-fluid" src="img/product-detail-2.jpg" alt="..."></a>
                                                </div>
                                                <div class="swiper-slide h-auto" role="group" aria-label="3 / 4"
                                                     style="width: 428px;"><a class="glightbox product-view"
                                                                              href="img/product-detail-3.jpg" data-gallery="gallery2"
                                                                              data-glightbox="Product item 3"><img class="img-fluid"
                                                                                                                   src="img/product-detail-3.jpg" alt="..."></a>
                                                </div>
                                            <c:if test="${phtot4!=null}">
                                                <div class="swiper-slide h-auto" role="group" aria-label="4 / 4"
                                                     style="width: 428px;"><a class="glightbox product-view"
                                                                              href="img/product-detail-3.jpg" data-gallery="gallery2"
                                                                              data-glightbox="Product item 4"><img class="img-fluid"
                                                                                                                   src="img/product-detail-3.jpg" alt="..."></a>
                                                </div>
                                            </c:if>

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
                                <label for="goods-name" class="col-sm-2 col-form-label"
                                    style="padding-right: 0;">商品名称：</label>
                                <div class="col-sm-5" style="padding-left: 0;">
                                    <input type="text" class="form-control" id="goods-name" value="红色数字智能手表">
                                </div>
                            </div>
                            <div class="row d-flex align-items-center mb-3">
                                <label for="goods-type" class="col-sm-2 col-form-label"
                                    style="padding-right: 0;">商品类别：</label>
                                <div class="col-sm-3 " style="padding-left: 0;">
                                    <select class="form-select form-select-sm" aria-label=".form-select-sm example"
                                        id="goods-type">
                                        <option value="1">手机</option>
                                        <option value="2">电脑</option>
                                        <option value="3">平板</option>
                                        <option selected="selected">--请选择商品类别--</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center mb-3">
                                <label class="col-sm-2 col-form-label" style="padding-right: 0;">标签：</label>
                                <div class="row col-sm-7" style="padding-left: 0;">
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="小米" id="小米">
                                        <label class="form-check-label" for="小米"> 小米</label>

                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="华为" id="华为">
                                        <label class="form-check-label" for="华为"> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                    <div class="col col-2">
                                        <input class="form-check-input" type="checkbox" name="tag" value="" id="">
                                        <label class="form-check-label" for=""> 华为</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="price" class="col-sm-2 col-form-label" style="padding-right: 0;">单价：</label>
                                <div class="col-1" style="padding-left: 0;padding-right: 0;">
                                    <input type="text" class="form-control" id="price" value="250">
                                </div>
                                <div class="col-1" style="padding-left: 0;line-height: 40px;">&nbsp;元</div>
                            </div>
                            <div class="row mb-3">
                                <label for="count" class="col-form-label col-sm-2"
                                    style="padding-right: 0;line-height: 15px;">库存：</label>
                                <div class="quantity col-sm-2">
                                    <div class="row align-middle">
                                        <button type="button" class="dec-btn p-0 col col-3"><i
                                                class="fas fa-caret-left"></i></button>
                                        <input class="form-control border-0 shadow-0 p-0 col" id="count" type="text"
                                            value="1" style="text-align: center;">
                                        <button type="button" class="inc-btn p-0 col col-3 "><i
                                                class="fas fa-caret-right"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="description" class="col-sm-2 col-form-label"
                                    style="padding-right: 0;">商品简介：</label>
                                <div class="col-sm-5" style="padding-left: 0;">
                                    <textarea class="form-control" placeholder="这是一个牛逼的智能手表。" id="description"
                                        style="height: 150px;"></textarea>
                                </div>
                            </div>

                            <div class="row d-flex align-items-center mb-3">
                                <label class="col-sm-2 col-form-label">状态：</label>
                                <div class="form-check form-switch col-sm-4">
                                    <input class="form-check-input" type="checkbox" role="switch" id="status"
                                        checked="checked">
                                    <label class="form-check-label" for="status">出售</label>
                                </div>
                            </div>
                            <div class="row mb-3" style="padding-left:10px;">
                                <button type="submit" class="btn btn-primary col-sm-2">确认修改</button>
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
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var fileInput = document.getElementById('photoInput');
            var previewContainer = document.getElementById('swiper-wrapper-6d944e741cdfca44');

            fileInput.addEventListener('change', function(e) {
                var files = e.target.files;

                // Iterate through each selected file
                for (var i = 0; i < files.length; i++) {
                    var file = files[i];
                    var reader = new FileReader();

                    reader.onload = function(event) {
                        var imageUrl = event.target.result;

                        // Find the next empty image container
                        var emptyImageContainer = previewContainer.querySelector('.swiper-thumb-item img:not([src])');

                        if (emptyImageContainer) {
                            emptyImageContainer.src = imageUrl;
                        }
                    };

                    reader.readAsDataURL(file);
                }
            });
        });

        function clearImageContent(button) {
            var imageContainer = button.parentElement;
            var upperImg = imageContainer.querySelector('img');
            var upperImgId = upperImg.id;

            // 清空上方图片
            upperImg.src = '';

            // 根据上方图片的位置确定需要清空的下方图片
            var lowerImgId = '';
            switch (upperImgId) {
                case '1':
                    lowerImgId = 'a';
                    break;
                case '2':
                    lowerImgId = 'b';
                    break;
                case '3':
                    lowerImgId = 'c';
                    break;
                case '4':
                    lowerImgId = 'd';
                    break;
                default:
                    break;
            }

            // 清空下方图片
            if (lowerImgId !== '') {
                var lowerImg = document.getElementById(lowerImgId);
                lowerImg.src = '';
            }
        }
    </script>

</body>

</html>