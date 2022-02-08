<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Homepage</title>
	<link rel="stylesheet" type="text/css" href="styleHome.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="navbar">
			<img src="imageHome/RS.png" class="logo">
			<nav>
				<ul>
					<li><a href="#homepage">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="userManual.jsp">User Manual</li>
					<li>
					<div class="dropdown"><a>Login</a>
				    <div class="dropdown-content">
				      <a href="loginAdmin.jsp">Admin</a>
				      <a href="loginStaff.jsp">Staff</a>
				  
                                      <a href="logincdt.jsp">Candidate</a>
                                      <a href="logindpt.jsp">Department</a>
				    </div>
					</div></li>
				</ul>
			</nav>
			<img src="imageHome/menu.png" class="menu-icon">
		</div>
<a id="homepage">
		<div class="row">
			<div class="col">
				<h1>Build Your Carrier here</h1>
				<h5>Register now to take a chance working in the expert industries </h5>
			    
			</div>

			<div class="col">
				<img src="imageHome/9.PNG" ><br>
                                <img src="imageHome/7.PNG" ><br>
			</div>
		</div>
		<a id="about">
		<div class="row" >
			<div class="image">
                            <img src="imageHome/RS.png" width="300" height="400">
                  </div>
                  <div class="text">
                    <p>Rootsquare Technologies is a fast-growing, innovative IT Services and Enterprise IT company based in Malaysia that provides consulting, development, and maintenance services in the areas of Information Technology, Software development, System Integration, and Custom Applications development via its offshore, onsite, and dedicated delivery teams, and is driven by domain expertise, commitment, and client satisfaction. 
                        With a highly skilled technical and functional team, RST now has a varied portfolio serving customers all over the world.RST has over 30 pleased customers throughout the world who use a variety of technologies. 
                        Currently, the company is looking for employees to fill existing vacancies in the company. RST has set up this hiring system to make it easier for them to find employees according to the designated department.
                        </p
                  </div>
		</div>
	</a>
</body>
</html>