package com.ipartek.proyectofinal.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
* <h2> Entidad JPA: </h2>
 *
 * <h3> Entidad JPA: Curso</h3>
 *
 * <p> Esta clase recoge las propiedades de la tabla Curso.</p>
 *
 * @author Violeta Gonzalez
 *
 */

@Table(name="curso")
@Entity(name = "curso")
@NamedQueries({
	@NamedQuery(name = "curso.getAll", query = "SELECT c FROM curso as c WHERE c.activo = TRUE")})
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	private String IdProxCurso;
	private String NomCurso;
	private boolean activo;
	
	public Curso() {
		super();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getIdProxCurso() {
		return IdProxCurso;
	}

	public void setIdProxCurso(String idProxCurso) {
		IdProxCurso = idProxCurso;
	}

	public String getNomCurso() {
		return NomCurso;
	}

	public void setNomCurso(String nomCurso) {
		NomCurso = nomCurso;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return this.IdProxCurso + " " + this.NomCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime *result + (int) (codigo ^(codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Curso)) {
			return false;
		}
		Curso other = (Curso) obj;
		if (codigo != other.codigo) {
			return false;
		}
		

		return true;
	}
	
}