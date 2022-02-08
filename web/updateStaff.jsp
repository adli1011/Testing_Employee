

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Staff" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style type="text/css">
        .wrapper{
            width: 500px;
            margin: 0 auto;
        }
        box{
            position: relative;
            max-width: 2000px;
            padding: 50px;
            background: rgba(0,0,0,.8);

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
            <div class="row,box">
                <div class="col-md-12">
                    <div class="page-header">
                      
                        <h2>Update Staff Profile</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    
                    <form action="updateStaff.do" method="POST">
                        
                    <% String staffId= (String)session.getAttribute("currentSessionUser"); %>
                    
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM STAFF WHERE STAFFID = '<%=staffId%>'
                    </sql:query>
                    
                    <c:forEach var="staff" items="${result.rows}">
                        <div class="box">
                      <div>
                            <label>Candidate</label>
                            <input type="text" name="staffId" class="form-control" value="<c:out value='${staff.staffId}' />" readonly><br>
                        </div>
                        <div>
                        <div >
                            <label>Name</label>
                            <input type="text" name="staffName" class="form-control" value="<c:out value='${staff.staffName}' />"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="staffMail" class="form-control" value="<c:out value='${staff.staffMail}' />">
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="staffAddress" class="form-control" value="${staff.staffAddress}"><br>
                        </div>
                        <div>
                            <label>Phone Number</label>
                            <input type="text" name="staffTel" class="form-control" value="${staff.staffTel}"><br>
                        </div>
                        </div></div>
                        <br>
                        <input type="hidden" name="staffPass" class="form-control" value="${staff.staffPass}"><br>
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
                        <button class="btn btn-primary" style='width: 100px;' onclick="if(confirm('Cancel edit ?')) window.location.href = 'indexStaff.jsp'; return false;">Cancel</button>
                </div></div>
                    </form>                    
        </div>
    </div>
</body>
</html>
