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
	<form:form modelAttribute="registerForm" class="form-horizontal"
		action="${pageContext.request.contextPath}/user/register">

		<form:label path="userId">ユーザID :</form:label>
		<form:input path="userId" />
		<form:errors path="userId" cssClass="error-messages" />
		<br>
		<form:label path="username">名前 :</form:label>
		<form:input path="username" />
		<form:errors path="username" cssClass="error-messages" />
		<br>
		<form:label path="birthDay">生年月日 :</form:label>
		<form:input path="birthDay" />
		<form:errors path="birthDay" cssClass="error-messages" />
		<br>
		<form:label path="address">住所 :</form:label>
		<form:input path="address" />
		<form:errors path="address" cssClass="error-messages" />
		<br>
		<form:label path="telNum">電話番号 :</form:label>
		<form:input path="telNum" />
		<form:errors path="telNum" cssClass="error-messages" />
		<br>
		<form:label path="roles">権限 :</form:label>
		<form:radiobutton path="roles" value="ADMIN" label="ADMIN" />
		<form:radiobutton path="roles" value="USER" label="USER" />
		<form:errors path="roles" cssClass="error-messages" />
		<br>
		<form:label path="password">パスワード :</form:label>
		<form:password path="password" />
		<form:errors path="password" cssClass="error-messages" />
		<br>
		<form:label path="confirmPassword">パスワード確認 :</form:label>
		<form:password path="confirmPassword" />
		<form:errors path="confirmPassword" cssClass="error-messages" />
		<br>
		<input type="submit" name="confirm" value="登録" />
	</form:form>
</body>
</html>