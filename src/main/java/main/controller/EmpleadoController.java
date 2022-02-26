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

import main.dto.Empleado;
import main.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {	
		
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
		
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}

	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name = "nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}

	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {

		return empleadoServiceImpl.guardarEmpleado(empleado);
	}

	@GetMapping("/empleados/{dni}")
	public Empleado empleadoXDni(@PathVariable(name = "dni") String dni) {

		Empleado empleado_xid = new Empleado();

		empleado_xid = empleadoServiceImpl.empleadoXdni(dni);

		System.out.println("Empleado x DNI: " + empleado_xid);

		return empleado_xid;
	}

	@PutMapping("/empleados/{dni}")
	public Empleado actualizarEmpleado(@PathVariable(name = "dni") String dni, @RequestBody Empleado empleado) {

		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();

		empleado_seleccionado = empleadoServiceImpl.empleadoXdni(dni);

		empleado_seleccionado.setNombre(empleado.getNombre());				

		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);

		System.out.println("El empleado actualizado es: " + empleado_actualizado);

		return empleado_actualizado;
	}

	@DeleteMapping("/empleados/{dni}")
	public void eliminarEmpleado(@PathVariable(name = "dni") String dni) {
		empleadoServiceImpl.eliminarEmpleado(dni);
	}
	
}
