<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../defaultHeader.jsp" />

<section class="row">
		<c:url var="sendUrl" value="/cursos/save"/>
		<c:url var="cancelUrl" value="/cursos"/>
	
	<form:form action="${sendUrl }" method="post" cssClass="form-horizontal" modelAttribute="curso">
		<c:if test="${!empty curso}">
			<form:hidden path="codigo"/>
		</c:if>
		
		
		<div class="form-group">
			<form:label path="IdProxCurso" cssClass="control-label  col-xs-2">Identificador:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="IdProxCurso" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="IdProxCurso" cssClass="text-danger col-xs-6" />
		</div>
		
		<div class="form-group">
			<form:label path="NomCurso" cssClass="control-label  col-xs-2">Nombre:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="NomCurso" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="NomCurso" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<div class="col-md-offset-3">
				<button type="submit" class="btn btn-success">${formGuardar}</button>
				<a class="btn btn-warning" href="${cancelUrl}">${formCancelar}</a>
			</div>
		</div>
		<form:hidden path="activo"/>
	</form:form>
	</section>
	
	<jsp:include page="../defaultFooter.jsp" />

