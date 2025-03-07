package ve.com.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.entidades.EntityProveedores;

public interface RepositoryProveedores extends JpaRepository<EntityProveedores, Integer> {

    @Query("SELECT c "+
            "FROM EntityProveedores c " +
            "WHERE (:empresa IS NULL OR c.empresa LIKE %:empresa%) " +
            "AND (:id IS NULL OR c.id =:id) " +
            "AND (:estatus IS NULL OR c.estatus =:estatus)")
    List<EntityProveedores> buscarporFiltro(Integer estatus, String empresa, Integer id);
}
