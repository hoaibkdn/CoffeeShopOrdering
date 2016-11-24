<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String invoiceID = (String) session.getAttribute("invoiceID");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<title>Payment Service</title>
</head>
<body>
	<div class="container-fluid" style="margin-top: 50px;">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>Thank you for using our service</h3>
			</div>
			<div class="panel-body">
				<p>
					You are going to pay for the bill <b style="color: red;"><%=invoiceID%></b>
				</p>
				<p>Please choose which method you would like to pay</p>
				<form action="payment" method="post">
					<input type="hidden" name="act" value="pay">
					<div class="col-sm-4">
						<div class="panel panel-success">
							<div class="panel-heading">Internet Banking</div>
							<div class="panel-body">
								<button class="btn btn-success" type="submit" onclick="alert('Transaction succeeded!');">Use this</button>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="panel panel-info">
							<div class="panel-heading">Mobile Account Payment</div>
							<div class="panel-body">
								<button class="btn btn-info" type="submit" onclick="alert('Transaction failed!');">Use this</button>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="panel panel-warning">
							<div class="panel-heading">Cash</div>
							<div class="panel-body">
								<button class="btn btn-warning" type="submit">Use this</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script src="http://stevenlevithan.com/assets/misc/date.format.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>