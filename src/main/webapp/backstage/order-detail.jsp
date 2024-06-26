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
                    <a href="toIndexServlet?merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>首页</a>
                    <a href="toMerchantInfoServlet?merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-th me-2"></i>商家信息</a>
                    <a href="toGoodsServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>商品管理</a>
                    <a href="toOrderServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>订单管理</a>
                    <a href="toMerchantSettingServlet?merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>设置</a>
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
                            <a href="toMerchantInfoServlet?merchant=${merchant.m_id}" class="dropdown-item">商家信息</a>
                            <a href="toMerchantSettingServlet?merchant=${merchant.m_id}" class="dropdown-item">设置</a>
                            <a href="${pageContext.request.contextPath}/backstage/signin.jsp" class="dropdown-item">退出登录</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->

            <div class="container-fluid pt-4 px-4">
                <div class="row g-4 mb-4">
                    <div class="col col-6">
                        <div class="bg-light rounded h-100 p-4">
                            <div class="testimonial-item text-center">
                                <img class="img-fluid rounded-circle mx-auto mb-4" src="${pageContext.request.contextPath}/img/picture/${buyer.photo}"
                                    style="width: 100px; height: 100px;">
                                <p>买家姓名：${order.name}</p>
                                <p>联系电话：${order.phone}</p>
                                <p>电子邮箱：${buyer.email}</p>
                                <p>地址：${order.address}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col col-6">
                        <div class="bg-light rounded h-100 p-4 d-flex align-items-center justify-content-center">
                            <div class="testimonial-item text-center">
                                <p>订单编号：${order.o_id}</p>
                                <p>总金额：${order.money}</p>
                                <p>开始时间：${order.startTime}</p>
                                <p>截止时间：${order.endTime}</p>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-12">
                        <table class="table text-nowrap ">
                            <thead class="bg-light">
                                <tr>
                                    <th class="border-0 p-3" scope="col"><strong
                                            class="text-sm text-uppercase">商品编号</strong>
                                    </th>
                                    <th class="border-0 p-3" scope="col"> <strong
                                            class="text-sm text-uppercase">商品名称</strong>
                                    </th>
                                    <th class="border-0 p-3" scope="col"> <strong
                                            class="text-sm text-uppercase">数量</strong>
                                    </th>
                                    <th class="border-0 p-3" scope="col"> <strong
                                            class="text-sm text-uppercase">小计</strong>
                                    </th>
                                    <th class="border-0 p-3" scope="col"> <strong
                                            class="text-sm text-uppercase">操作</strong>
                                    </th>
                                </tr>
                            </thead>
                            <tbody class="border-0">
                            <c:forEach var="orderDetail" items="${orderDetails}" varStatus="i">
                                <tr>
                                    <th class="p-3 align-middle border-light">
                                        <p>${orderDetail.o_id}</p>
                                    </th>
                                    <td class="ps-0 py-3 border-light">
                                        <div class="d-flex align-items-center"><a
                                                class="reset-anchor d-block animsition-link" href="#"><img
                                                src="${pageContext.request.contextPath}/img/picture/${goodsList[i.index].photo}" alt="..." width="70" /></a>
                                            <div class="ms-3"><strong class="h6"><a class="reset-anchor animsition-link"
                                                                                    href="#">${goodsList[i.index].name}</a></strong></div>
                                        </div>
                                    </td>
                                    <td class="p-3 align-middle border-light">
                                        <p class="mb-0 small">${orderDetail.count}个</p>
                                    </td>
                                    <td class="p-3 align-middle border-light">
                                        <p class="mb-0 small">${orderDetail.money}元</p>
                                    </td>
                                    <td class="p-3 align-middle border-light">
                                        <a class="btn btn-sm btn-secondary" href="toODDetailServlet?g_id=${goodsList[i.index].g_id}&m_id=${merchant.m_id}&o_id=${orderDetail.o_id}"
                                           target="_blank">详细信息</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                </div>
                <!-- Content End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
            </div>
        </div>
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
            <script src="${pageContext.request.contextPath}/backstage/js/main.js"></script>

</body>

</html>