package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityCategorias;

public interface RepositoryCategorias extends JpaRepository<EntityCategorias, String> {

}
