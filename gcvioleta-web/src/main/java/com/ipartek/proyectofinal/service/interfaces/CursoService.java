package com.ipartek.proyectofinal.service.interfaces;

import java.util.List;

import com.ipartek.proyectofinal.curso.CursoServiceRemote;
import com.ipartek.proyectofinal.persistence.Curso;

/**
*
*
@author Violeta Gonzalez
*
*
**/

public interface CursoService {

	public void setCursoServiceRemote(CursoServiceRemote cursoService);
	
	public List<Curso> getAll();
	public Curso getById(long codigo);
	public Curso create(Curso curso);
	public Curso update(Curso curso);
	public void delete(long codigo);
	
}
