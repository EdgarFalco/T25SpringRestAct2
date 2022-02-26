package main.service;

import java.util.List;

import main.dto.Departamento;

public interface IDepartamentoService {
	public List<Departamento> listarDepartamentos();
	
	public List<Departamento> listarDepartamentoNombre(String nombre);	
	
	public Departamento departamentoXID(Integer codigo);

	public Departamento guardarDepartamento(Departamento empleado);		

	public Departamento actualizarDepartamento(Departamento empleado);

	public void eliminarDepartamento(Integer codigo);
}
