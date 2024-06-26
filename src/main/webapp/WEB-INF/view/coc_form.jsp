<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form Template</title>
<!-- Import Materialize CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
	rel="stylesheet">
<!-- Import Material Icons -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
/* Custom styles */
body {
	background-color: white;
	color: black;
}

/* Form container styling */
.form-container {
	background-color: #f0f0f0; /* Light grey background */
	padding: 20px;
	margin: 20px auto;
	border-radius: 8px;
	max-width: 600px;
}

.input-field label {
	position: static;
	transform: none;
	font-size: 16px;
	color: #616161; /* Adjust the color as desired */
}

.input-field input:focus+label, .input-field input:valid+label {
	transform: none;
	font-size: 16px;
}
</style>
</head>

<body>
	<!-- Form container -->
	<div class="container form-container">
		<h4>Certificate of compliance Form</h4>
		<form action="generate" method="post">
			<!-- Description field -->
			<div class="input-field">

				<i class="material-icons prefix">description</i> <input type="text"
					id="description" name="description"> <label
					for="description">Description</label>
			</div>

			<!-- Part no field -->
			<div class="input-field">

				<i class="material-icons prefix">code</i> <input type="text"
					id="partNo" name="partNo"> <label for="partNo">Part number</label>
			</div>

			<!-- PO no field -->
			<div class="input-field">

				<i class="material-icons prefix">receipt_long</i> <input type="text"
					id="poNo" name="poNo"> <label for="poNo">PO number</label>
			</div>

			<!-- PO Date field -->
			<div class="input-field">

				<i class="material-icons prefix">event</i> <input type="date"
					id="poDate" name="poDate"> <label for="poDate">PO Date</label>
			</div>

			<!-- Invoice no field -->
			<div class="input-field">
				<i class="material-icons prefix">description</i> <input type="text"
					id="invoiceNo" name="invoiceNo"> <label for="invoiceno">Invoice number</label>
			</div>

			<!-- Invoice Date field -->
			<div class="input-field">
				<i class="material-icons prefix">event</i> <input type="date"
					id="invoiceDate" name="invoiceDate"> <label
					for="invoiceDate">Invoice Date</label>
			</div>

			<!-- Quantity field -->
			<div class="input-field">
				<i class="material-icons prefix">format_list_numbered</i> <input
					type="number" id="quantity" name="quantity" min="0"> <label
					for="quantity">Quantity</label>
			</div>

			<!-- Material field -->
			<div class="input-field">
				<i class="material-icons prefix">layers</i> <input type="text"
					id="materialKind" name="materialKind"> <label for="materialKind">Material Kind</label>
			</div>

			<!-- Finish field -->
			<div class="input-field">
				<i class="material-icons prefix">color_lens</i> <input type="text"
					id="finish" name="finish"> <label for="finish">Finish</label>
			</div>

			<!-- Submit button -->
			<button class="btn waves-effect waves-light" type="submit"
				name="action">
				Submit <i class="material-icons right">send</i>
			</button>
		</form>
	</div>

	<!-- Import Materialize JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>

</html>
