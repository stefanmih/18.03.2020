<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	margin: 10px;
	padding: 10px;
}

form {
	margin: 0 auto;
	width: 250px;
	position: absolute;
}

#hidden {
	visibility: hidden;
}

#delete {
	visibility: hidden;
}

#find {
	visibility: hidden;
}

table {
	width: 400px;
}
</style>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div class="alert alert-primary" role="alert">
		<%=(request.getAttribute("user") == null) ? "" : request.getAttribute("user")%>
	</div>
	<button type="button" class="btn btn-danger"
		onclick="location.href = '/Project3/application/users/logout';">Log
		out</button>
	<br>
	<br>
	<form action="/Project3/application/users/all" method="get">
		<%
			request.setAttribute("user", "Logged in as: " + request.getParameter("username"));
			request.setAttribute("username", request.getAttribute("username"));
		%>
		<button type="submit" class="btn btn-primary" name="listall"
			value="true">List all users</button>
		<br>
	</form>
	<br>
	<table class="table">
		<br>
		<%=(request.getAttribute("table") == null) ? "" : request.getAttribute("table")%>
	</table>
	<br>
	<button type="button" class="btn btn-primary"
		onclick="$('#hidden').css({
	        'visibility': 'visible'
	  	    });$('#delete').css({
			 'visibility': 'hidden'
	  	    });
	  	  $('#find').css({
				 'visibility': 'hidden'
	  	    });">Add
		user</button>
	

	<button type="button" class="btn btn-primary"
		onclick="$('#find').css({
			 'visibility': 'visible'
		  	    });$('#hidden').css({
					 'visibility': 'hidden'
		  	    });$('#delete').css({
					 'visibility': 'hidden'
		  	    });">Users on system</button>
	<br>
	<br>
	<div id="hidden">
		<form action="/Project3/application/users/add" method="get">
			<div class="form-group">
				<label for="exampleFormControlInput1">Ime</label> <input name="ime"
					class="form-control" id="exampleFormControlInput1"
					placeholder="Ime">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Prezime</label> <input
					name="prezime" class="form-control" id="exampleFormControlInput1"
					placeholder="Prezime"> <label
					for="exampleFormControlInput1">Username</label> <input name="usr"
					class="form-control" id="exampleFormControlInput1"
					placeholder="Username"> <label
					for="exampleFormControlInput1">Password</label>
					<input name="pw"
					class="form-control" id="exampleFormControlInput1"
					placeholder="Username">
					<br>
			</div>
			<br>
			<button type="submit" class="btn btn-primary" name="dodajusera">Add</button>
		</form>
	</div>
	
	<div id="find">
		<form action="/Project3/application/users/all" method="get">
			<button type="submit" class="btn btn-primary" name="loggedall">List all users on system</button>
		</form>
	</div>
</body>
</html>