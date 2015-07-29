<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prototype - D3</title>
<style type="text/css">
div.bar{
	display: inline-block;
	position:relative;
	width: 2px;
	height: 90px; /* この数値は実行時に上書きされます */
	background-color: #1f3134;
	margin-left: 30px;
	margin-bottom: 30px;
}
</style>
<link rel="stylesheet" type="text/css" href="css/All.css">
</head>
<body>

<input id="countOld1" type="hidden" value="<s:property value="countOld1" />">
<input id="countOld2" type="hidden" value="<s:property value="countOld2" />">
<input id="countOld3" type="hidden" value="<s:property value="countOld3" />">
<input id="countOld4" type="hidden" value="<s:property value="countOld4" />">
<input id="countOld5" type="hidden" value="<s:property value="countOld5" />">
<input id="countOld6" type="hidden" value="<s:property value="countOld6" />">
<input id="countOld7" type="hidden" value="<s:property value="countOld7" />">
<input id="countOld8" type="hidden" value="<s:property value="countOld8" />">

	&lt;注意&gt;<br>
	データベースにデータが入っていないとグラフが表示されません。<br>
	customer_infoテーブルにデータを挿入してください。<br>

	<br>
	<script src="http://d3js.org/d3.v3.min.js"></script>
	<script>

		var element1 = document.getElementById("countOld1");
		var element2 = document.getElementById("countOld2");
		var element3 = document.getElementById("countOld3");
		var element4 = document.getElementById("countOld4");
		var element5 = document.getElementById("countOld5");
		var element6 = document.getElementById("countOld6");
		var element7 = document.getElementById("countOld7");
		var element8 = document.getElementById("countOld8");
		var element11 = parseInt(element1.value, 10);
		var element12 = parseInt(element2.value, 10);
		var element13 = parseInt(element3.value, 10);
		var element14 = parseInt(element4.value, 10);
		var element15 = parseInt(element5.value, 10);
		var element16 = parseInt(element6.value, 10);
		var element17 = parseInt(element7.value, 10);
		var element18 = parseInt(element8.value, 10);

		var dataset = [ element11, element12, element13, element14, element15,element16, element17, element18 ];

		d3.select("body")
		  .data(dataset)
		  .enter()
		  .append("div")
		  .attr("class", "bar")
		  .style("height", function(d) {
             return d + "px";
        });

	</script>

	<div Align="center">
		<a href="Main.jsp">メイン画面へ</a>
	</div>
</body>
</html>