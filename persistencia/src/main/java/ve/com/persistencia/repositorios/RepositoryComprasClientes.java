package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityComprasClientes;

public interface RepositoryComprasClientes extends JpaRepository<EntityComprasClientes, String> {

}
