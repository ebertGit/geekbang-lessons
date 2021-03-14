<%@ page import="org.geektimes.projects.user.domain.User" %>
<%@ page import="org.geektimes.projects.user.validator.bean.validation.ValidResult" %>
<%
User userInfo = (User)request.getAttribute("userInfo");
ValidResult result = (ValidResult)request.getAttribute("result");
%>
<head>
<jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
	<title>My Home Page</title>
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .error {
        color: red;
      }
    </style>
</head>
<body>
	<div class="container">
		<form class="form-signin" method="post" action="/register">
			<h1 class="h3 mb-3 font-weight-normal">注册</h1>
			<c:if test="${result.getResultCode() != 0}"><div class="error"><%= "There have errors.{" + result.getResultCode() + "}" %></div></c:if>
			<label for="inputName" class="sr-only">请输入姓名</label>
			<input type="text" id="inputName" name="name" class="form-control" placeholder="请输入姓名" value="${userInfo.getName()}" required autofocus>
			<c:if test="${result.getResultMap().containsKey('name')}"><div class="error"><%= result.getResultMap().get("name") %></div></c:if>
			<label for="inputPhone" class="sr-only">请输入电话号码</label>
			<input type="text" id="inputPhone" name="phone" class="form-control" placeholder="请输入电话号码" value="${userInfo.getPhoneNumber()}" required autofocus>
			<c:if test="${result.getResultMap().containsKey('phoneNumber')}"><div class="error"><%= result.getResultMap().get("phoneNumber") %></div></c:if>
			<label for="inputEmail" class="sr-only">请输入电子邮箱地址</label>
			<input type="email" id="inputEmail" name="email" class="form-control" placeholder="请输入电子邮箱地址" value="${userInfo.getEmail()}" required autofocus>
			<c:if test="${result.getResultMap().containsKey('email')}"><div class="error"><%= result.getResultMap().get("email") %></div></c:if>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="请输入密码" required>
			<c:if test="${result.getResultMap().containsKey('password')}"><div class="error"><%= result.getResultMap().get("password") %></div></c:if>
			<label for="confirmPassword" class="sr-only">Password</label>
			<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="请再次输入密码" required>
			<c:if test="${result.getResultMap().containsKey('password')}"><div class="error"><%= result.getResultMap().get("password") %></div></c:if>

			<button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
		</form>
	</div>
</body>