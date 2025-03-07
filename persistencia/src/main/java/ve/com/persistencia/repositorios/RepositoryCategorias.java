package ve.com.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.entidades.EntityCategorias;

public interface RepositoryCategorias extends JpaRepository<EntityCategorias, Integer> {

    @Query("SELECT c "+
            "FROM EntityCategorias c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
            "AND (:id IS NULL OR c.id =:id) " +
            "AND (:estatus IS NULL OR c.estatus =:estatus)")
    List<EntityCategorias> buscarporFiltro(Integer estatus, String nombre,Integer id);
}
