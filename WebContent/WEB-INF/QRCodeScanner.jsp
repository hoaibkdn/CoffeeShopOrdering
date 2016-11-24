<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body onload="go()">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 style="text-align: center;" class="text text-primary">Login
					HQ System Using QR Code</h1>
				<p></p>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-4 col-md-offset-3">
				<form>
					<div class="form-group">
						<label for="videoSource">Select Camera</label> <select
							id="videoSource" class="form-control"><option selected>Default
								Camera</option></select>
					</div>
				</form>
			</div>
			<div class="col-md-2"><label>&nbsp;</label><button class="btn btn-info btn-block" onclick="window.history.back();">Back</button></div>
			<br>
			<div class="col-md-6 col-md-offset-3">
				<div class="boxWrapper auto">
					<div id="hiddenImg"></div>
					<div id="qrContent" class="alert alert-danger" role="alert">
						<p>No QR Code in sight!</p>
					</div>
				</div>
				<div id="example"
					class="thumbnail embed-responsive embed-responsive-4by3"></div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>

	<script src="js/say-cheese.js"></script>

	<script src="js/qr/grid.js"></script>
	<script src="js/qr/version.js"></script>
	<script src="js/qr/detector.js"></script>
	<script src="js/qr/formatinf.js"></script>
	<script src="js/qr/errorlevel.js"></script>
	<script src="js/qr/bitmat.js"></script>
	<script src="js/qr/datablock.js"></script>
	<script src="js/qr/bmparser.js"></script>
	<script src="js/qr/datamask.js"></script>
	<script src="js/qr/rsdecoder.js"></script>
	<script src="js/qr/gf256poly.js"></script>
	<script src="js/qr/gf256.js"></script>
	<script src="js/qr/decoder.js"></script>
	<script src="js/qr/qrcode.js"></script>
	<script src="js/qr/findpat.js"></script>
	<script src="js/qr/alignpat.js"></script>
	<script src="js/qr/databr.js"></script>
	<script src="js/effects_saycheese.js"></script>
</body>
</html>
