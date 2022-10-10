package web.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Libro")
public class Libro {
	
	@Id
	@Column(name="id_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="titulo")
	private String Titulo;
	
	@Column(name="fecha_lanzamiento")
	private String fechaLanzamiento;
	
	@Column(name="idioma")
	private int Idioma;
	
	@Column(name="cant_paginas")
	private int CantPag;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = ("id_autor"))
	private Autor autor;
	
	@Column(name="descripcion")
	private String Descripcion;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "libro_x_genero", joinColumns = {@JoinColumn(name = "id_libro")}, inverseJoinColumns = {@JoinColumn(name = "id_autor")})
	private Set<Genero> listaGenero = new HashSet<Genero>();
	
	public Libro() {}

	public Libro(int id, String titulo, String fechaLanzamiento, int idioma, int cantPag, Autor autor, String descripcion,
			Set<Genero> listaGenero) {
		super();
		this.id = id;
		Titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		Idioma = idioma;
		CantPag = cantPag;
		this.autor = autor;
		Descripcion = descripcion;
		this.listaGenero = listaGenero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(String fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public int getIdioma() {
		return Idioma;
	}

	public void setIdioma(int idioma) {
		Idioma = idioma;
	}

	public int getCantPag() {
		return CantPag;
	}

	public void setCantPag(int cantPag) {
		CantPag = cantPag;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Set<Genero> getListaGenero() {
		return listaGenero;
	}

	public void setListaGenero(Set<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}
	
}
