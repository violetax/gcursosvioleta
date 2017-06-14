package com.ipartek.proyectofinal.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.proyectofinal.persistence.Curso;

/**
*
*
@author Violeta Gonzalez
*
*
**/

public class CursoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Curso.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// Curso curso = (Curso) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idProxCurso", "requerido.idProxCurso");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomCurso", "requerido.nomCurso");
		
	}

}
