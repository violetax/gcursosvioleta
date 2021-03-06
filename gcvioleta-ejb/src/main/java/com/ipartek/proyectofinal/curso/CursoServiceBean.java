package com.ipartek.proyectofinal.curso;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.ipartek.proyectofinal.persistence.Curso;

/**
 * @autor Violeta Gonzalez
 * 
 */

/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless(name="cursoServiceBean")
public class CursoServiceBean implements CursoServiceRemote {

	private static final Logger LOGGER = Logger.getLogger(CursoServiceBean.class);
	
	 @PersistenceContext(unitName="gcursosvioleta")
	 private EntityManager entityManager;

	@Override
	public List<Curso> getAll() {
		
		LOGGER.debug("Carga de cursos.");
			TypedQuery<Curso> pcursos = entityManager.createNamedQuery("curso.getAll", Curso.class);
		LOGGER.debug("Lista de cursos: " + pcursos.getResultList().size());
			return pcursos.getResultList();
	}

	@Override
	public Curso getById(long codigo) {
		Curso curso = entityManager.find(Curso.class, codigo);
		LOGGER.debug("Carga del curso con codigo: " + curso.getCodigo());
		return curso;
	}
	
	@Override
	public Curso create(Curso curso) {
		try {
			LOGGER.debug("Crear remoto curso: " + curso.toString());
			entityManager.persist(curso);
			entityManager.flush();
		} catch (Exception e) {}
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		try {
			LOGGER.debug("Editar remoto curso: " + curso.toString());
			curso = entityManager.merge(curso);
		} catch (Exception e) {}
		return curso;
	}

	@Override
	public void delete(long codigo) {
		try {
			LOGGER.debug("Borrado logico del curso.");
		entityManager.remove(entityManager.find(Curso.class, codigo));
		} catch (Exception e) {}
	}



}
