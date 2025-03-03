package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityProveedores;

public interface RepositoryProveedores extends JpaRepository<EntityProveedores, String> {

}
