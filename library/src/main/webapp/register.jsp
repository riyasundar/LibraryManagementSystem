<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/booklogo.jpg" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<title>Sign Up</title>
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
</style>
<body>
	<div class="limiter">
		<div class="container-login100">
			<form class="login100-form validate-form">
				<h3>Account Sign Up</h3>
				<div class="wrap-input100 rs1 validate-input"
					data-validate="Password is required">
					<input class="input100" id="name" type="text" name="name"
						placeholder="Name" onchange="doCheck()"> <span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div>
					<input class="input100" id="user" type="text" name="email"
						placeholder="Email" onchange="doCheck()" > <span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div class="wrap-input100 rs1 validate-input">
					<input class="input100" id="passwrd" type="password" name="pass"
						placeholder="Password" onchange="doCheck()" > <span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div>
					<button onclick="doLoginIn(event)"
						class="login100-form-btn btn btn-lg btn-secondary"">Sign
						Up</button>
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>




<script>
var validmail;
var validpass;

function doCheck() {
    var username = document.getElementById("user").value;
    var userProp = document.getElementById("user");
    var password = document.getElementById("passwrd").value;
    var passwordProp = document.getElementById("passwrd");
    var name=document.getElementById('name').value;
    var nameProp=document.getElementById('name')

    let regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    validmail = regex.test(username);
	validpass = password.length > 6;
	
    if (validmail) {
      userProp.style.borderColor = "green";
    } else {
      userProp.style.borderColor = "darkred";
    }
    if (name.length > 1) {
        nameProp.style.borderColor = "green";
    } else {
      passwordProp.style.borderColor = "darkred";
    }

    if (password.length > 6) {
      passwordProp.style.borderColor = "green";
    } else {
      passwordProp.style.borderColor = "darkred";
    }
}

function doLoginIn(event) {
	  event.preventDefault();
	  if(validmail && validpass) {
		  var url = 'http://localhost:8080/api/user/';
			var userDetails = {};
			userDetails['username'] = document.getElementById('name').value;
			userDetails['password'] = document.getElementById('passwrd').value;
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
			     if (this.readyState == 4 && this.status == 200) {
			    	 window.open("http://localhost:8080/Login.jsp","_self");
			     }
			};
			xhttp.open("POST",url , true);
			xhttp.setRequestHeader("Content-type", "application/json");
			xhttp.send(JSON.stringify(userDetails));
// 			window.open("http://localhost:8080/Login.jsp","_self");
		}
}

</script>