package ve.com.negocio.categorias;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ve.com.persistencia.entidades.EntityCategorias;
import ve.com.persistencia.repositorios.RepositoryCategorias;

public class LogicaCategorias {
	// Atributos
	@Autowired
	private RepositoryCategorias iCategorias;

	// Metodos Publicos
	// consultas
	public List<EntityCategorias> obtenerCategorias() {
		// cambiar para total
		List<EntityCategorias> listaCategorias = iCategorias.findAll();
		return listaCategorias;
	}

	// se obtienen los Categorias por criterios o filtros de busqueda
	public List<EntityCategorias> obtenerCategoria(EntityCategorias Categoria) {
		List<EntityCategorias> listaCategorias = iCategorias.buscarporFiltro(Categoria.getEstatus(), Categoria.getNombre(),Categoria.getId());
		return listaCategorias;
	}

	// Persistir
	public boolean guardar(EntityCategorias Categoria) {
		boolean exitoso = true;
		iCategorias.save(Categoria);
		return exitoso;
	}

	public void eliminar(Integer idCategoria) {
		iCategorias.deleteById(idCategoria);
	}

	// Modificar
	public void actualizar(EntityCategorias Categoria) {
		iCategorias.save(Categoria);
	}
}
