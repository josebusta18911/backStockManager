package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityUsuarios;

public interface RepositoryUsuarios extends JpaRepository<EntityUsuarios, String> {

}
