
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
</style>
<script>
	function onLoad() {
		console.log('called');
		//$('#MessageModal').modal('show');

	}
	
	function registerUser(){
		var firstName = $('#j_firstname').val();
		var lastName = $('#j_lastname').val();
		var emailid = $('#j_emailid').val();
		var username = $('#j_username').val();
		var password = $('#j_password').val();
		var roles = $('#roles').val();

		var request = {};
		request.firstName = firstName;
		request.lastName = lastName;
		request.emailid = emailid;
		request.username = username;
		request.password = password;
		request.roles = roles;
		var requestJSON = JSON.stringify(request);
		console.log(requestJSON);
		$.ajax({
            type: "POST",
            contentType:"application/json",
            url: "registerUser",
            data: requestJSON,
            timeout: 600000,
            success: function (data) {
                console.log("success");
                if(data.status == 'FAIL'){
                    $('#message').html('<span style="color: red; font-weight: bold;">' +data.message + '</span>');
                }
                if(data.status == 'SUCCESS'){
                    $('#message').html('<span style="color: green; font-weight: bold;">' +data.message + '</span>');
                }
            },
            error: function (e) {
                console.log("failed");
            }
  		 });
	}
</script>

</head>
<body
	style="background-image: linear-gradient(rgb(127, 127, 213), rgb(134, 168, 231), rgb(145, 234, 228));"
	onload="onLoad()">

	<div class="container-fluid">
		<div class="page-header">
			<div class="row">
				<h1 class="banner" style="text-align: center;">Registration
					form</h1>

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
						<h4 class="modal-title">Registration form</h4>
					</div>
					<div class="modal-body">
						<div id="msg"
							style="text-align: center; font-weight: bold; border: 0px solid green;">
							Hello ! You have successfully registered with us!!</div>
						<br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="mainCloseBtn">Close</button>
					</div>

				</div>

			</div>
		</div>

		<div class="jumbotron d-flex align-items-center">
			<form name="form-registration">

				<div class="row ">
					<div class="col-xs-3 col-sm-3 leftRow"></div>

					<div class="col-xs-6 col-sm-6 middleRow">
						<label for="usr">First Name :</label> <input type="text"
							class="form-control" id = "j_firstname"> <label for="usr">Last
							Name :</label> <input type="text" class="form-control" id = "j_lastname">
						<label for="usr">Email Id :</label> <input type="text"
							class="form-control" id = "j_emailid"> <label for="usr">User
							name :</label> <input type="text" class="form-control" id = "j_username">
						<label for="usr">Password :</label> <input type="password"
							class="form-control" id = "j_password"> <br>
                        <label for="roles">Define you: </label>

                        <select class = "form-control" name="roles" id="roles">
                          <option value="admin">Admin</option>
                          <option value="user">User</option>
                          <option value="finance_manager">Finance Manager</option>
                          <option value="seller">Seller</option>
                        </select>
                        <div id= 'message'></div>
                        <br><br>
						<input class="btn btn-primary" type="button" value="Submit" onclick="registerUser();">
						<!-- <button class="btn btn-primary" onclick="registerUser();$('#overlay').fadeIn();">Submit</button> -->
						<button type="reset" class="btn btn-primary">Cancel</button>


					</div>
					<div class="col-xs-3 col-sm-3 rightRow"></div>
				</div>

				<br> <br>

			</form>
		</div>


	</div>


</body>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>
