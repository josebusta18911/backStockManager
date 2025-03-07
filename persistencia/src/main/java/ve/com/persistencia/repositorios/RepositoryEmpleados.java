package ve.com.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.entidades.EntityEmpleados;

public interface RepositoryEmpleados extends JpaRepository<EntityEmpleados, Integer> {

    @Query("SELECT c "+
            "FROM EntityEmpleados c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
            "AND (:apellido IS NULL OR c.apellido LIKE %:apellido%) " +
            "AND (:cedRif IS NULL OR c.cedRif LIKE %:cedRif%) " +
            "AND (:cargo IS NULL OR c.cargo LIKE %:cargo%) " +
            "AND (:id IS NULL OR c.id =:id) " +
            "AND (:estatus IS NULL OR c.estatus =:estatus)")
    List<EntityEmpleados> buscarporFiltro(Integer estatus, String nombre,Integer id, String apellido, 
    									String cedRif, String cargo);
}
