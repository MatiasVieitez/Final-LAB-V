package web.model;

import java.io.Serializable;

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
public class Nacionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nacionalidad")
	private int id_nacionalidad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Nacionalidad() {
		
	}
	
	public Nacionalidad(String ndesc) {
		descripcion = ndesc;
	}
	
	public int getId_nacionalidad() {
		return id_nacionalidad;
	}

	public void setId_nacionalidad(int id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
