<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" contentType="text/html; charset=UTF-8"
	language="java"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--
// ユーザーからの入力を出力する
 
String birthDay = request.getParameter("birthDay");

--%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録項目確認</title>
</head>
<body>
	<%-- form:form modelAttribute="registerForm">--%>
	<form:form modelAttribute="registerForm" action="${pageContext.request.contextPath}/user/register">

		<table cellpadding="3">
			<tr>
				<th><form:label path="userId">ユーザID : </form:label></th>
				<td><c:out value="${registerForm.userId}" /></td>
				<form:hidden path="userId" />
			</tr>
			<tr>
				<th><form:label path="username">名前 : </form:label></th>
				<td><c:out value="${registerForm.username}" /></td>
				<form:hidden path="username" />
			</tr>
			<tr>
				<th>生年月日: </th>
				<td><c:out value="${registerForm.birthDay}" /></td>
<%-- 			<td><fmt:formatDate value="${registerForm.birthDay}" pattern="yyyy-MM-dd" /> </td> --%>
<%--			<form:hidden path="birthDay" value="${registerForm.birthDay}" pattern="yyyy-MM-dd"/> --%>
			</tr>
			<tr>
				<th><form:label path="address">住所 : </form:label></th>
				<td><c:out value="${registerForm.address}" /></td>
				<form:hidden path="address" />
			</tr>
			<tr>
				<th><form:label path="telNum">電話番号 : </form:label></th>
				<td><c:out value="${registerForm.telNum}" /></td>
				<form:hidden path="telNum" />
			</tr>
			<tr>
				<th><form:label path="roles">権限 : </form:label></th>
				<td><c:out value="${registerForm.roles}" /></td>
				<form:hidden path="roles" />
			</tr>
			<form:hidden path="password" />
			<form:hidden path="confirmPassword" />

		</table>
		<input type="submit" name="redo" value="やり直し" />
		<input type="submit" name="finish" value="登録" />
	</form:form>
</body>
</html>