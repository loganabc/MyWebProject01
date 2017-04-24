<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>首页</title>
<script type="text/javascript">
	function doLogout(){
		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
	}
</script>
</head>
<body>
	<h1>Logan的网站</h1>
	<hr/>
	<c:if test="${user==null }">
		<a href="${pageContext.request.contextPath }/RegisterUIServlet" target="_blank">注册</a>
		<a href="${pageContext.request.contextPath }/LoginUIServlet">登录</a>
	</c:if>
	<c:if test="${user!=null }">
	欢迎您：${user.userName }
	<input type="button" value="退出登录" onclick="doLogout()">
	</c:if>
</body>
</html>