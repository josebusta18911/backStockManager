package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityComprasProducto;

public interface RepositoryComprasProductos extends JpaRepository<EntityComprasProducto, String> {

}
