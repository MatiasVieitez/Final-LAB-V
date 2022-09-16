package web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="Nacionalidad")
public class Nacionalidad {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nacionalidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNacionalidad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Nacionalidad() {
		
	}
	
	public Nacionalidad(String desc) {
		descripcion = desc;
	}
	
	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
