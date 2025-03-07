package ve.com.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ve.com.persistencia.DTO.modeloRespuestausuario;
import ve.com.persistencia.entidades.EntityUsuarios;

public interface RepositoryUsuarios extends JpaRepository<EntityUsuarios, Integer> {

    @Query("SELECT c " +
            "FROM EntityUsuarios c " +
            "WHERE (:usuario IS NULL OR c.usuario LIKE %:usuario%) ")
    EntityUsuarios findbynombre(String usuario);
    
    @Query("SELECT new ve.com.persistencia.DTO.modeloRespuestausuario(c.id,c.usuario,c.password,c.fechaCreacion,c.estatus,c.idEmpleado,c.idRol,e.nombre) " +
            "FROM EntityUsuarios c " +
            "JOIN c.rol e " +
            "WHERE (:usuario IS NULL OR c.usuario LIKE %:usuario%) "+
            "AND (:password IS NULL OR c.password LIKE %:password%) " )
    modeloRespuestausuario login(String usuario, String password);
    
    @Query("SELECT new ve.com.persistencia.DTO.modeloRespuestausuario(c.id,c.usuario,c.password,c.fechaCreacion,c.estatus,c.idEmpleado,c.idRol,e.nombre) " +
            "FROM EntityUsuarios c " +
            "JOIN c.rol e " +
            "WHERE (:usuario IS NULL OR c.usuario LIKE %:usuario%) " +
            "AND (:password IS NULL OR c.password LIKE %:password%) " +
            "AND (:fechaCreacion IS NULL OR c.fechaCreacion LIKE %:fechaCreacion%)"+
            "AND (:estatus IS NULL OR c.estatus = :estatus)"+
            "AND (:idEmpleado IS NULL OR c.idEmpleado LIKE %:idEmpleado%)")
    List<modeloRespuestausuario> buscarporFiltroRol(String usuario,String password,String fechaCreacion, Integer estatus, Integer idEmpleado);
    
    @Query("SELECT c " +
            "FROM EntityUsuarios c " +
            "JOIN c.rol e " +
            "WHERE (:usuario IS NULL OR c.usuario LIKE %:usuario%) " +
            "AND (:password IS NULL OR c.password LIKE %:password%) " +
            "AND (:fechaCreacion IS NULL OR c.fechaCreacion LIKE %:fechaCreacion%)"+
            "AND (:estatus IS NULL OR c.estatus = :estatus)"+
            "AND (:idEmpleado IS NULL OR c.idEmpleado  =:idEmpleado)")
    List<EntityUsuarios> buscarporFiltro(String usuario,String password,String fechaCreacion, Integer estatus, Integer idEmpleado);
}
