<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prototype - Login</title>
<link rel="stylesheet" type="text/css" href="css/All.css">
</head>
<body>
	<header>
		<h1>Prototype</h1>
	</header>

	<p>↓会員登録がまだの方はこちら↓</p>
	<a href="Create.jsp">新規登録</a>
	<br>
	<br>
	<p>↓SNSアカウントでログインはこちら↓</p>
	<nav>

		<ul>
			<li><a href="TwitterLoginAction">Twitter認証</a></li>
			<li><a href="GoogleOAuth">Google認証</a></li>
			<li><a href="FacebookLoginAction">Facebook認証</a></li>
		</ul>
	</nav>
	<br>
	<br>
	<a href="Main.jsp">メイン画面へ</a>
</body>
</html>