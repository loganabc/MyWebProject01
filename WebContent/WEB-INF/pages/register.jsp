<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û�ע��</title>
</head>
<body style="text-align:center;">
	<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
		<table width="60%" border="1">
			<tr>
				<td>�û���</td>
				<td><input type="text" name="userName" value="${formbean.userName }"/>${formbean.errors.userName}</td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="password" name="userPwd" value="${formbean.userPwd }"/>${formbean.errors.userPwd}</td>
			</tr>
			<tr>
				<td>ȷ������</td>
				<td><input type="password" name="confirmPwd" value="${formbean.confirmPwd}"/>${formbean.errors.confirmPwd}</td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="email" value="${formbean.email }"/>${formbean.errors.email }</td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="birthday" value="${formbean.birthday }"/>${formbean.errors.birthday}</td>
			</tr>
			<tr>
				
				<td><input type="reset" name="���"/></td>
				<td><input type="submit" name="ע��"/></td>
			</tr>
		</table>
	
	</form>
	
</body>
</html>