package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IEmpleadoDAO;
import main.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoDAO iempleadosDAO;
	
	@Override
	public List<Empleado> listarEmpleados() {
		
		return iempleadosDAO.findAll();
	}

	@Override
	public List<Empleado> listarEmpleadoNombre(String nombre) {
		
		return iempleadosDAO.findByNombre(nombre);
	}

	@Override
	public Empleado empleadoXdni(String dni) {
		
		return iempleadosDAO.findById(dni).get();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		
		return iempleadosDAO.save(empleado);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		
		return iempleadosDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(String dni) {
		
		iempleadosDAO.deleteById(dni);
	}
}
