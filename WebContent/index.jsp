<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%--Ϊ�˱�����jspҳ���г���java���룬��������jstl��ǩ�⣬����jstl��ǩ���ṩ�ı�ǩ����һЩ�߼��жϴ��� --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��ҳ</title>
<script type="text/javascript">
	function doLogout(){
		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
	}
</script>
</head>
<body>
	<h1>Logan����վ</h1>
	<hr/>
	<c:if test="${user==null }">
		<a href="${pageContext.request.contextPath }/RegisterUIServlet" target="_blank">ע��</a>
		<a href="${pageContext.request.contextPath }/LoginUIServlet">��¼</a>
	</c:if>
	<c:if test="${user!=null }">
	��ӭ����${user.userName }
	<input type="button" value="�˳���¼" onclick="doLogout()">
	</c:if>
</body>
</html>