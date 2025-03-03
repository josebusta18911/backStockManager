package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityClientes;

public interface RepositoryClientes extends JpaRepository<EntityClientes, String> {

}
