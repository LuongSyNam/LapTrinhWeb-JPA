<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
.container label, .container input {
	display: block;
	margin-bottom: 10px; /* Khoảng cách giữa các trường */
}

.container input {
	width: 50%;
	padding: 8px; /* Thêm khoảng cách bên trong cho ô nhập liệu */
	box-sizing: border-box; /* Đảm bảo chiều rộng bao gồm cả padding */
}

.registerbtn {
	margin-top: 20px;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

.registerbtn:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<form action="/ltwebct4/register" method="post">
		<div class="container">
			<h1>Register</h1>
			<hr>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" id="email" required><br>
			<br> <label for="fullname"><b>FullName</b></label> <input
				type="text" placeholder="Enter Fullname" name="fullname"
				id="fullname" required><br> <br> <label
				for="username"><b>UserName</b></label> <input type="text"
				placeholder="Enter Username" name="username" id="username" required><br>
			<br> <label for="phone"><b>Phone</b></label> <input type="text"
				placeholder="Enter Phone" name="phone" id="phone" required><br>
			<br> <label for="psw"><b>Password</b></label> <input
				type="password" placeholder="Enter Password" name="psw" id="psw"
				required><br> <br> <label for="psw-repeat"><b>Repeat
					Password</b></label> <input type="password" placeholder="Repeat Password"
				name="psw-repeat" id="psw-repeat" required><br> 

			<hr>
			<button type="submit" class="registerbtn">Register</button>
		</div>
	</form>
</body>
</html>