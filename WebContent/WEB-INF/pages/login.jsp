<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û���¼</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		�û�����<input type="text" name="username"><br/>
		���룺<input type="password" name="password"><br/>
		<input type="submit" value="��¼">
	</form>
</body>
</html>