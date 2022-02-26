package main.service;

import java.util.List;

import main.dto.Empleado;

public interface IEmpleadoService {
	public List<Empleado> listarEmpleados();
	
	public List<Empleado> listarEmpleadoNombre(String nombre);	
	
	public Empleado empleadoXdni(String dni);

	public Empleado guardarEmpleado(Empleado empleado);		

	public Empleado actualizarEmpleado(Empleado empleado);

	public void eliminarEmpleado(String dni);
}
