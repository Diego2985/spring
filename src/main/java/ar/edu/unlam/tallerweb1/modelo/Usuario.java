package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String email;
	@Column
	private String password;

	private String rol;

	private Boolean activo = false;

	@Column
	private String nombre;

	@Column
	private String telefono;

	@Column
	private String direccion;

	@OneToMany
	private List<Gato> gato;

	public Usuario() {

	}

	public Long getId() {

		return id;
	}
	public void setId(Long id) {

		this.id = id;
	}
	public String getEmail() {

		return email;
	}
	public void setEmail(String email) {

		this.email = email;
	}
	public String getPassword() {

		return password;
	}
	public void setPassword(String password) {

		this.password = password;
	}
	public String getRol() {

		return rol;
	}
	public void setRol(String rol) {

		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Usuario(String email, String password){
		this.email = email;
		this.password = password;
	}
	public boolean activo(){
		return activo;
	}

	public void activar(){
		activo = true;
	}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;
	}

	public void setDireccion(String direccion) {this.direccion = direccion;}

	public String getDireccion() {return direccion;
	}

	public void setTelefono(String telefono) {this.telefono = telefono;}

	public String getTelefono() {return telefono;}
}
