package ve.com.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.entidades.EntityClientes;

public interface RepositoryClientes extends JpaRepository<EntityClientes, Integer> {

    @Query("SELECT c "+
            "FROM EntityClientes c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
            "AND (:apellido IS NULL OR c.apellido LIKE %:apellido%)" +
            "AND (:nro_doc IS NULL OR c.nro_doc LIKE %:nro_doc%)" +
            "AND (:nro_telefono IS NULL OR c.nro_telefono LIKE %:nro_telefono%)" +
            "AND (:email IS NULL OR c.email LIKE %:email%)" +
            "AND (:id IS NULL OR c.id =:id) " +
            "AND (:estatus IS NULL OR c.estatus =:estatus)")
    List<EntityClientes> buscarporFiltro(Integer estatus, String nombre,Integer id, String apellido,
    		String nro_doc, String nro_telefono, String email);
}
