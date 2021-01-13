<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">


                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Dodaj klienta</h1>
                    </div>
                    <form:form method="post" modelAttribute="customers">

                        <div class="col-sm-6 mb-3 mb-sm-0">Imię
                            <form:input path="name" class="form-control form-control-user"
                                        id="exampleFirstName"/>
                            <form:errors path="name" style="color: red" />
                        </div>
                        <br/>


                        <div class="col-sm-6 mb-3 mb-sm-0">Nazwisko
                            <form:input path="surname" class="form-control form-control-user"
                                        id="exampleLastName"/>
                            <form:errors path="surname" style="color: red" />
                        </div>
                        <br/>

                        <div class="col-sm-6 mb-3 mb-sm-0">Miasto
                            <form:input path="city" class="form-control form-control-user"
                                        id="exampleLastName"/>
                            <form:errors path="city" style="color: red" />
                        </div>
                        <br/>

                        <div class="col-sm-6 mb-3 mb-sm-0">Ulica i numer domu/mieszkania
                            <form:input path="address" class="form-control form-control-user"
                                        id="exampleLastName"/>
                            <form:errors path="address" style="color: red" />
                        </div>
                        <br/>
                        <div class="col-sm-6 mb-3 mb-sm-0">Email
                            <form:input path="email" class="form-control form-control-user"
                                        id="exampleLastName"/>
                            <form:errors path="email" style="color: red" />
                        </div>
                        <br/>
                        <div class="col-sm-6 mb-3 mb-sm-0">Numer telefonu
                            <form:input path="numberPhone" class="form-control form-control-user"
                                        id="exampleLastName"/>
                            <form:errors path="numberPhone" style="color: red" />
                        </div>
                        <br/>

                        <input type="submit" value="Dodaj" class="btn btn-primary btn-user btn-block">


                    </form:form>
                    <hr>

                </div>
            </div>
        </div>

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/resources/js/sb-admin-2.min.js" />"></script>
<!-- Page level plugins -->
<script src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="/resources/js/demo/datatables-demo.js"/>"></script>

</body>

</html>