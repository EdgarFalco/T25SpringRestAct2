package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Departamento;
import main.service.DepartamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	
	@Autowired
	DepartamentoServiceImpl departamentoServiceImpl;
	
	@GetMapping("/departamentos")
	public List<Departamento> listarDepartamentos() {
		return departamentoServiceImpl.listarDepartamentos();
	}

	@GetMapping("/departamentos/nombre/{nombre}")
	public List<Departamento> listarDepartamentoNombre(@PathVariable(name = "nombre") String nombre) {
		return departamentoServiceImpl.listarDepartamentoNombre(nombre);
	}

	@PostMapping("/departamentos")
	public Departamento salvarDepartamento(@RequestBody Departamento departamento) {

		return departamentoServiceImpl.guardarDepartamento(departamento);
	}

	@GetMapping("/departamentos/{codigo}")
	public Departamento departamentoXID(@PathVariable(name = "codigo") Integer codigo) {

		Departamento departamento_xid = new Departamento();

		departamento_xid = departamentoServiceImpl.departamentoXID(codigo);

		System.out.println("Departamento x ID: " + departamento_xid);

		return departamento_xid;
	}

	@PutMapping("/departamentos/{codigo}")
	public Departamento actualizarDepartamento(@PathVariable(name = "codigo") Integer codigo, @RequestBody Departamento departamento) {

		Departamento departamento_seleccionado = new Departamento();
		Departamento departamento_actualizado = new Departamento();

		departamento_seleccionado = departamentoServiceImpl.departamentoXID(codigo);

		departamento_seleccionado.setNombre(departamento.getNombre());				

		departamento_actualizado = departamentoServiceImpl.actualizarDepartamento(departamento_seleccionado);

		System.out.println("El departamento actualizado es: " + departamento_actualizado);

		return departamento_actualizado;
	}

	@DeleteMapping("/departamentos/{codigo}")
	public void eliminarDepartamento(@PathVariable(name = "codigo") Integer codigo) {
		departamentoServiceImpl.eliminarDepartamento(codigo);
	}
}
