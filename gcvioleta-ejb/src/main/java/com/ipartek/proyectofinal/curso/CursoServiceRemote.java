package com.ipartek.proyectofinal.curso;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.proyectofinal.persistence.Curso;

/**
* <h2> Esta interfaz define métodos CRUD.</h2>
*
@author Violeta Gonzalez
*
*
**/

@Remote
public interface CursoServiceRemote {

	public List<Curso> getAll();
	public Curso getById(long codigo);
	public Curso create(Curso curso);
	public Curso update(Curso curso);
	public void delete(long codigo);
	
}
