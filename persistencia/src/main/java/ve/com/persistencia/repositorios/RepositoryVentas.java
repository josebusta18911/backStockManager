package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityVentas;

public interface RepositoryVentas extends JpaRepository<EntityVentas, String> {

}
