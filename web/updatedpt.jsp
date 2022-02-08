

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Department" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Department</title>
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
                      
                        <h2>Update Department</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    <form action="updatedpt.do" method="POST">
                        
                    <% String dptid= (String)session.getAttribute("currentSessionUser"); %>
                    
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM DEPARTMENT WHERE DPTID = '<%=dptid%>'
                    </sql:query>
                    
                    <c:forEach var="dpt" items="${result.rows}">
                      <div >
                            <label>Candidate</label>
                            <input type="text" name="dptid" class="form-control" value="<c:out value='${dpt.dptid}' />" readonly><br>
                        </div>
                        <div >
                        <div >
                            <label>Name</label>
                            <input type="text" name="dptName" class="form-control" value="<c:out value='${dpt.dptName}' />"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="dptEmail" class="form-control" value="<c:out value='${dpt.cdtEmail}' />">
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="dptAddress" class="form-control" value="${dpt.dptAddress}"><br>
                        </div>
                        <div>
                            <label>Phone Number</label>
                            <input type="text" name="dptTell" class="form-control" value="${dpt.cdtTell}"><br>
                        </div>
                       
                        <br>
                        <input type="hidden" name="dptPass" class="form-control" value="${dpt.cdtPass}"><br>
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
                        <button class="btn btn-primary" style='width: 100px;' onclick="if(confirm('Cancel edit ?')) window.location.href = 'indexdpt.jsp'; return false;">Cancel</button>
                </div>
                    </form>
            </div> 
                    
        </div>
    </div>
</body>
</html>
