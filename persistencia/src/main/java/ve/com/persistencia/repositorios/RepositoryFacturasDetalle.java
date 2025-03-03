package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityFacturasDetalle;

public interface RepositoryFacturasDetalle extends JpaRepository<EntityFacturasDetalle, String> {

}
