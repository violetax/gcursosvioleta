package com.ipartek.proyectofinal.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.proyectofinal.persistence.Curso;
import com.ipartek.proyectofinal.service.interfaces.CursoService;

/**
*
*
@author Violeta Gonzalez
*
*
**/

public class CursoConverter implements Converter<String, Curso> {

	
	public CursoConverter() {
	}
	
	@Autowired
	CursoService cursoService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoConverter.class);
	
	
	@Override
	public Curso convert(String codigo) {
		Curso curso = cursoService.getById(Long.parseLong(codigo));
		
		LOGGER.info(codigo);
		LOGGER.info("Curso converter: hecho.");
		
		return curso;
	}
}
