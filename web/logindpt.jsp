<!-- Font Awesome -->
  <link href="plugins/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css" type="text/css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css" type="text/css">
<title>Department Login</title>
<body class="hold-transition login-page">
<div class="login-box">
  <!-- /.login-logo -->
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="loginAdmin.jsp" class="h1"><b>DEPARTMENT</b></a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form  action="logindpt.do" method="POST">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="dptid" id="dptid" placeholder="Enter id" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="dptPass" id="dptPass" placeholder="Password" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
           <center>
              <input type="submit" class="btn btn-primary btn-block" value="Sign In">
              <a href="homepage.jsp" class="btn btn-default btn-block"> Cancel</a>            
          </center>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <label for="remember">
                  <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                         : request.getAttribute("errMessage") %></span>
                  </label>
            </div>
          </div>
          <!-- /.col -->
          
          
          <!-- /.col -->
        </div>
      </form>
    </div>
    <!-- /.card-body -->
  </div>
  <!-- /.card -->
</div>
<!-- /.login-box -->

</body>
</html>

