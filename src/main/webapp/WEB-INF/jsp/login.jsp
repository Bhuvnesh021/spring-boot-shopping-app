
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agro Shopping</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
#overlay {
	color: #666666;
	position: fixed;
	height: 100%;
	width: 100%;
	z-index: 5000;
	top: 0;
	left: 0;
	float: left;
	text-align: center;
	padding-top: 25%;
	opacity: .80;
}

.spinner {
	margin: 0 auto;
	height: 64px;
	width: 64px;
	animation: rotate 0.8s infinite linear;
	border: 5px solid #797754;
	border-right-color: transparent;
	border-radius: 50%;
}

.center {
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
.bg {
  /* The image used src="<c:url value="/images/agri-removebg.png" />"*/
  background-image: url("/images/login-back.jpg");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
<script>
function onLoad() {
	console.log('called');
	//$('#MessageModal').modal('show');
	
}
</script>

</head>
<!-- style="background-image:linear-gradient(rgb(127, 127, 213), rgb(134, 168, 231), rgb(145, 234, 228));" -->
<body class = "bg" onload = "onLoad()">

	<div class="container-fluid">
		<div class="page-header">
			<div class="row">
				<h1 class="banner" style = "text-align: center;">Agro Shopping</h1>

			</div>
		</div>
		<div id="overlay" style = "display: none;">
			<div class="spinner"></div>
			<br /> Loading...
		</div>
		<div id="MessageModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="background-color: #bdd4e7">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Cowin Slot Finder</h4>
					</div>
					<div class="modal-body">
						<div id="msg"
							style="text-align: center; font-weight: bold; border: 0px solid green;">
							Hello ! Bhuvnesh Welcomes you all in the Flowers store. Welcome !!</div>
						<br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="mainCloseBtn">Close</button>
					</div>

				</div>

			</div>
		</div>
		<div class="container-fluid">
		<br> <br> <br> <br> <br> <br>
		<div class="jumbotron d-flex align-items-center">
		<c:url value="/login" var="loginUrl"/>
			 <form action="${loginUrl}" method="post">

				<div class="row " >
					<div class="col-xs-6 col-sm-6 leftRow">
					<img class = "align-self-center" alt="x" src="/images/agri-removebg_.png">
					</div>
					<div class="col-xs-6 col-sm-6 rightRow">
						<label for="usr">Username :</label> <input type="text"
							class="form-control" name='username'> <label for="usr">Password
							:</label> <input type="password" class="form-control" name='password'>
						<br> <br>

                        <c:if test="${not empty message}">
						        <span style="color: red; font-weight: bold;"><c:out
								value="${message}"></c:out></span>
								<br>
						</c:if>

						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-primary">Cancel</button>
						<br><br>
						<a href="register">Click here to register</a>

					</div>
				</div>

				<br> <br>

			</form>

		</div>


	</div>
		<!--<div class="jumbotron d-flex align-items-center">
			<form name="cowinForm">

				<div class="row">
					<div class="col-xs-12 col-md-12">
						<label for="usr">Age Limit</label>
					</div>
					<div class="col-xs-12 col-md-12">
						<select class="form-control" id="ageLimit">
							<option></option>
							<option value="18">18</option>
							<option value="45">45</option>


						</select>

					</div>


				</div>

				<div class="row">
					<div class="col-xs-12 col-md-12">
						<label for="usr">Pin Codes</label>
					</div>
					<div class="col-xs-12 col-md-12">
						<input type="text" class="form-control"
							placeholder="provide pin codes comma seperated" id="pinCodes" />

					</div>

				</div>

				<div class="row">
					<div class="col-xs-12 col-md-12">
						<label for="usr">Email</label>
					</div>
					<div class="col-xs-12 col-md-12">
						<input type="text" class="form-control"
							placeholder="provide valid email address" id="emailAddress" />

					</div>

				</div>

				<br>

				<div class="row" style="margin: 0 auto; text-align: center;">

					<button type="submit" class="btn btn-primary"
						onclick="myFunction();return false;">Submit</button>


					<button type="reset" class="btn btn-primary">Reset</button>


				</div>
			</form>
		</div>-->
	</div>
</body>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>
