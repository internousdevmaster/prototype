<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prototype - Mypage</title>
</head>
<body>
	<header>

			<Div Align="center"><h1>Prototype</h1></Div>
	</header>
		<Div Align="center"><b>Mypage</b></Div><br><br>




		<Div Align="center">名前<br><s:property value="#session.familyname" /></Div>
		<Div Align="center">メールアドレス<br><s:property value="session.email" /></Div>
		<Div Align="center">電話番号</Div><br>


		<Div Align="center"><a href="Main.jsp">メイン画面へ</a></Div>
	<br>

</body>
</html>