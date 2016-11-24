<%@page import="model.BEAN.Member"%>
<%@page import="model.BEAN.CoffeeShop"%>
<%@page import="model.BEAN.Drink"%>
<%@page import="model.BEAN.Drink30"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BO.DrinkBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- List drinks searched -->
<%
	ArrayList<Drink30> listDrink = new ArrayList<Drink30>();
	listDrink = (ArrayList<Drink30>)request.getAttribute("listDrink");
	
	ArrayList<CoffeeShop> listShop = new ArrayList<CoffeeShop>();
	listShop = (ArrayList<CoffeeShop>)request.getAttribute("listShop");

	ArrayList<Drink30> listHotDrink = new ArrayList<Drink30>();
	listHotDrink = (ArrayList<Drink30>)request.getAttribute("listHotDrink");
	
	ArrayList<CoffeeShop> listSummerShop = new ArrayList<CoffeeShop>();
	listSummerShop = (ArrayList<CoffeeShop>)request.getAttribute("listSummerShop");

	
	/*ArrayList<Drink> listAllDrinks = (ArrayList<Drink>) request.getAttribute("listAllDrinks");
	if (listAllDrinks == null) {
		DrinkBO drinkBO = new DrinkBO();
		listAllDrinks = drinkBO.getListAllDrinks();
	}*/
	Member memberLogined = (Member) session.getAttribute("memberLogined");
	String invoiceID = (String) session.getAttribute("invoiceID");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"
	rel="Stylesheet"></link>
<link href="css/coffeeStyle.css" rel="Stylesheet"></link>

<style>
.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	visibility: hidden;
	position: absolute;
	background-color: #ecf0f1;
	min-width: 350px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	z-index: 1;
	text-align: left;
	/* transition */
	opacity: 0;
	position: absolute;
	background-color: #ecf0f1;
	min-width: 350px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	z-index: 1;
	text-align: left;
	/* transition */
	opacity: 0;
	-webkit-transition: opacity 0.2s ease; /* Safari */
	transition: opacity 0.2s ease;
}

.dropdown:hover .dropdown-content {
	visibility: visible;
	opacity: 1;
}

.tooltip {
	position: relative;
	display: inline-block;
}

/* Tooltip text */
.tooltiptext {
	visibility: hidden;
	width: 160px;
	color: #fff;
	text-align: left;
	padding: 5px 5px;
	background-color: #271406;
	box-shadow: 2px 2px 2px #763d12;
	/* transition */
	opacity: 0;
	-webkit-transition: opacity 0.5s ease-in-out; /* Safari */
	transition: opacity 0.5s ease-in-out;
	/* Position the tooltip text - see examples below! */
	position: absolute;
	z-index: 1;
	top: 5px;
	left: 5%;
	position: absolute
}

/* Show the tooltip text when you mouse over the tooltip container */
.img-drink:hover .tooltiptext {
	visibility: visible;
	opacity: 1;
}
</style>
<title>Coffee Ordering System</title>
</head>
<body>
	<input type="hidden" id="memberLogined"
		value="<%=memberLogined == null ? 0 : 1%>">
		
	<!--menu-->
	<section class="col-xs-12 col-sm-6 col-md-8 menu">
	<div class="col-sm-4">
		<p
			style="text-align: left; margin-top: 20px; color: red; border-radius: 5px; padding: 5px;">Welcome
			to HQ Coffee Shop</p>
	</div>
	
	
	<!--search 3.0-->
	<h1>All drinks</h1>
	<div class="col-md-10 col-md-offset-2 form-group">
		<form action="/CoffeeOrderingSystem/search30">
			<div class="dropdown col-sm-10">
					<input type="hidden" name="act" value="search"> <input
						type="text" class="form-control" id="searchKey" name="searchKey"
						value="" placeholder="Type to search..." onkeyup="searchAjax()"
						onfocus="displaySearch()">
				<div class="dropdown-content" id="searchDropdown">
					<p>Search result</p>
				</div>
			</div>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-default" id="search30">Search 3.0</button>
			</div>
		</form>
	</div>
	<div class="col-md-12 col-xs-12 btn-group">
		<div class="col-md-2 col-xs-2 btn-menu">
			<div class="col-md-12 btn-drink">
				<a href="index.jsp">All</a>
			</div>
			<div class="col-md-12 btn-drink">
				<a href="search?act=search&searchKey=cafe">Coffee</a>
			</div>
			<div class="col-md-12 btn-drink">
				<a href="search?act=search&searchKey=smoothies">Smoothies</a>
			</div>
			<div class="col-md-12 btn-drink">
				<a href="search?act=search&searchKey=ice blend">Ice Blend</a>
			</div>
			<div class="col-md-12 btn-drink">
				<a href="search?act=search&searchKey=tea">Tea</a>
			</div>
		</div>
		
		<div class="col-md-10 col-xs-10 drink-group">
			<%
			if(listDrink != null){
				for (Drink30 drink : listDrink) {
			%>
			<div class="col-md-4 col-sm-4">
				<div class="col-md-12 img-drink">
					<img src="images/coffee.png"> 
				</div>
				<div class="col-md-12 name-price">
					
					<p id="name"><%=drink.getName()%></p>
				</div>
			</div>
			<%
				}
			}
			%>
			
			<%
			if(listShop != null){
				for (CoffeeShop shop : listShop) {
			%>
			<div class="col-md-4 col-sm-4">
				<div class="col-md-12 img-drink">
					<img src="images/Coffee-shop.png"> 
				</div>
				<div class="col-md-12 name-price">
					
					<p id="name"><%=shop.getName()%></p>
				</div>
			</div>
			<%
				}
			}
			%>
			
			<!-- hot -->
			<%
			if(listHotDrink != null){
				for (Drink30 drink : listHotDrink) {
			%>
			<div class="col-md-4 col-sm-4">
				<div class="col-md-12 img-drink">
					<img src="images/coffee.png"> 
				</div>
				<div class="col-md-12 name-price">
					
					<p id="name"><%=drink.getName()%></p>
				</div>
			</div>
			<%
				}
			}
			%>
			
			<!-- summer shop -->
			<%
			if(listSummerShop != null){
				for (CoffeeShop shop : listSummerShop) {
			%>
			<div class="col-md-4 col-sm-4">
				<div class="col-md-12 img-drink">
					<img src="images/Coffee-shop.png"> 
				</div>
				<div class="col-md-12 name-price">
					
					<p id="name"><%=shop.getName()%></p>
				</div>
			</div>
			<%
				}
			}
			%>
		</div>
	</div>
	</section>
	<!--    invoice-->
	<section class="col-xs-12 col-md-4 invoice"> <%
 	if (memberLogined == null) {
 %>
	<div class="col-sm-4 col-sm-offset-8">
		<button type="button" class="btn btn-success btn-block"
			data-toggle="modal" data-target="#loginModal">Login</button>
	</div>
	<%
		} else {
	%>
	<div class="dropdown pull-right">
		<button class="btn btn-success dropdown-toggle" type="button"
			data-toggle="dropdown">
			Welcome
			<%=memberLogined.getFullName()%>
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">Notification</a></li>
			<li><a href="#">Your Point</a></li>
			<li class="divider"></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</div>
	<%
		}
	%> <br>
	<h1>Invoice</h1>
	<p>Table number: 10</p>
	Invoice ID: <%
		if (invoiceID != null) {
	%> <b id="invoiceID"><%=invoiceID%></b> <%
 	} else {
 %> <b id="invoiceID"></b> <%
 	}
 %>
	<div class="col-md-12">
		<table id="invoiceTbl">
			<thead>
				<tr>
					<th>Drink</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Amount</th>
					<th>Check order</th>
				</tr>
			</thead>
		</table>
		<br>
		<div class="row">
			<div class="col-sm-offset-6">
				<label>Total amount: </label> <b style="color: red;" id="total">0</b>
				<b style="color: red;" id="total">VND</b>
			</div>
		</div>
		<div class="btn-invoice">
			<div class="col-sm-4 col-sm-offset-2">
				<form action="payment" method="post">
					<input type="hidden" name="invoiceID" id="invoiceIDInput" value="">
					<button class="btn btn-payment btn-block" id="payBtn" type="submit"
						disabled>Pay</button>
				</form>
			</div>
			<div class="col-sm-4">
				<button class="btn btn-order btn-block" id="orderBtn"
					onclick="sendOrderToServer(this, 'invoiceTbl')" disabled>Order</button>
			</div>
		</div>
	</div>
	</section>
	<div id="loginModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg" style="width: 40%; height: 250px;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<input class="hidden" id="noDisplayLoginForm"
						data-value="<%=session.getAttribute("displayLoginForm")%>">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="color: black;">Login to HQ
						System</h3>
				</div>
				<div class="modal-body" style="margin: 20px;">
					<a href="login?act=loginByQRCode" class="btn btn-danger">Login
						by using your QR Code</a> <a class="close" data-dismiss="modal"
						style="font-size: medium; margin-top: 10px;"> Continue as
						Guest</a>
					<hr>
					<label style="color: black; font-size: 130%;">Or login by
						your member account</label> <br>
					<form action="login" method="post">
						<input type="hidden" name="act" value="loginByMemberAccount">
						<label for="MemberID" style="color: black;">MemberID</label>
						<div class="row">
							<input class="form-control" type="text" name="memberID" value=""
								placeholder="Member ID"></input>
						</div>
						<br> <label for="Password" style="color: black;">Password</label>
						<div class="row">
							<input class="form-control" type="password" name="password"
								value="" placeholder="Password"></input>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-4 col-sm-offset-4">
								<button type="reset" class="btn btn-default btn-block">Reset</button>
							</div>
							<div class="col-sm-4">
								<button type="submit" class="btn btn-success btn-block">Login</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://stevenlevithan.com/assets/misc/date.format.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	‌​
	<script type="text/javascript">
		$(document).on("click", ".add-drink", function() {
			var drinkID = $(this).data('id');
			$(".modal-quantity-body #drinkID").val(drinkID);
		});
		function changeInvoiceTableCellValues(drinkID, quantity) {
			var tableInvoice = document.getElementById("invoiceTbl");
			var numOfRows = tableInvoice.rows.length;
			for (i = 1; i < numOfRows; i++) {
				var cells = tableInvoice.rows[i].cells;
				var drinkIDOfRows = cells[0].innerText.split("-")[0];
				if (drinkID == drinkIDOfRows) {
					quantity = parseFloat(cells[1].innerText)
							+ parseFloat(quantity);
					if (quantity < 0) {
						quantity = 0;
					}
					cells[1].innerText = quantity;
					cells[3].innerText = quantity
							* parseFloat(cells[2].innerText);
					cells[4].innerHTML = "<input type='checkbox' disabled>";
					return true;
				}
			}
			return false;
		}
		function createInvoiceID() {
			var invoiceID = document.getElementById("invoiceID").innerHTML;
			if (invoiceID == "") {
				var now = new Date();
				dateFormat.masks.invoiceIDTime = '"INV"yyyymmddHHMMss';
				document.getElementById("invoiceID").innerHTML = now
						.format("invoiceIDTime");
				document.getElementById("invoiceIDInput").value = document
						.getElementById("invoiceID").innerHTML;
				$.ajax({
					type : "post",
					url : "addattribute", //servlet name
					data : "invoiceID=" + now.format("invoiceIDTime"),
					success : function(result) {
						console.log(result);
					},
					error : function(xhr) {
						alert("Error in session! Please try again!");
					}
				});
			}
		}
		function addDrink(drinkID) {
			createInvoiceID();
			var table = document.getElementById("invoiceTbl");
			var name = document.getElementById("drinkName" + drinkID).value;
			var price = document.getElementById("drinkPrice" + drinkID).value;
			var quantity = document.getElementById("drinkQuantity" + drinkID).value;
			var totalAmount = document.getElementById('total');
			var oldTotalAmount = parseFloat(totalAmount.innerHTML);
			if (!changeInvoiceTableCellValues(drinkID, quantity)) {
				if (parseFloat(quantity) > 0) {
					var row = table.insertRow(table.rows.length);
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					var cell5 = row.insertCell(4);
					cell1.innerHTML = drinkID + "-" + name;
					cell2.innerHTML = quantity;
					cell3.innerHTML = price;
					cell4.innerHTML = price * quantity;
					cell5.innerHTML = "<input type='checkbox' disabled>";
					oldTotalAmount = oldTotalAmount + price * quantity;
				}
			} else {
				oldTotalAmount = oldTotalAmount + price * quantity;
			}
			if (oldTotalAmount > 0) {
				totalAmount.innerHTML = oldTotalAmount;
			} else {
				totalAmount.innerHTML = "0";
			}
			if (table.rows.length > 1) {
				document.getElementById("orderBtn").disabled = false;
			} else {
				document.getElementById("orderBtn").disabled = true;
			}
		}
		function changeAddBtn(select, drinkID) {
			var quantity = document.getElementById("drinkQuantity" + drinkID).value;
			var btnAddDrink = document.getElementById("addDrink" + drinkID);
			if (quantity > 0) {
				btnAddDrink.disabled = false;
				btnAddDrink.innerText = "Add";
				btnAddDrink.style.background = "#5cb85c";

			} else if (quantity < 0) {
				btnAddDrink.disabled = false;
				btnAddDrink.innerText = "Remove";
				btnAddDrink.style.background = "#d9534f";
			} else {
				btnAddDrink.disabled = true;
			}
		}
		function resetButtonAdd() {
			document.getElementsByName("drinkQuantityInput")[0].value = "0";
			btnAddDrink.disabled = true;
		}
		function sendOrderToServer(select, tableID) {
			var invoiceID = document.getElementById("invoiceID").innerHTML;
			var tableInvoice = document.getElementById(tableID);
			var numOfRows = tableInvoice.rows.length;
			var arrayOfDrinks = [];
			arrayOfDrinks.push(invoiceID);
			for (i = numOfRows - 1; i > 0; i--) {
				var cells = tableInvoice.rows[i].cells;
				var isOrdered = cells[4].innerHTML;
				if (!isOrdered.includes("checked")) {
					arrayOfDrinks.push(cells[0].innerText.split("-")[0] + "-"
							+ cells[1].innerText);
					cells[4].innerHTML = "<input type='checkbox' disabled checked>";
				}
				if (cells[1].innerHTML == "0") {
					tableInvoice.deleteRow(i);
				}
			}
			$
					.ajax({
						type : "post",
						url : "getorder", //servlet name
						data : "orderInfo=" + arrayOfDrinks,
						success : function(result) {
							alert(result);
							document.getElementById("payBtn").disabled = false;
							document.getElementById("orderBtn").disabled = true;

						},
						error : function(xhr) {
							alert("Sorry, we can't get your order due to an error in our service. Please order again. :)");
						}
					});
			resetButtonAdd();
		}
		function searchAjax() {
			var searchKey = document.getElementById("searchKey").value;
			$.ajax({
				type : "post",
				url : "search", //servlet name
				data : "searchKey=" + searchKey,
				success : function(result) {
					var searchDropdown = document
							.getElementById("searchDropdown");
					searchDropdown.innerHTML = "";
					console.log(result);
					var listResult = result.split("#");
					for (i = 0; i < listResult.length - 1; i++) {
						var drinkID = listResult[i].split("$")[0];
						var drinkName = listResult[i].split("$")[1];
						console.log(drinkID + "-" + drinkName);
						searchDropdown.insertAdjacentHTML('beforeend',
								"<a href='search?act=search&drinkID=" + drinkID
										+ "'>" + drinkName + "</a><br/>");

					}
				},
				error : function(xhr) {
					alert("No result!");
				}
			});
		}
		function displaySearch() {
			var searchKey = document.getElementById("searchKey").value;
			$.ajax({
				type : "post",
				url : "search", //servlet name
				data : "searchKey=" + searchKey,
				success : function(result) {
					console.log(result);
					var searchDropdown = document
							.getElementById("searchDropdown");
					searchDropdown.innerHTML = "";
					var listResult = result.split("#");
					console.log(listResult[0]);
					for (i = 0; i < listResult.length - 1; i++) {
						var drinkID = listResult[i].split("$")[0];
						var drinkName = listResult[i].split("$")[1];
						searchDropdown.insertAdjacentHTML('beforeend',
								"<a href='search?act=search&drinkID=" + drinkID
										+ "'>" + drinkName + "</a><br/>");
						//searchDropdown.innerHTML = "<a href='#'>" + listResult[i] + "</a>";
						//console.log(searchDropdown.innerHTML);
					}
				},
				error : function(xhr) {
					alert("No result!");
				}
			});
		}
		$(window).load(
				function() {
					var memberLoginedJS = document
							.getElementById("memberLogined").value;
					var noDisplayLoginForm = $("#noDisplayLoginForm").data('value');
					console.log(noDisplayLoginForm);
					if (memberLoginedJS == 0 && noDisplayLoginForm != 1) {
						$('#loginModal').modal('show');
					}
				});
		function goBack() {
			window.history.back();
		}
	</script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>