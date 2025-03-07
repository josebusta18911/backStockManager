package ve.com.negocio.empleados;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ve.com.persistencia.entidades.EntityEmpleados;
import ve.com.persistencia.repositorios.RepositoryEmpleados;

public class LogicaEmpleados {
	// Atributos
	@Autowired
	private RepositoryEmpleados iEmpleados;

	// Metodos Publicos
	// consultas
	public List<EntityEmpleados> obtenerEmpleados() {
		// cambiar para total
		List<EntityEmpleados> listaEmpleados = iEmpleados.findAll();
		return listaEmpleados;
	}

	// se obtienen los Empleados por criterios o filtros de busqueda
	public List<EntityEmpleados> obtenerEmpleado(EntityEmpleados Empleado) {
		List<EntityEmpleados> listaEmpleados = iEmpleados.buscarporFiltro(Empleado.getEstatus(), Empleado.getNombre(),
				 Empleado.getId(),Empleado.getApellido(), Empleado.getCedRif(), Empleado.getCargo());
		return listaEmpleados;
	}

	// Persistir
	public boolean guardar(EntityEmpleados Empleado) {
		boolean exitoso = true;
		iEmpleados.save(Empleado);
		return exitoso;
	}

	public void eliminarEmpleado(Integer idEmpleado) {
		iEmpleados.deleteById(idEmpleado);
	}

	// Modificar
	public void actualizar(EntityEmpleados Empleado) {
		iEmpleados.save(Empleado);
	}
}
