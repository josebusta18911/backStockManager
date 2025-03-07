package ve.com.negocio.clientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ve.com.persistencia.entidades.EntityClientes;
import ve.com.persistencia.repositorios.RepositoryClientes;

public class LogicaClientes {
	// Atributos
	@Autowired
	private RepositoryClientes iClientes;

	// Metodos Publicos
	// consultas
	public List<EntityClientes> obtenerClientes() {
		// cambiar para total
		List<EntityClientes> listaClientes = iClientes.findAll();
		return listaClientes;
	}

	// se obtienen los Clientes por criterios o filtros de busqueda
	public List<EntityClientes> obtenerCliente(EntityClientes Cliente) {
		List<EntityClientes> listaClientes = iClientes.buscarporFiltro(Cliente.getEstatus(), Cliente.getNombre(),
				Cliente.getId(), Cliente.getApellido(), Cliente.getNroDoc(), Cliente.getNroTelefono(), Cliente.getEmail());
		return listaClientes;
	}

	// Persistir
	public boolean guardar(EntityClientes Cliente) {
		boolean exitoso = true;
		iClientes.save(Cliente);
		return exitoso;
	}

	public void eliminarCliente(Integer idCliente) {
		iClientes.deleteById(idCliente);
	}

	// Modificar
	public void actualizar(EntityClientes Cliente) {
		iClientes.save(Cliente);
	}
}
