<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   

<section class="row">
		
		<header class="col-xs-12"><h2 class=""> ${cursosTitulo } </h2></header>
	
	
		<div class="row">
				<div class="col-xs-2 col-md-4 col-lg-2" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Identificador</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Curso</div>
				
			<!-- <div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Activo</div>   -->
		</div>
		
		<c:choose>
			<c:when test="${not empty listadoCursos}">
				<c:forEach var="curso" items="${listadoCursos}">
				<div class="row">
					<div class="col-xs-2 col-md-4 col-lg-2">${curso.IdProxCurso}</div>
					<div class="col-xs-1 col-md-2 col-lg-1">${curso.NomCurso}</div>				
				</div>
				</c:forEach>
				
			</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row"><span class="text-danger text-center">No se han encontrado cursos en la Base de Datos</span></div>
				</c:otherwise>
			
		</c:choose>
		
	</section>