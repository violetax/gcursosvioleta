package com.ipartek.proyectofinal.api.restfulclients;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.ipartek.proyectofinal.persistence.Curso;

public class CursoRestClientImp implements CursoRestClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(CursoRestClientImp.class);
	
	@Override
	public List<Curso> getAll() {
		
		RestTemplate template = new RestTemplate();
		List<Curso> cursos = null;
		
		cursos = template.getForObject(CursoRestClient.URL + ".json", List.class);
		
		LOGGER.debug("REST getAll cursos: " + cursos.toString());
		
		return cursos;
	}

	@Override
	public Curso getById(int codigo) {
		
		RestTemplate template = new RestTemplate();
		Curso curso = null;
		
		curso = template.getForObject(CursoRestClient.URL + "/", Curso.class);
		
		LOGGER.debug("REST getById curso: " + curso.toString());
		
		return curso;
	}

	@Override
	public Curso create(Curso curso) {
		
		RestTemplate template = new RestTemplate();
		URI uri = template.postForLocation(CursoRestClient.URL, curso);
		
		Curso soc = template.getForObject(uri, Curso.class);
		
		LOGGER.debug("REST create curso: " + soc.toString());
		
		return soc;
	}

	@Override
	public Curso update(Curso curso) {
		
		RestTemplate template = new RestTemplate();
		
		template.put(CursoRestClient.URL + "/" + curso.getCodigo(), curso);
		
		LOGGER.debug("REST update curso: " + curso.toString());
		
		return curso;
	}

	@Override
	public void delete(int codigo) {
		RestTemplate template = new RestTemplate();
		template.delete(CursoRestClient.URL + "/" + codigo); 

		LOGGER.debug("REST delete curso");
	}
}
