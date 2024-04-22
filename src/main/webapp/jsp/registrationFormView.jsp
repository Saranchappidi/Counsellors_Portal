<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<h1> Registration Form</h1>
</head>
<body>
<form action="/Counsellor_Registration">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email_id" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>

    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter name" name="name" id="name" required>
    
    <label for="phoneNumber"><b>PhoneNumber</b></label>
    <input type="text" placeholder="Enter PhoneNumber" name="phoneNumber" id="phoneNumber" required>
    
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>