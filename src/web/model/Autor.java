package web.model;

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
@Table(name="Autor")
public final class Autor {
	
	//ignora las ignora las advertencias
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_autor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="apellido")
	private String Apellido;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = ("id_nacionalidad"))
	private Nacionalidad nacionalidad;
	
	@Column(name="email")
	private String Email;
	
	/*public Autor(int id, String nombre, String apellido, Nacionalidad nacionalidad, String email) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		this.nacionalidad = nacionalidad;
		Email = email;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
