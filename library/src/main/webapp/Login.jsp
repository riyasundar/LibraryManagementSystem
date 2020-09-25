<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-sc00ale=1" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<!-- <link rel="icon" type="image/png" href="images/booklogo.jpg" /> -->
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<title>Login</title>
</head>
<style>
.limiter {
	background-color: #f8f8f8;
	height: 100vh;
	width: 100vw;
	display: grid;
	place-items: center;
}

.container-login100 {
	padding: 100px;
	text-align: center;
	border-radius: 10px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px;
	background-color: gainsboro;
}

.info-container {
	height: 40px;
	display: flex;
	align-items: center;
	justify-content: center;
}

button {
	background-color: black;
	width: 100%;
	color: rgb(230, 183, 96);
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}

form {
	/* border: 3px solid #f1f1f1; */
	width: 15vw;
}

input[type="text"], input[type="password"] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid darkgoldenrod;
	box-sizing: border-box;
}

button:hover {
	opacity: 0.7;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}

.container {
	padding: 25px;
	background-color: lightblue;
}

.txt1 {
	margin-right: 10px;
}
</style>
<body>
	<div class="limiter">
		<div class="container-login100">
			<form class="">
				<h3>Account Login</h3>

				<div class="">
					<input class="input100" id="user" type="text" name="user"
						placeholder="userName" /> <span
						class="focus-input100-1"></span> <span class="focus-input100-2"></span>
				</div>

				<div class="">
					<input class="input100" id="passwrd" type="password" name="pass"
						placeholder="Password" /> <span
						class="focus-input100-1"></span> <span class="focus-input100-2"></span>
				</div>

				<div class="">
					<button type="button" id="number-submit" onclick="doLoginIn(event)"
						class="login100-form-btn btn btn-lg btn-secondary">
						Sign in</button>
				</div>

				<div class="info-container">
					<span class="txt1"> Create an account? </span> <a
						href="/register.jsp" class="txt2 hov1"> Sign up </a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

<script>
  
  function doLoginIn(event) {
	  event.preventDefault();
	  var username = document.getElementById('user').value;
	  localStorage.setItem('user',username);
		  var url = 'http://localhost:8080/api/user/'+username;
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if(this.responseText == 'Present'){
						localStorage.setItem('user',username);
						window.open("http://localhost:8080/index.html","_self");
					}
				}
			};
			xhttp.open("GET", url, true);
			xhttp.send();
			
  }
</script>
