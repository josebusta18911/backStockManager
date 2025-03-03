package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityProductos;

public interface RepositoryProductos extends JpaRepository<EntityProductos, String> {

}
