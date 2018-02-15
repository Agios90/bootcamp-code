<!DOCTYPE html>
<html style="overflow-y: hidden;">
<head>
	<link rel=stylesheet type="text/css" href="css.css">
	<link rel=stylesheet type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <meta charset="UTF-8"/>
	<title>Register new user</title>
</head>
<body>

    <div class="container">

        <div class="card card-container">
		
            <img class="profile-img-card" src="https://i.imgur.com/UXsx5gU.jpg" alt="" />
			
            <p id="profile-name" class="profile-name-card"> Lottery webapp - Registration</p>
            <form class="form-signin" action="registerPLACEHOLDER" method="post">
                <span id="username" class="username"></span>
                <input type="text" name ="inputName" id="inputName" class="form-control" placeholder="Username" required autofocus>
                <input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Password" required>
                <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="Confirm Password" required>
                <button id="searchbtn" class="btn btn-lg btn-primary btn-block btn-signin" type="submit" onclick="return Validate()">Register</button>
            </form>
            
        </div>
    </div>
	
	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("inputPassword").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
	
</body>
</html>