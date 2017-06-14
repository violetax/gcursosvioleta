<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<jsp:include page="defaultHeader.jsp" />

<main class="container-fluid">
	<section>
		<header><h2>Bienvenido a la gestión de cursos.</h2></header>
		
		<sec:authorize access="isAnonymous()">
			<div>
				Para realizar operaciones es necesaria su identificación.		
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div>
				Sesión autorizada comenzada.
			</div>
		</sec:authorize>
	</section>
</main>

<jsp:include page="defaultFooter.jsp" />