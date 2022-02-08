<%-- 
    Document   : tips
    Created on : Jul 20, 2021, 8:50:19 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Tips</title>
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
					<li><a href="homepage.jsp">Home</a></li>
					<li><a href="homepage.jsp">About</a></li>
					<li><a href="userManual.jsp">User Manual</li>
					<li>
				    <div class="dropdown"><a>Login</a>
				    <div class="dropdown-content">
				      <a href="loginAdmin.jsp">Admin</a>
				      <a href="loginStaff.jsp">Staff</a>
				  
                                      <a href="logincdt.jsp">Candidate</a>
                                      <a href="logindpt.jsp">Department</a>
					</div></li>
				</ul>
			</nav>
			<img src="imageHome/menu.png" class="menu-icon">
		</div>
                                            
		<a id="#tips">
		<div class="row" >
                <h1 class="card-title" style="color:rgb(79, 173, 255)"><b>YOUR FUTURE YOUR DREAM</b></h1>
                <h4 class="card-text"></h4>
                <div class="container">
                  <div class="image">
                    <img src="imageHome/card3.png" width="200" height="200"><br>
                  </div>
                  <div class="text"><br><br><br><br>
                      <br>
                      <ol>
                      <h2><li>Admin</li></h2>
                      <ul><li>Please head to Login and click "Admin", Please enter your credentials into the input box.</li>
                          <li>Please enter the correct "Admin ID" and  "Password".</li>
                          <li>Once Admin has successfully logged in, in the Admin Page, Admin can see their profile, able search for any candidate, and changing the password.</li>
                          <li>To delete a candidate from the database, simply click "Search Candidate" and enter Candidate ID then click "Delete Candidate"</li>
                      </ul>
                      <br>
                      <h2><li>Staff</li></h2>
                      <ul><li>Please head to Login and click "Staff", Please enter your credentials into the input box.</li>
                          <li>Please enter the correct "Staff ID" and  "Password".</li>
                          <li>Once staff has successfully logged in, in the Staff Page, Staff can see their profile.</li>
                      </ul>
                      <br>
                      <h2><li>Candidate</li></h2>
                      <ul><li>Please head to Login and click "Candidate", Please enter your credentials into the input box.</li>
                          <li>New candidates can register for a new account simply by clicking by "Click here to register"</li>
                      </ul>
                      <br>
                      <h2><li>Department</li></h2>
                      <ul><li>Please head to Login and click "Department". Please enter your credentials into the input box.</li>
                          <li>Please enter the correct "Department ID" and  "Password".</li>
                      </ul>
                    </ol>
                   
                    </p>
                  </div>
                <br>
              </div>
		</div>
	</a>
       
	<a id="#tips">
		<div class="row" >
                <h1 class="card-title" style="color:rgb(79, 173, 255)"><b>AVOID THIS</b></h1>
                <h4 class="card-text"></h4>
                <div class="container">
                  <div class="image">
                    <img src="imageHome/card4.png" width="200" height="200"><br>
                  </div>
                  <div class="text"><br><br><br><br>
                      <h2><b>Try avoiding doing this when trying to login or register</b></h2><br>
                      <ol>
                      <li>Please enter the right credentials of your own. Do not enter other people credentials to login</li>
                      <li>When a new candidate is registering, please enter the your personal details based on your IC.</li>
                      <li>Please do not forget your own personal password, for any changes of password must be done by the admin.</li>
                      <li>Please do not let any other personnel log into your personal account, the company does not take responsibility for any action.</li>
                    </ol>
                  </div>
                <br>
              </div>
		</div>
	</a>
</body>
</html>