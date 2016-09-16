<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?">
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="./js/sample.js">
	
</script>
<title>Prototype - About</title>
<link rel="stylesheet" type="text/css" href="css/All.css">

</head>
<body onload="initialize()" >
	<Div Align="center">
		<h1>Prototype</h1>
	</Div>
	<br>
	<br>


	<Div Align="center">
		<h1>GoogleMAP</h1>
	</Div>
	<br>
	<br>
	<br>
	<div class="about_contents"></div>
	<div id="map_canvas" align="center" style="width: 500px; height: 300px"></div>
				<div align="center">
				<input type="submit" value="現在地取得" onclick="dia()" class="now">
					<div class="container">
						<s:form id="gpsFrom" name="GPS"  method="post">
							<input type="hidden" name="lat" value="" id="gpsFrom_lat" />
							<input type="hidden" name="lon" value="" id="gpsFrom_lon" />
							<input type="hidden" name="address" value="" id="gpsFrom_address" />
							<input type="hidden" name="lat2" value="" id="gpsFrom_lat2" />
							<input type="hidden" name="lon2" value="" id="gpsFrom_lon2" />
							<input type="hidden" name="duration" value=""
								id="gpsFrom_duration" />
							<input type="hidden" name="distance" value=""
								id="gpsFrom_distance" />
								<span class="glyphicon glyphicon-circle-arrow-right"
									aria-hidden="true"></span> <select name="shopAddress"
									id="address" class="selectpicker" onchange="search2()"
									size="1">
									<option selected>　　　　【店　舗　選　択】</option>
										<option value="東京都千代田区麹町２丁目１４">半蔵門店</option>
										<option value="東京都千代田区二番町９−１２">麹町店</option>
										<option value="東京都中央区築地３丁目１５">築地店</option>
										<option value="東京都墨田区押上１丁目１−４">押上店</option>
										<option value="東京都墨田区業平３丁目１７−６">業平店</option>
										<option value="東京都墨田区東向島２丁目２６−９">東向島店</option>
										<option value="東京都中央区新富２丁目１２">新富駅前店</option>
										<option value="東京都台東区東上野３丁目１８−１１">上野駅前店</option>
										<option value="東京都台東区東上野３丁目３３−２">稲荷町店</option>
										<option value="東京都台東区上野４丁目２">上野御徒町店</option>
								</select>
						</s:form>
						</div>
					</div>
			
	

	<Div Align="center">
		<a href="Main.jsp">メイン画面へ</a>
	</Div>
</body>
</html>

