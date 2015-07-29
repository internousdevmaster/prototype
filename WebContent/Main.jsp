<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prototype - Main</title>
</head>
<body>
<Div Align="center">
		<h1>Prototype</h1>

	<h4>メイン画面</h4>
	</Div>
		<br><br>
		<Div Align="center"><a href="Login.jsp">ログイン画面へ</a></Div>
		<br>
		<Div Align="center"><a href="MyPage.jsp">マイページへ</a></Div>
		<br>
		<Div Align="center"><a href="LogoutUserAction">ログアウト</a></Div>
		<br>
		<Div Align="center"><s:form action="CalendarAction"><a href="CalendarAction">カレンダーへ</a></s:form></Div>
		<br>
		<div id="D3" Align="center"><s:form action="D3Action"><input type="submit" value="D3ボタン"></s:form></div>
	<br>
	<br>
	<br>
</body>
</html>