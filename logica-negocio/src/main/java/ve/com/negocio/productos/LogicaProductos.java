package ve.com.negocio.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ve.com.persistencia.entidades.EntityProductos;
import ve.com.persistencia.repositorios.RepositoryProductos;

public class LogicaProductos {
	// Atributos
	@Autowired
	private RepositoryProductos iProductos;

	// Metodos Publicos
	// consultas
	public List<EntityProductos> obtenerProductos() {
		// cambiar para total
		List<EntityProductos> listaProductos = iProductos.findAll();
		return listaProductos;
	}

	// se obtienen los Productos por criterios o filtros de busqueda
	public List<EntityProductos> obtenerProducto(EntityProductos Producto) {
		List<EntityProductos> listaProductos = iProductos.buscarporFiltro(Producto.getEstatus(), Producto.getNombre(),
				Producto.getMarca(), Producto.getId(), Producto.getIdCategoria(), Producto.getUtilidadPorcentaje(),
				Producto.getIdProveedor(), Producto.getCodigo());
		return listaProductos;
	}

	// Persistir
	public boolean guardar(EntityProductos Producto) {
		boolean exitoso = true;
		iProductos.save(Producto);
		return exitoso;
	}

	public void eliminarProducto(Integer idProducto) {
		iProductos.deleteById(idProducto);
	}

	// Modificar
	public void actualizar(EntityProductos Producto) {
		iProductos.save(Producto);
	}
}
