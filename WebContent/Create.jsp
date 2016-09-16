<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

.errorMessage{
list-style-type: none
}


</style>
<meta charset="UTF-8">
<title>Prototype - Create</title>

</head>
<body>
	<header>
		<div Align="center"><h1>Prototype</h1></div><br><br>

		<div Align="center"><h1>新規登録画面</h1></div><br><br><br>
	</header>

	<div Align="center">
	<s:form action="CreateUserAction">
		<br> パスワードを入力してください <br>
		<input type="password"
			name="password" size="30" maxlength="30"> <br>
			<font  color="red"><s:fielderror><s:param value="%{'password'}" /></s:fielderror></font>
			 <br>メールアドレスを入力してください <br>
		<input type="text" name="email"
			size="30" maxlength="30"> <br>
			<font color="red"><s:fielderror><s:param value="%{'email'}" /></s:fielderror></font>
			 <br> 名前を入力してください <br>
		<input type="text" name="user" size="30" maxlength="30"><br>
			<font color="red"><s:fielderror><s:param value="%{'user'}" /></s:fielderror></font>

		<input class="submit_button" type="submit" value="送信" >
		</s:form>
	</div>
	<br>

	<div align=center>
		<br><br><a href="Login.jsp">ログイン画面へ</a> <br> <a href="Main.jsp">メイン画面へ</a>



	</div>
</body>
</html>