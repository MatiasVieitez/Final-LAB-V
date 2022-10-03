package web.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Biblioteca")
public class Biblioteca {
	
	@Id
	@Column(name="id_biblioteca")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = ("id_libro"))
	private Libro libro;
	
	@Column(name="fecha_alta")
	private Date fechaAlta;
	
	@Column(name="estado")
	private String estado;
	
	/*public Biblioteca(int id, Libro libro, Date fechaAlta, String estado) {
		super();
		this.id = id;
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
