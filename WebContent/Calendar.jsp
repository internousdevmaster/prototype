<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.calendar {
	width: 50%;
	border-collapse: collapse;
	border-top: 1px solid #ccc;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

.calendar th {
	width: 25%;
	padding: 6px;
	text-align: left;
	color: #666666;
	background-color: #eee;
	border-bottom: 1px dotted #999;
	border-left: 1px solid #ccc;
}

.calendar td {
	padding: 6px;
	background-color: #fff;
	border: 1px solid #b9b9b9;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カレンダー</title>
</head>
<body>
	<div align=center>
			<s:form action="CalendarAction">
				<input type="hidden" name="move" value="-1">
				<button type="submit">先月</button>
			</s:form>
			<s:form action="CalendarAction">
				<input type="hidden" name="move" value="1">
				<button type="submit">来月</button>
			</s:form>
		<s:property value="#session.year" />年
		<s:property value="#session.month" />月
		<table class="calendar">
			<tr>
				<td>日</td>
				<td>月</td>
				<td>火</td>
				<td>水</td>
				<td>木</td>
				<td>金</td>
				<td>土</td>
			</tr>
			<tr>
				<s:iterator value="calendarList" status="stat">
					<td><s:property value="day" /></td>
					<s:if test="%{#stat.modulus(7) == 0}">
						<tr></tr>
					</s:if>
				</s:iterator>
			</tr>
		</table>
	</div>
	<Div Align="center"><a href="Main.jsp">メイン画面へ</a></Div>
</body>
</html>