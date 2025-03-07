package ve.com.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.entidades.EntityProductos;

public interface RepositoryProductos extends JpaRepository<EntityProductos, Integer> {

    @Query("SELECT c "+
            "FROM EntityProductos c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
            "AND (:marca IS NULL OR c.marca LIKE %:marca%) " +
            "AND (:codigo IS NULL OR c.codigo LIKE %:codigo%) " +
            "AND (:utilidadPorcentaje IS NULL OR c.utilidadPorcentaje LIKE %:utilidadPorcentaje%) " +
            "AND (:id IS NULL OR c.id =:id) " +
            "AND (:idCategoria IS NULL OR c.idCategoria =:idCategoria) " +
            "AND (:idProveedor IS NULL OR c.idProveedor =:idProveedor) " +
            "AND (:estatus IS NULL OR c.estatus =:estatus)")
    List<EntityProductos> buscarporFiltro(Integer estatus, String nombre,String marca, Integer id,
    										Integer idCategoria, String utilidadPorcentaje, Integer idProveedor,String codigo);
}
