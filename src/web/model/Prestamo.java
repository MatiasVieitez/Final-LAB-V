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
@Table(name="Prestamo")
public class Prestamo {
	
	@Id
	@Column(name="id_prestamo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = ("id_biblioteca"))
	private Biblioteca biblioteca;
	
	@Column(name="fecha_prestamo")
	private Date fechaPrestamo;
	
	@Column(name="cant_dias")
	private int CantDias;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = ("id_cliente"))
	private Cliente cliente;
	
	/*public Prestamo(int id, Biblioteca biblioteca, Date fechaPrestamo, int cantDias, Cliente cliente) {
		super();
		this.id = id;
		this.biblioteca = biblioteca;
		this.fechaPrestamo = fechaPrestamo;
		CantDias = cantDias;
		this.cliente = cliente;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getCantDias() {
		return CantDias;
	}

	public void setCantDias(int cantDias) {
		CantDias = cantDias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
