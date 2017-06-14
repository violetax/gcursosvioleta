package com.ipartek.proyectofinal.api.restfulservers.curso;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.proyectofinal.persistence.Curso;
import com.ipartek.proyectofinal.service.interfaces.CursoService;

@RestController
@RequestMapping(value = "/api/curso")
public class CursoRestController {

	
	@Autowired
	CursoService cursoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoRestController.class);
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Curso> getById(@PathVariable("codigo") int codigo) {
		
		Curso curso = cursoService.getById(codigo);
		ResponseEntity<Curso> response = null;
		LOGGER.info(""+codigo+""+curso.toString());
		if (curso == null) {
			response = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Curso>(HttpStatus.OK);
		}
		
		return response;
	}
	
	public ResponseEntity<List<Curso>> getAll() {
		List<Curso> cursos = cursoService.getAll();
		ResponseEntity<List<Curso>> response = null;
		
		if (cursos == null || cursos.isEmpty()) {
			response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}
				
		return response;
	}
	
	@RequestMapping(value= "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Curso> update(@PathVariable("codigo")
	int id, @RequestBody Curso curso) {
		
	//@PathVariable("codigo") int id relaciona codigo e id.
		
		Curso cur = cursoService.getById(id);
		ResponseEntity<Curso> response = null;
		
		if (cur == null) {
			response = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {
			
			try {
		
				cur = cursoService.update(curso);
				response = new ResponseEntity<Curso>(cur, HttpStatus.ACCEPTED);
				
			} catch (Exception e) {
				response = new ResponseEntity<Curso>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return response;
		
	}

	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Curso> deleteById(@PathVariable("codigo")
	int id) {
	
		Curso cur = cursoService.getById(id);
		ResponseEntity<Curso> response = null;
		
		if (cur == null) {
			response = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {
			cursoService.delete(id);
			response = new ResponseEntity<Curso>(HttpStatus.NO_CONTENT);
		}
		
		return response;
		
	}
	
}