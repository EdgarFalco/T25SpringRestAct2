package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IDepartamentoDAO;
import main.dto.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

	@Autowired
	IDepartamentoDAO idepartamentoDAO;
	
	@Override
	public List<Departamento> listarDepartamentos() {
		
		return idepartamentoDAO.findAll();
	}

	@Override
	public List<Departamento> listarDepartamentoNombre(String nombre) {
		
		return idepartamentoDAO.findByNombre(nombre);
	}

	@Override
	public Departamento departamentoXID(Integer codigo) {
		
		return idepartamentoDAO.findById(codigo).get();
	}

	@Override
	public Departamento guardarDepartamento(Departamento empleado) {
		
		return idepartamentoDAO.save(empleado);
	}

	@Override
	public Departamento actualizarDepartamento(Departamento empleado) {
		
		return idepartamentoDAO.save(empleado);
	}

	@Override
	public void eliminarDepartamento(Integer codigo) {
		
		idepartamentoDAO.deleteById(codigo);		
	}
}
