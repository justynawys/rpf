<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>

<div id="content-wrapper" class="d-flex flex-column">

    <div id="content">

        <div class="container-fluid">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h1 class="m-0 font-weight-bold text-primary">Lista Szafek dla projektu: ${projects.name}</h1>
                    <h6 class="m-0 font-weight-bold text-primary"><a href="/cabinets/add/${projects.id}">Dodaj szafke</a></h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Ilość szafek</th>
                                <th>Wysokość x Szerokość x Głębokość</th>
                                <th>Plecówka</th>
                                <th>Boki</th>
                                <th>Front</th>
                                <th>Opcje</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Ilość szafek</th>
                                <th>Wysokość x Szerokość x Głębokość</th>
                                <th>Boki</th>
                                <th>Plecówka</th>
                                <th>Front</th>
                                <th>Opcje</th>
                            </tr>
                            </tfoot>
                            <tbody>

                            <c:forEach items="${projects.cabinets}" var="cabinets">
                                <tr>
                                    <td>${cabinets.boxQuantity}</td>
                                    <td>${cabinets.height}x${cabinets.width}x${cabinets.depth}</td>
                                    <td>
                                        <li>Rodzaj płyty ${cabinets.backBoard.typeBord.bord}</li>
                                        <li>Kolor płyty ${cabinets.backBoard.colors.color}</li>
                                        <li>${cabinets.backBoard.width}x${cabinets.backBoard.length}</li>
                                    </td>
                                    <td>
                                        <ul>
                                            <li>Rodzaj płyty ${cabinets.sideBoard.typeBord.bord}</li>
                                            <li>Kolor płyty ${cabinets.sideBoard.colors.color}</li>
                                            <li>Bok: ${cabinets.sideBoard.sideWidth}x${cabinets.sideBoard.sideLength}</li>
                                            <li>Wieniec: ${cabinets.sideBoard.bottomWidth}x${cabinets.sideBoard.bottomLength}</li>
                                            <li>Belka: ${cabinets.sideBoard.barWidth}x${cabinets.sideBoard.barLength}</li>
                                            <li>Ilość półek ${cabinets.sideBoard.shelfQuantity}: ${cabinets.sideBoard.shelfWidth}x${cabinets.sideBoard.shelfLength}</li>
                                        </ul>
                                    </td>

                                    <td>
                                        <li>Rodzaj płyty ${cabinets.fronts.typeBord.bord}</li>
                                        <li>Kolor płyty ${cabinets.fronts.colors.color}</li>
                                        <li>Lewa: ${cabinets.fronts.leftWidth}</li>
                                        <li>Prawa: ${cabinets.fronts.rightWidth}</li>
                                    </td>
                                    <td><a href="/cabinets/delete/${projects.id}/${cabinets.id}">Usuń</a></td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
        <div class="container my-auto">
            <div class="copyright text-center my-auto">
                <span>Copyright &copy; Your Website 2020</span>
            </div>
        </div>
    </footer>
    <!-- End of Footer -->

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