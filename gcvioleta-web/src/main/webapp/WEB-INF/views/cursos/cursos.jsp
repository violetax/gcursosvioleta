<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<jsp:include page="../defaultHeader.jsp" />

<spring:message var="formCrear" scope="request"  text="Nuevo curso" code="form.crear" />
<spring:message var="formEditar" scope="request"  text="Editar" code="form.editar" />
<spring:message var="formBorrar" scope="request"  text="Borrar" code="form.borrar" />

<section class="container-fluid">
		
		<header class="col-xs-12"><h2 class=""> ${cursosTitulo } </h2></header>

	<div class="row">
			<div class="col-xs-6 col-lg-4" >
				<a class="btn btn-info" style="margin-bottom:5px" href="<c:url value='/cursos/addCurso' />">${formCrear}</a>
			</div>
		</div>
	

	<table class="table">
		<tr>
			<th class="col-xs-3 col-sm-1 col-lg-2">Identificador</th>
			<th class="col-xs-6 col-sm-3 col-lg-4"">Curso</th>
			<th>Acciones</th>
		</tr>
	
		<c:choose>
			<c:when test="${not empty listadoCursos}">
				<c:forEach var="curso" items="${listadoCursos}">
					<tr>
						<td class="col-xs-3 col-sm-1 col-lg-2" ">${curso.idProxCurso}</td>
						<td class="col-xs-6 col-sm-3 col-lg-4" ">${curso.nomCurso}</td>					
						<td colspan="2" class="shortField col-xs-3 col-sm-1 col-lg-2">
							<a class="btn btn-success col-xs-3 col-sm-1 col-lg-2" href="<c:url value='/cursos/editCurso/${curso.codigo}'/>">${formEditar}</a>
						
							<a class="btn btn-danger col-xs-3 col-sm-1 col-lg-2" href="<c:url value='/cursos/deleteCurso/${curso.codigo}'/>">${formBorrar}</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<tr><td> class="row"><span class="text-danger text-center">No se han encontrado cursos en la Base de Datos</span></td></tr>
				</c:otherwise>
			
		</c:choose>
	</table>
	</section>
	
	<jsp:include page="../defaultFooter.jsp" />
