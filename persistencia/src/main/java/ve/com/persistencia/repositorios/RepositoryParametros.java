package ve.com.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ve.com.persistencia.entidades.EntityParametros;

/**
 * 
 * repositorio de consultas para tabla parametros
 * 
 * @author Jose Bustamante
 *
 */

public interface RepositoryParametros extends JpaRepository<EntityParametros, String> {

	// Usando la convención de nombres de Spring Data JPA
	List<EntityParametros> findByPargrpId(String pargrpId);

	//usando una consulta personalizada
//    @Query("SELECT p FROM INFI_TB_002_PARAM_TIPOS p WHERE p.grupo.id = :pargrpId")
//    List<EntityParametros> findParametrosByPargrpId(@Param("pargrpId") Long pargrpId);
}
