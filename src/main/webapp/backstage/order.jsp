<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>goods.html
<head>
    <meta charset="utf-8">
    <title>订单管理</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
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
                    <a href="index.html" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>首页</a>
                    <a href="info.html" class="nav-item nav-link"><i class="fa fa-th me-2"></i>商家信息</a>
                    <a href="goods.html" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>商品管理</a>
                    <a href="order.html" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>订单管理</a>
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
                            <img class="rounded-circle me-lg-2" src="img/user.jpg" alt=""
                                style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">随乡饺子馆</span>
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

            <!-- Goods Table Start -->
            <div class="container-fluid pt-4 px-4">

                <div class="row">
                    <div class="d-flex align-items-center justify-content-start col">
                        <input class="form-control border-0" type="search" placeholder="Search">
                        <button type="button" class="btn btn-primary ">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-search" viewBox="0 0 16 16">
                                <path
                                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z">
                                </path>
                            </svg>
                        </button>
                    </div>
                    <div class="d-flex align-items-center justify-content-start col">

                    </div>
                    <div class="col"></div>
                    <div class="col"></div>
                    <div class="d-flex align-items-center justify-content-end mb-4 col">
                        <button type="button" class="btn btn-danger m-2">批量取消</button>
                        <button type="button" class="btn btn-success m-2">批量发货</button>
                    </div>
                </div>
                <table class="table text-nowrap">
                    <thead class="bg-light">
                        <tr>
                            <th class="border-0 p-3" scope="col"><input class="form-check-input" type="checkbox"></th>
                            <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">订单编号</strong>
                            </th>
                            <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">买家编号</strong>
                            </th>
                            <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">总金额</strong>
                            </th>
                            <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">状态</strong>
                            </th>
                            <th class="border-0 p-3" scope="col"> <strong class="text-sm text-uppercase">操作</strong>
                            </th>
                        </tr>
                    </thead>
                    <tbody class="border-0">
                        <tr>
                            <th class="p-3 align-middle border-light"><input class="form-check-input" type="checkbox">
                            </th>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">100202405251544001</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">1000001</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">258.00元</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">未发货</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <a class="btn btn-sm btn-danger" href="#">取消</a>
                                <a class="btn btn-sm btn-success" href="#">发货</a>
                                <a class="btn btn-sm btn-secondary" href="order-detail.html" target="_blank">详细信息</a>
                            </td>
                        </tr>
                        <tr>
                            <th class="p-3 align-middle border-light"><input class="form-check-input" type="checkbox">
                            </th>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">100202405251544001</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">1000001</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">258.00元</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">未发货</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <a class="btn btn-sm btn-danger" href="#">取消</a>
                                <a class="btn btn-sm btn-success" href="#">发货</a>
                                <a class="btn btn-sm btn-secondary" href="#">详细信息</a>
                            </td>
                        </tr>
                        <tr>
                            <th class="p-3 align-middle border-light"><input class="form-check-input" type="checkbox">
                            </th>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">100202405251544001</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">1000001</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">258.00元</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <p class="mb-0 small">未发货</p>
                            </td>
                            <td class="p-3 align-middle border-light">
                                <a class="btn btn-sm btn-danger" href="#">取消</a>
                                <a class="btn btn-sm btn-success" href="#">发货</a>
                                <a class="btn btn-sm btn-secondary" href="#">详细信息</a>
                            </td>
                        </tr>
                    </tbody>

                </table>
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">上一页</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">下一页</a></li>
                </ul>
            </div>
            <!-- Goods Table End -->

        </div>
        <!-- Content End -->



        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>