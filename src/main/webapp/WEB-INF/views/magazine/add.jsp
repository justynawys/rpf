<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->

                <div class="p-5"  >
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Dodaj płytę</h1>
                    </div><br/>
                    <form:form method="post" modelAttribute="magazine">

                        <div class="col-sm-6 mb-3 mb-sm-0">Ilość
                            <form:input type="number" path="quantity" class="form-control form-control-user"/>
                            <form:errors path="quantity" style="color: red"/>
                        </div><br/>

                        <div class="col-sm-6 mb-3 mb-sm-0">Długość
                            <form:input type="number" path="length" class="form-control form-control-user"
                                        id="exampleLastName"/>
                            <form:errors path="length" style="color: red" />
                        </div><br/>
                        <div class="col-sm-6 mb-3 mb-sm-0">Szerokość
                            <form:input type="number" path="width" class="form-control form-control-user"
                                        id="exampleInputEmail"/>
                            <form:errors path="width" style="color: red"/>
                        </div><br/>


                        <div class="col-sm-6 mb-3 mb-sm-0">Kolor
                            <form:select path="colors" items="${colors}" itemValue="id" itemLabel="color"
                                         class="form-control form-control-user"
                                         id="exampleInputPassword" placeholder="wybierz kolor"/>
                        </div><br/>


                        <div class="col-sm-6 mb-3 mb-sm-0">Rodzaj
                            <form:select path="typeBord" items="${typeBord}" itemLabel="bord" itemValue="id"
                                         class="form-control form-control-user"
                                         id="exampleInputPassword"/>
                        </div><br/>

                        <input type="submit" value="Dodaj" class="btn btn-primary btn-user btn-block">


                    </form:form>

                </div>
            </div>
        </div>

    </div>


</div>

<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

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