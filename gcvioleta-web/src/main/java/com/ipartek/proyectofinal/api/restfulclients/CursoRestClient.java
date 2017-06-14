package com.ipartek.proyectofinal.api.restfulclients;

import java.util.List;

import com.ipartek.proyectofinal.persistence.Curso;


public interface CursoRestClient {

final static String URL = "http://localhost:8080/gcursosvioleta/api/cursos";
	
	public List<Curso> getAll();	
	public Curso getById(int codigo);	
	public Curso create(Curso curso);	
	public Curso update(Curso curso);	
	public void delete(int codigo);
	
}
