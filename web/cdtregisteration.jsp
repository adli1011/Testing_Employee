
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Candidate" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Candidate</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style type="text/css">
        .wrapper{
            width: 500px;
            margin: 0 auto;
        }
    </style>
    
<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>
</head>
<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                      
                        <h2>Register Candidate Profile</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    <form action="Registercdt.do" method="POST">
                    
                      <div >
                            <label>Candidate id</label>
                            <input type="text" name="cdtId" class="form-control"><br>
                        </div>
                        <div >
                        <div >
                            <label>Name</label>
                            <input type="text" name="cdtName" class="form-control"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="cdtEmail" class="form-control" >
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="cdtAddress" class="form-control" ><br>
                        </div>
                        <div>
                            <label>Phone Number</label>
                            <input type="text" name="cdtTell" class="form-control"><br>
                        </div>
                        
                        <br>
                         <div>
                            <label>Password</label>
                            <input type="password" name="cdtPass" class="form-control" ><br>
                        </div>
                        <div>
                            <label>Confirm Password</label>
                            <input type="password" name="cdtPassCom" class="form-control" >
                        </div>
                        <center>
                    <h3 style="color:red;">
                   <c:if test="${not empty errorMsgs}">
                <div style='padding-left:100px;'>
                <font color='red'>
                <c:forEach var="message" items="${errorMsgs}">
                 - ${message}<br>
                </c:forEach>
                </font>
                </div>
             </c:if>
            </c:forEach>
                    </h3>
                    </center>
                        <input type="submit" style='width: 100px;' name="submit" class="btn btn-primary" value="Submit">
                        <button class="btn btn-default" style='width: 100px;' onclick="if(confirm('Cancel register ?')) window.location.href = 'logincdt.jsp'; return false;">Cancel</button>
                </div>
                    </form>
            </div> 
                    
        </div>
    </div>
</body>
</html>

