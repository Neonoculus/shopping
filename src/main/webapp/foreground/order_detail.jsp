<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
  <title>Ministore</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="format-detection" content="telephone=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="author" content="">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/foreground/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/foreground/style.css">
  <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/Swiper/9.4.1/swiper-bundle.min.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap"
    rel="stylesheet">



  <!-- script
    ================================================== -->
  <script src="${pageContext.request.contextPath}/foreground/js/modernizr.js"></script>
</head>

<body>
  <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="search" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32">
      <path fill="currentColor"
        d="M19 3C13.488 3 9 7.488 9 13c0 2.395.84 4.59 2.25 6.313L3.281 27.28l1.439 1.44l7.968-7.969A9.922 9.922 0 0 0 19 23c5.512 0 10-4.488 10-10S24.512 3 19 3zm0 2c4.43 0 8 3.57 8 8s-3.57 8-8 8s-8-3.57-8-8s3.57-8 8-8z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="user" viewBox="0 0 16 16">
      <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="cart" viewBox="0 0 16 16">
      <path
        d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
    </symbol>
    <svg xmlns="http://www.w3.org/2000/svg" id="chevron-left" viewBox="0 0 16 16">
      <path fill-rule="evenodd"
        d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
    </svg>
    <symbol xmlns="http://www.w3.org/2000/svg" id="chevron-right" viewBox="0 0 16 16">
      <path fill-rule="evenodd"
        d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="cart-outline" viewBox="0 0 16 16">
      <path
        d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="facebook" viewBox="0 0 24 24">
      <path fill="currentColor"
        d="M9.198 21.5h4v-8.01h3.604l.396-3.98h-4V7.5a1 1 0 0 1 1-1h3v-4h-3a5 5 0 0 0-5 5v2.01h-2l-.396 3.98h2.396v8.01Z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="youtube" viewBox="0 0 32 32">
      <path fill="currentColor"
        d="M29.41 9.26a3.5 3.5 0 0 0-2.47-2.47C24.76 6.2 16 6.2 16 6.2s-8.76 0-10.94.59a3.5 3.5 0 0 0-2.47 2.47A36.13 36.13 0 0 0 2 16a36.13 36.13 0 0 0 .59 6.74a3.5 3.5 0 0 0 2.47 2.47c2.18.59 10.94.59 10.94.59s8.76 0 10.94-.59a3.5 3.5 0 0 0 2.47-2.47A36.13 36.13 0 0 0 30 16a36.13 36.13 0 0 0-.59-6.74ZM13.2 20.2v-8.4l7.27 4.2Z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="twitter" viewBox="0 0 256 256">
      <path fill="currentColor"
        d="m245.66 77.66l-29.9 29.9C209.72 177.58 150.67 232 80 232c-14.52 0-26.49-2.3-35.58-6.84c-7.33-3.67-10.33-7.6-11.08-8.72a8 8 0 0 1 3.85-11.93c.26-.1 24.24-9.31 39.47-26.84a110.93 110.93 0 0 1-21.88-24.2c-12.4-18.41-26.28-50.39-22-98.18a8 8 0 0 1 13.65-4.92c.35.35 33.28 33.1 73.54 43.72V88a47.87 47.87 0 0 1 14.36-34.3A46.87 46.87 0 0 1 168.1 40a48.66 48.66 0 0 1 41.47 24H240a8 8 0 0 1 5.66 13.66Z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="instagram" viewBox="0 0 256 256">
      <path fill="currentColor"
        d="M128 80a48 48 0 1 0 48 48a48.05 48.05 0 0 0-48-48Zm0 80a32 32 0 1 1 32-32a32 32 0 0 1-32 32Zm48-136H80a56.06 56.06 0 0 0-56 56v96a56.06 56.06 0 0 0 56 56h96a56.06 56.06 0 0 0 56-56V80a56.06 56.06 0 0 0-56-56Zm40 152a40 40 0 0 1-40 40H80a40 40 0 0 1-40-40V80a40 40 0 0 1 40-40h96a40 40 0 0 1 40 40ZM192 76a12 12 0 1 1-12-12a12 12 0 0 1 12 12Z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="linkedin" viewBox="0 0 24 24">
      <path fill="currentColor"
        d="M6.94 5a2 2 0 1 1-4-.002a2 2 0 0 1 4 .002zM7 8.48H3V21h4V8.48zm6.32 0H9.34V21h3.94v-6.57c0-3.66 4.77-4 4.77 0V21H22v-7.93c0-6.17-7.06-5.94-8.72-2.91l.04-1.68z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="nav-icon" viewBox="0 0 16 16">
      <path
        d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="close" viewBox="0 0 16 16">
      <path
        d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
    </symbol>
    <symbol xmlns="http://www.w3.org/2000/svg" id="navbar-icon" viewBox="0 0 16 16">
      <path
        d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
    </symbol>
  </svg>
  <div class="search-popup">
    <div class="search-popup-container">

      <form role="search" method="get" class="search-form" action="">
        <input type="search" id="search-form" class="search-field" placeholder="Type and press enter" value=""
          name="s" />
        <button type="submit" class="search-submit"><svg class="search">
            <use xlink:href="#search"></use>
          </svg></button>
      </form>

      <h5 class="cat-list-title">浏览分类</h5>

      <ul class="cat-list">
        <li class="cat-list-item">
          <a href="#" title="Mobile Phones">智能手机</a>
        </li>
        <li class="cat-list-item">
          <a href="#" title="Smart Watches">智能手表</a>
        </li>
        <li class="cat-list-item">
          <a href="#" title="Headphones">耳机</a>
        </li>
        <li class="cat-list-item">
          <a href="#" title="Accessories">饰品</a>
        </li>
        <li class="cat-list-item">
          <a href="#" title="Monitors">显示器</a>
        </li>
        <li class="cat-list-item">
          <a href="#" title="Speakers">发言人</a>
        </li>
        <li class="cat-list-item">
          <a href="#" title="Memory Cards">存储卡</a>
        </li>
      </ul>

    </div>
  </div>

  <header id="header" class="site-header header-scrolled position-fixed text-black bg-light">
    <nav id="header-nav" class="navbar navbar-expand-lg px-3 mb-3">
      <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/foreground/index.jsp">
          <img src="${pageContext.request.contextPath}/foreground/images/main-logo.png" class="logo">
        </a>
        <button class="navbar-toggler d-flex d-lg-none order-3 p-2" type="button" data-bs-toggle="offcanvas" data-bs-target="#bdNavbar" aria-controls="bdNavbar" aria-expanded="false" aria-label="Toggle navigation">
          <svg class="navbar-icon">
            <use xlink:href="#navbar-icon"></use>
          </svg>
        </button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="bdNavbar" aria-labelledby="bdNavbarOffcanvasLabel">
          <div class="offcanvas-header px-4 pb-0">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/foreground/index.jsp">
              <img src="${pageContext.request.contextPath}/foreground/images/main-logo.png" class="logo">
            </a>
            <button type="button" class="btn-close btn-close-black" data-bs-dismiss="offcanvas" aria-label="Close" data-bs-target="#bdNavbar"></button>
          </div>
          <div class="offcanvas-body">
            <ul id="navbar" class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
              <c:if test="${buyer.b_id!=NULL}">
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/foreground/index.jsp">首页</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/toShopServlet?b_id=${buyer.b_id}&shop=first">产品</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/toCartServlet?b_id=${buyer.b_id}">购物车</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}//toContactServlet?b_id=${buyer.b_id}">联系</a>
                </li>
              </c:if>
              <c:if test="${buyer.b_id==NULL}">
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/foreground/index.jsp">首页</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/toShopServlet?shop=first">产品</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/backstage/signin.jsp">购物车</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="${pageContext.request.contextPath}/backstage/signin.jsp">联系</a>
                </li>
              </c:if>
              <li class="nav-item">
                <div class="user-items ps-5">
                  <c:if test="${buyer==NULL}">

                    <ul class="d-flex justify-content-end list-unstyled">
                      <li class="search-item pe-3">
                        <a href="#" class="search-button">
                          <svg class="search">
                            <use xlink:href="#search"></use>
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="${pageContext.request.contextPath}/backstage/signin.jsp">
                          <svg class="cart">
                            <use xlink:href="#cart"></use>
                          </svg>
                        </a>
                      </li>
                      <li class="pe-3" style="margin-left: 15px">
                        <a href="${pageContext.request.contextPath}/backstage/signin.jsp">
                          登录/注册
                        </a>
                      </li>
                    </ul>
                  </c:if>
                  <c:if test="${buyer!=NULL}">
                    <ul class="d-flex justify-content-end list-unstyled">
                      <li class="search-item pe-3">
                        <a href="#" class="search-button">
                          <svg class="search">
                            <use xlink:href="#search"></use>
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="${pageContext.request.contextPath}/toCartServlet?b_id=${buyer.b_id}">
                          <svg class="cart">
                            <use xlink:href="#cart"></use>
                          </svg>
                        </a>
                      </li>
                      <li class="pe-3" style="margin-left: 15px">
                        <a href="${pageContext.request.contextPath}/toBuyerInfoServlet?b_id=${buyer.b_id}">
                          <img src="${pageContext.request.contextPath}/img/avatar/${buyer.photo}" style="border-radius: 50%" width="24px">
                        </a>
                      </li>

                      <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        </a>
                        <ul style="width: 120px;min-width:120px;left: -350%;top:30px;" class="dropdown-menu" aria-labelledby="navbarDropdown">
                          <li style="width: 100%;text-align: center;"><a class="dropdown-item" href="${pageContext.request.contextPath}/toUpdateInfoServlet?b_id=${buyer.b_id}" style="font-size:14px; color:black;">个人信息</a></li>
                          <li style="width: 100%;text-align: center;"><a class="dropdown-item" href="${pageContext.request.contextPath}/toBuyerInfoServlet?b_id=${buyer.b_id}" style="font-size:14px; color:black;">订单信息</a></li>
                          <li style="width: 100%;text-align: center;"><a class="dropdown-item" href="${pageContext.request.contextPath}/toPasswordUpdate?b_id=${buyer.b_id}" style="font-size:14px; color:black;">修改密码</a></li>
                          <li style="width: 100%;text-align: center;"><hr class="dropdown-divider"></li>
                          <li style="width: 100%;text-align: center;"><a class="dropdown-item" href="${pageContext.request.contextPath}/buyerExitServlet" style="font-size:14px; color:black;">退出</a></li>
                        </ul>
                      </li>
                    </ul>
                  </c:if>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  </header>
  <section class="hero-section position-relative bg-light-blue padding-medium">
    <div class="hero-content">
      <div class="container d-flex align-items-center justify-content-center">
        <div class="row">
          <div style="height: 50px; "></div>

          <div class="page-content d-flex flex-wrap">
            <div class="col-sm-12">
              <div class="content-box text-dark pe-4 mb-5">
                <div class="contact-address pt-3">
                  <p>姓名：${order.name}</p>
                </div>
                <div class="contact-number">
                  <p>联系电话：${order.phone}</p>
                </div>
                <div class="contact-address">
                  <p>地址：${order.address}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section class="shopify-cart padding-large">
    <div class="container">
      <div class="row">
        <div class="cart-table">
          <div class="cart-header">
            <div class="row d-flex text-uppercase">
              <h3 class="cart-title col-lg-3 pb-3">商品编号</h3>
              <h3 class="cart-title col-lg-3 pb-3">商品</h3>
              <h3 class="cart-title col-lg-3 pb-3">数量</h3>
              <h3 class="cart-title col-lg-3 pb-3">金额</h3>
            </div>
          </div>
          <c:forEach var="orderDetail" items="${orderDetailsList}" varStatus="i">
          <div class="cart-item border-top border-bottom padding-small">
            <div class="row align-items-center">
              <div class="col-lg-3 col-md-3">
                <h3 class="card-title text-uppercase">
                  ${order.o_id}
                </h3>
              </div>
              <div class="col-lg-3 col-md-3 d-flex align-items-center">
                  <a class="reset-anchor d-block animsition-link" href="${pageContext.request.contextPath}/toSingleProductServlet?g_id=${goodsList[i.index].g_id}&b_id=${buyer.b_id}">
                    <img src="${pageContext.request.contextPath}/img/picture/${goodsList[i.index].photo}" alt="..." width="70">
                  </a>
                  <div class="ms-3">
                    <strong class="h6">
                      <a class="reset-anchor animsition-link" href="${pageContext.request.contextPath}/toSingleProductServlet?g_id=${goodsList[i.index].g_id}&b_id=${buyer.b_id}">
                          ${goodsList[i.index].name}
                      </a>
                    </strong>
                  </div>
              </div>
              <div class="col-lg-3 col-md-3">
                <h3 class="card-title text-uppercase">
                  ${orderDetail.count}个
                </h3>
              </div>
              <div class="col-lg-3 col-md-3">
                <h3 class="card-title text-uppercase">
                  ${orderDetail.money}元
                </h3>
              </div>
            </div>
          </div>
          </c:forEach>
          <div class="cart-item border-top border-bottom padding-small">
            <div class="row align-items-center">
              <div class="col-lg-6 col-md-3"></div>
              <div class="col-lg-3 col-md-3">
                <h3 class="card-title text-uppercase">
                  总计
                </h3>
              </div>
              <div class="col-lg-3 col-md-3">
                <h3 class="card-title text-uppercase">
                  ${order.money}元
                </h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section id="subscribe" class="container-grid position-relative overflow-hidden pb-4">
    <div class="container">
      <div class="row">
        <div
                class="subscribe-content bg-dark d-flex flex-wrap justify-content-center align-items-center padding-medium">
          <div class="col-md-6 col-sm-12">
            <div class="display-header pe-3">
              <h2 class="display-7 text-uppercase text-light">订阅我们</h2>
              <p>获得最新的新闻，更新和交易直接邮寄到您的收件箱.</p>
            </div>
          </div>
          <div class="col-md-5 col-sm-12">
            <form class="subscription-form validate">
              <div class="input-group flex-wrap">
                <input class="form-control btn-rounded-none" type="email" name="EMAIL"
                       placeholder="Your email address here" required="">
                <button class="btn btn-medium btn-primary text-uppercase btn-rounded-none" type="submit"
                        name="subscribe">订阅</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <footer id="footer" class="overflow-hidden">
    <div class="container">
      <div class="row">
        <div class="footer-top-area">
          <div class="row d-flex flex-wrap justify-content-between">
            <div class="col-lg-3 col-sm-6 pb-3">
              <div class="footer-menu">
                <img src="${pageContext.request.contextPath}/foreground/images/main-logo.png" alt="logo">
                <p>Nisi, purus vitae, ultrices nunc. Sit ac sit suscipit hendrerit. Gravida massa volutpat aenean odio
                  erat nullam fringilla.</p>
                <div class="social-links">
                  <ul class="d-flex list-unstyled">
                    <li>
                      <a href="#">
                        <svg class="facebook">
                          <use xlink:href="#facebook" />
                        </svg>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <svg class="instagram">
                          <use xlink:href="#instagram" />
                        </svg>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <svg class="twitter">
                          <use xlink:href="#twitter" />
                        </svg>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <svg class="linkedin">
                          <use xlink:href="#linkedin" />
                        </svg>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <svg class="youtube">
                          <use xlink:href="#youtube" />
                        </svg>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="col-lg-2 col-sm-6 pb-3">
              <div class="footer-menu text-uppercase">
                <h5 class="widget-title pb-2">快速连接</h5>
                <ul class="menu-list list-unstyled text-uppercase">
                  <li class="menu-item pb-2">
                    <a href="#">首页</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">关于</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">购物</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">博客</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">联系</a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="col-lg-3 col-sm-6 pb-3">
              <div class="footer-menu text-uppercase">
                <h5 class="widget-title pb-2">Help & Info Help</h5>
                <ul class="menu-list list-unstyled">
                  <li class="menu-item pb-2">
                    <a href="#">Track Your Order</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">Returns Policies</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">Shipping + Delivery</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">Contact Us</a>
                  </li>
                  <li class="menu-item pb-2">
                    <a href="#">Faqs</a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="col-lg-3 col-sm-6 pb-3">
              <div class="footer-menu contact-item">
                <h5 class="widget-title text-uppercase pb-2">Contact Us</h5>
                <p>Do you have any queries or suggestions? <a href="mailto:">yourinfo@gmail.com</a>
                </p>
                <p>If you need support? Just give us a call. <a href="">+55 111 222 333 44</a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <hr>
  </footer>
  <div id="footer-bottom">
    <div class="container">
      <div class="row d-flex flex-wrap justify-content-between">
        <div class="col-md-4 col-sm-6">
          <div class="Shipping d-flex">
            <p>We ship with:</p>
            <div class="card-wrap ps-2">
              <img src="${pageContext.request.contextPath}/foreground/images/dhl.png" alt="visa">
              <img src="${pageContext.request.contextPath}/foreground/images/shippingcard.png" alt="mastercard">
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-6">
          <div class="payment-method d-flex">
            <p>Payment options:</p>
            <div class="card-wrap ps-2">
              <img src="${pageContext.request.contextPath}/foreground/images/visa.jpg" alt="visa">
              <img src="${pageContext.request.contextPath}/foreground/images/mastercard.jpg" alt="mastercard">
              <img src="${pageContext.request.contextPath}/foreground/images/paypal.jpg" alt="paypal">
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-6">
          <div class="copyright">
            <!-- <p>© Copyright 2023 MiniStore. <a target="_blank" href="http://www.mobanwang.com/" title="网页模板">网页模板</a> -->
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="${pageContext.request.contextPath}/foreground/js/jquery-1.11.0.min.js"></script>
  <script src="https://cdn.bootcdn.net/ajax/libs/Swiper/11.0.5/swiper-bundle.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/foreground/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/foreground/js/plugins.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/foreground/js/script.js"></script>
  <script src="${pageContext.request.contextPath}/foreground/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="${pageContext.request.contextPath}/foreground/vendor/nouislider/nouislider.min.js"></script>
  <script src="${pageContext.request.contextPath}/foreground/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/foreground/vendor/choices.js/public/assets/scripts/choices.min.js"></script>
  <script src="${pageContext.request.contextPath}/foreground/js/front.js"></script>

</body>

</html>