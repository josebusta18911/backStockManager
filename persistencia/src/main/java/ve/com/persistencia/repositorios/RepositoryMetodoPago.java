package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityMetodoPago;

public interface RepositoryMetodoPago extends JpaRepository<EntityMetodoPago, String> {

}
