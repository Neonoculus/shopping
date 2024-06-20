<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>goods.html
<head>
    <meta charset="utf-8">
    <title>账号信息修改</title>
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
                    <a href="toMerchantInfoServlet?merchant=${merchant.m_id}" class="nav-item nav-link active"><i class="fa fa-th me-2"></i>商家信息</a>
                    <a href="toGoodsServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>商品管理</a>
                    <a href="toOrderServlet?start=0&merchant=${merchant.m_id}" class="nav-item nav-link"><i class="fa fa-table me-2"></i>订单管理</a>
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
                <div class="row d-flex justify-content-center">
                    <div class="bg-light rounded h-100 p-4 col col-xl-6">
                        <h6 class="mb-4">账号信息修改</h6>
                        <form action="doMerchantInfoUpdateServlet">
                            <input type="hidden" id="merchant" name="merchant" value="${pageContext.request.contextPath}/img/avatar/${merchant.photo}">
                            <div class="mb-3 row" id="imgDiv">
                                <label for="photoInput" class="form-label">头像</label>
                                <div class="col-1" style="height: 70px; width: 70px;">
                                    <img src="${pageContext.request.contextPath}/img/avatar/${merchant.photo}" style="  width: 70px; height: 70px;">
                                </div>
                                <div class="col-1" style="height: 70px; width: 70px;">
                                    <input type="hidden" id="photo1Input" name="photo1Input" value="${pageContext.request.contextPath}/img/avatar/${merchant.photo}">
                                    <input type="file" id="photoInput"
                                           style=" position: absolute; opacity: 0; width: 70px; height: 70px;">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                                             class="bi bi-plus-square" viewBox="0 0 16 16" style="width: 70px; height: 70px;">
                                            <path
                                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
                                            <path
                                                    d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
                                        </svg>
                                </div>
                                <div class="col"></div>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputName" class="form-label">商家名称</label>
                                <input type="text" class="form-control" id="exampleInputName" name="name"
                                    aria-describedby="emailHelp" value="${merchant.name}">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPhone" class="form-label">联系电话</label>
                                <input type="number" class="form-control" id="exampleInputPhone" name="phone"
                                    aria-describedby="emailHelp" value="${merchant.phone}">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputEmail" class="form-label">电子邮箱</label>
                                <input type="email" class="form-control" id="exampleInputEmail" name="email"
                                    aria-describedby="emailHelp" value="${merchant.email}">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputAddress" class="form-label">地址</label>
                                <input type="text" class="form-control" id="exampleInputAddress" name="address"
                                    aria-describedby="emailHelp" value="${merchant.address}">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputNote" class="form-label">商家简介</label>
                                <textarea class="form-control" placeholder="请在此处输入简介！！！" id="exampleInputNote" name="note"
                                    style="height: 150px;">${merchant.note}</textarea>
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
    <script src="${pageContext.request.contextPath}/backstage/lib/chart/chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/easing/easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/waypoints/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/tempusdominus/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="${pageContext.request.contextPath}/backstage/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/backstage/js/main.js"></script>
    <script>
        // 当文档加载完成时执行
        document.addEventListener('DOMContentLoaded', function() {
            var fileInput = document.getElementById('photoInput');
            fileInput.addEventListener('change', function(e) {
                var file = e.target.files[0]; // 只处理第一个文件

                var filePath = file.name;
                var fileName = filePath.substring(filePath.lastIndexOf('\\') + 1);

                var reader = new FileReader();
                reader.onload = function(event) {
                    var imageUrl = event.target.result;

                    var specificDiv = document.getElementById('imgDiv');
                    var imageElements = specificDiv.getElementsByTagName('img');
                    console.log(fileName)
                    for (var j = 0; j < imageElements.length; j++) {
                        var img = imageElements[j];
                        img.src = imageUrl;
                        var photo1Input = document.getElementById('photo1Input');
                        photo1Input.value = fileName;
                    }
                };

                reader.readAsDataURL(file);
            });
        });
    </script>
</body>

</html>