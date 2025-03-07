package ve.com.negocio.proveedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import ve.com.persistencia.entidades.EntityProveedores;
import ve.com.persistencia.repositorios.RepositoryProveedores;

public class LogicaProveedores {
	// Atributos
		@Autowired
		private RepositoryProveedores iProveedores;

		// Metodos Publicos
		// consultas
		public List<EntityProveedores> obtenerProveedores() {
			// cambiar para total
			List<EntityProveedores> listaProveedores = iProveedores.findAll();
			return listaProveedores;
		}

		// se obtienen los Proveedores por criterios o filtros de busqueda
		public List<EntityProveedores> obtenerProveedor(EntityProveedores Proveedor) {
			List<EntityProveedores> listaProveedores = iProveedores.buscarporFiltro(Proveedor.getEstatus(), Proveedor.getEmpresa(),
					Proveedor.getId());
			return listaProveedores;
		}

		// Persistir
		public boolean guardar(EntityProveedores Proveedor) {
			boolean exitoso = true;
			iProveedores.save(Proveedor);
			return exitoso;
		}

		public void eliminarProveedor(Integer idProveedor) {
			iProveedores.deleteById(idProveedor);
		}

		// Modificar
		public void actualizar(EntityProveedores Proveedor) {
			iProveedores.save(Proveedor);
		}
}
