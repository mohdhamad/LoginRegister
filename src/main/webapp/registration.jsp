<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form of InterraIT</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="index.jsp">

</head>
<body>

<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
					
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" required title="please fill the name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" required title="please fill the email" />
							</div>
							
							<div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label> 
                                <input type="password" name="pass" id="pass" placeholder="Password" 
                                       minlength="6" required 
                                    title="Password must be at least 6 characters long" />
                               </div>
							
								<div class="form-group">
								<label for="address"><i class="zmdi zmdi-email"></i></label> <input
									type="text" name="address" id="add" placeholder="Your CITY" required title="please fill this field" />
							</div>

							 <div class="form-group">
                                <label for="DOJ"><i class="zmdi zmdi-calendar"></i></label>
                                <input type="date" name="DOJ" id="DOJ" required 
                                    max="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" 
                                    placeholder="Date of Joining" />
                            </div>
                            
                             

							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no"  minlength="10" required title="Mobile number must be of 10 digits" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/interrait.image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">Go back to Login Page
							</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
	var status=document.getElementById("status").value;
	
	if(status == "success"){
      swal("Congrats","Account Created Successfully","success");
}
	
	
	</script>
	



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>