package main.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "empleado")
public class Empleado {
	
	//Atributos	
	@Id	
	private String dni;
	private String nombre;
	private String apellidos;
	
	@ManyToOne
	@JoinColumn(name = "departamento")
	private Departamento departamento;	
	
	//Constructores
	public Empleado() {		
	}

	public Empleado(String dNI, String nombre, String apellidos, Departamento departamento) {
		super();
		dni = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}

	//Getters Setters
	public String getDNI() {
		return dni;
	}

	public void setDNI(String dNI) {
		dni = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [DNI=" + dni + ", nombre=" + nombre + ", Apellidos=" + apellidos + ", departamento="
				+ departamento + "]";
	}	
}
