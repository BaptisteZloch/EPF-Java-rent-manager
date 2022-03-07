<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

 <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

   <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        ERROR...
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
   <jsp:include page='/WEB-INF/views/common/footer.jsp'></jsp:include>


</div>
<!-- ./wrapper -->

   <!-- Contains Js code imports -->
   <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>

</body>
</html>
