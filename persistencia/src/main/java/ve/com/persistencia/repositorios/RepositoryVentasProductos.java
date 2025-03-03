package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityVentasProductos;

public interface RepositoryVentasProductos extends JpaRepository<EntityVentasProductos, String> {

}
