<%@ page import="org.geektimes.projects.user.domain.User" %>

<%
User userInfo = (User)request.getAttribute("userInfo");
String text = (String)request.getAttribute("text");
%>
<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>注册成功</title>
</head>
<body>
	<div class="container">
	    <h1>注册成功</h1>
	    <p>userInfo：<%= userInfo.toString() %></p>
	    <p>姓名：<%= userInfo.getName() %></p>
	    <p>电话：<%= userInfo.getPhoneNumber() %></p>
	    <p>邮箱：<%= userInfo.getEmail() %></p>
	    <p>密码：<%= userInfo.getPassword() %></p>
	    <p>text：<%= text %></p>
	</div>
</body>