<%@ page import="utils.SendEmail" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
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


        <!-- Sign Up Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">

                    <div class="d-flex col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                        <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3 ">
                            <form action="${pageContext.request.contextPath}/doSignUpServlet">
                            <div class="d-flex align-items-center justify-content-between mb-3">
                                <h3 class="text-dark">某购物平台</h3>
                                <h3>注册</h3>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingText" placeholder="username" name="username">
                                <label for="floatingText">账号</label>
                            </div>
                            <div class="form-floating mb-4">
                                <input type="password" class="form-control" id="floatingPassword" placeholder="password" name="password">
                                <label for="floatingPassword">密码</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email">
                                <label for="floatingInput">邮箱</label>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <div class="form-floating  ">
                                    <input type="CAPTCHA" class="form-control col" id="floatingCAPTCHA" name="inputCode"
                                           style="height: 40px;">
                                    <label for="floatingCAPTCHA" style="font-size: 10px;">验证码</label>
                                </div>
                                <button type="submit" class="btn btn-dark" name="send" value="send">获取验证码</button>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <div class="form-check">
                                    <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="user" id="user" style="margin: 0; margin-bottom: 0;">
                                        <option selected disabled>选择账号类型</option>
                                        <option value="buyer">用户</option>
                                        <option value="merchant">商家</option>
                                    </select>
                                </div>
                                <div><label class="text-danger" id="warning"></label></div>
                            </div>
                            <button type="submit" class="btn btn-dark py-3 w-100 mb-4" name="signUp">注册</button>
                            <p class="text-center mb-0">立即返回<a href="/backstage/signin.jsp">登录</a></p>
                            </form>
                        </div>
                    </div>


            </div>
        </div>
        <!-- Sign Up End -->
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
        function SendEmail(){

        }
    </script>
</body>

</html>