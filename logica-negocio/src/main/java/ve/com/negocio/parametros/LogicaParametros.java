package ve.com.negocio.parametros;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ve.com.persistencia.entidades.EntityParametros;
import ve.com.persistencia.repositorios.RepositoryParametros;

/**
 * 
 * Implementacion de logica de negocio para interacccion con parametros
 * 
 * @author Jose Bustamante
 *
 */

@Service
@AllArgsConstructor
public class LogicaParametros {

	@Autowired
	private RepositoryParametros parametros;

	public List<EntityParametros> obtenerTodos() {
		return parametros.findAll();
	}

	public Optional<EntityParametros> obtenerParametrosPorId(Integer id) {
		return parametros.findById(id); 
	}

	public EntityParametros guardar(EntityParametros usuario) {
		return parametros.save(usuario);
	}

//	    public void eliminar(Long id) {
//	    	parametros.deleteById(id);
//	    }
}
