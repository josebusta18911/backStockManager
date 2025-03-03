package ve.com.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ve.com.persistencia.entidades.EntityEmpleados;

public interface RepositoryEmpleados extends JpaRepository<EntityEmpleados, String> {

}
