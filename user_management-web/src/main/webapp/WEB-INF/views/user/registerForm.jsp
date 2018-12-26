<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" contentType="text/html; charset=UTF-8"
	language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録フォーム表示</title>
</head>
<body>
	<form:form modelAttribute="registerForm"
		action="${pageContext.request.contextPath}/user/register">
		
	ユーザID : <form:input path="userId" />
			  <form:error path="userId"/>
		<br>
	名前 : <form:input path="username" />
		<br>
	生年月日 : <form:input path="birthDay" />
		<br>
	住所 : <form:input path="address" />
		<br>
	電話番号 : <form:input path="telNum" />
		<br>
	権限 : <form:radiobutton path="roles" value="ADMIN" label="ADMIN" />
		<form:radiobutton path="roles" value="USER" label="USER" />
		<br>
	パスワード : <form:password path="password" />
		<br>
	パスワード確認 : <form:password path="confirmPassword" />
		<br>
		<input type="submit" name="confirm" value="登録" />
	</form:form>
</body>
</html>