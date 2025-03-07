package ve.com.negocio.roles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ve.com.negocio.roles.modelo.mLrol;
import ve.com.persistencia.entidades.EntityRoles;
import ve.com.persistencia.repositorios.RepositoryRoles;

@Service
@AllArgsConstructor
public class LogicaRol {
	// Atributos
	@Autowired
	private RepositoryRoles iRol;

	// Metodos Publicos
	// consultas
	public mLrol obtenerRoles() {
		// cambiar para total
		List<EntityRoles> listaRoles = iRol.findAll();
		mLrol modelo = new mLrol();
		modelo.setRoles(listaRoles);
		return modelo;
	}

	// se obtienen los roles por criterios o filtros de busqueda
	public mLrol obtenerRol(EntityRoles rol) {
		mLrol modelo = new mLrol();
		List<EntityRoles> listaRoles = iRol.buscarporFiltro(rol.getEstatus(), rol.getNombre(),
				rol.getId());
		modelo.setRoles(listaRoles);
		return modelo;
	}

	// Persistir
	public boolean guardar(EntityRoles rol) {
		boolean exitoso = true;
		iRol.save(rol);
		return exitoso;
	}

	public void eliminarRol(Integer idRol) {
		iRol.deleteById(idRol);
	}

	// Modificar
	public void actualizar(EntityRoles rol) {
		iRol.save(rol);
	}

}