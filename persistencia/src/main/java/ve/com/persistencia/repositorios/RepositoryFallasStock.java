package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityFallasStock;

public interface RepositoryFallasStock extends JpaRepository<EntityFallasStock, String> {

}
