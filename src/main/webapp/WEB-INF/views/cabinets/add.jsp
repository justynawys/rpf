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
                    <h1 class="h4 text-gray-900 mb-4">Dodaj szafkę</h1>
                </div><br/>
                <form:form method="post" modelAttribute="cabinets">

                    <div class="col-sm-6 mb-3 mb-sm-0">Ilość szafek
                        <form:input type="number" path="boxQuantity" class="form-control form-control-user"/>
                        <form:errors path="boxQuantity" style="color: red"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Ilość półek
                        <form:input type="number" path="sideBoard.shelfQuantity" class="form-control form-control-user"
                                    id="exampleLastName"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Wysokość szafki(mm)
                        <form:input type="number" path="height" class="form-control form-control-user"
                                    id="exampleInputEmail"/>
                        <form:errors path="height" style="color: red"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Szerokość szafki(mm)
                        <form:input type="number" path="width" class="form-control form-control-user"
                                    id="exampleInputEmail"/>
                        <form:errors path="width" style="color: red"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Głębokość szafki(mm)
                        <form:input type="number" path="depth" class="form-control form-control-user"
                                    id="exampleInputEmail"/>
                        <form:errors path="depth" style="color: red"/>
                    </div>
                    <h4>Boki szafki</h4>

                    <div class="col-sm-6 mb-3 mb-sm-0">Rodzaj płyty
                        <form:select path="sideBoard.typeBord" items="${typeBord}" itemLabel="bord" itemValue="id"
                                     class="form-control form-control-user"
                                     id="exampleInputPassword" placeholder="wybierz kolor"/>
                    </div>

                    <div class="col-sm-6 mb-3 mb-sm-0">Kolor płyty
                        <form:select path="sideBoard.colors" items="${colors}" itemLabel="color" itemValue="id"
                                     class="form-control form-control-user"
                                     id="exampleInputPassword" placeholder="wybierz kolor"/>
                    </div>
                    <h4>Plecówka</h4>

                    <div class="col-sm-6 mb-3 mb-sm-0">Kolor płyty
                        <form:select path="backBoard.colors" items="${colors}" itemLabel="color" itemValue="id"
                                     class="form-control form-control-user"
                                     id="exampleInputPassword" placeholder="wybierz kolor"/>
                    </div>
                    <h4>Front</h4>
                    <div class="col-sm-6 mb-3 mb-sm-0">Rodzaj płyty
                        <form:select path="fronts.typeBord" items="${typeBord}" itemLabel="bord" itemValue="id"
                                     class="form-control form-control-user"
                                     id="exampleInputPassword" placeholder="wybierz kolor"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Kolor płyty
                        <form:select path="fronts.colors" items="${colors}" itemLabel="color" itemValue="id"
                                     class="form-control form-control-user"
                                     id="exampleInputPassword" placeholder="wybierz kolor"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Opcje ułożenia frontu
                        <form:select path="fronts.options" items="${optionsByFront}" itemLabel="options" itemValue="id"
                                     class="form-control form-control-user"
                                     id="exampleInputPassword" placeholder="wybierz kolor"/>
                    </div>
                    <h4>Dla asymetrycznych szerokość</h4>
                    <div class="col-sm-6 mb-3 mb-sm-0">Lewa strona(mm)
                        <form:input type="number" path="fronts.leftWidth" class="form-control form-control-user"
                                    id="exampleInputEmail"/>
                    </div>
                    <div class="col-sm-6 mb-3 mb-sm-0">Prawa strona(mm)
                        <form:input type="number" path="fronts.rightWidth" class="form-control form-control-user"
                                    id="exampleInputEmail"/>
                    </div>


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