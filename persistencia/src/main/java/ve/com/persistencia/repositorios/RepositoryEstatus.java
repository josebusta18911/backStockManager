package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityEstatus;

public interface RepositoryEstatus extends JpaRepository<EntityEstatus, String> {

}
