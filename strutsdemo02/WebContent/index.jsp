<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
<form action="test.action" method="post" enctype="multipart/form-data">
	<input type="text" name="u.loginName"/><s:fielderror fieldName="u.loginName"></s:fielderror> <br/>
	<input type="password" name="u.psd"><br/>
	头像：<input type="file" name="head"/><s:fielderror fieldName="head"></s:fielderror><br/>
	<input type="submit"/>
</form>

<%
	Map map=(Map)request.getAttribute("errors");
	out.print(map.get("u.loginName"));
%>
</body>
</html>