package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.entidades.EntityRoles;

import java.util.List;

public interface RepositoryRoles extends JpaRepository<EntityRoles, Integer> {

    @Query("SELECT c "+
            "FROM EntityRoles c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
            "AND (:id IS NULL OR c.id =:id) " +
            "AND (:estatus IS NULL OR c.estatus =:estatus)")
    List<EntityRoles> buscarporFiltro(Integer estatus, String nombre, Integer id);
}
