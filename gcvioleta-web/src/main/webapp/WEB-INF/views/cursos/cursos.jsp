<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<jsp:include page="../defaultHeader.jsp" />

<spring:message var="formCrear" scope="request"  text="Nuevo curso" code="form.crear" />
<spring:message var="formEditar" scope="request"  text="Editar" code="form.editar" />
<spring:message var="formBorrar" scope="request"  text="Borrar" code="form.borrar" />

<section class="row">
		
		<header class="col-xs-12"><h2 class=""> ${cursosTitulo } </h2></header>

	
		<div class="flex-container boton">
			<div class="col-xs-6 col-lg-4" >
				<a class="btn btn-info" style="margin-bottom:5px" href="<c:url value='/cursos/addCurso' />">${formCrear}</a>
			</div>
		</div>
	

	<div class="flex-container">
		<div class="row">
				<div class="col-xs-6 col-sm-3 col-lg-4" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Identificador</div>
				<div class="col-xs-12 col-sm-6 col-lg-8" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Curso</div>
		</div>
	</div>
	
		<c:choose>
			<c:when test="${not empty listadoCursos}">
				<c:forEach var="curso" items="${listadoCursos}">
					<div class="flex-container">
						<div class="row">
							<div class="col-xs-6 col-sm-3 col-lg-4" style="display: inline-block">${curso.idProxCurso}</div>
							<div class="col-xs-12 col-sm-6 col-lg-8" style="display: inline-block">${curso.nomCurso}</div>				
						</div>
						<div>
							<a class="btn btn-success col-xs-3 col-sm-1 col-lg-2" href="<c:url value='/cursos/editCurso/${curso.codigo}'/>">${formEditar}</a>
						</div>
						<div>
							<a class="btn btn-danger col-xs-3 col-sm-1 col-lg-2" href="<c:url value='/cursos/deleteCurso/${curso.codigo}'/>">${formBorrar}</a>
						</div>
					</div>
					
				</c:forEach>
				
			</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row"><span class="text-danger text-center">No se han encontrado cursos en la Base de Datos</span></div>
				</c:otherwise>
			
		</c:choose>
		
	</section>
	
	<jsp:include page="../defaultFooter.jsp" />
