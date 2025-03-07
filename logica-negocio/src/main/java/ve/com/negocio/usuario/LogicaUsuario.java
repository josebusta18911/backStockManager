package ve.com.negocio.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import ve.com.negocio.usuario.modelo.ModeloLlogin;
import ve.com.negocio.usuario.modelo.mLusuario;
import ve.com.persistencia.DTO.modeloRespuestausuario;
import ve.com.persistencia.entidades.EntityUsuarios;
import ve.com.persistencia.repositorios.RepositoryRoles;
import ve.com.persistencia.repositorios.RepositoryUsuarios;

/**
 * 
 * Logica encargada de hacer el conjunto de operaciones asociadas a los usuarios
 * 
 * @author jose bustamante
 *
 */
@Slf4j
@Service
public class LogicaUsuario {

	// Atributos
	@Autowired
	RepositoryUsuarios iUsuario;
	@Autowired
	RepositoryRoles iRol;

	// Constructor
	public LogicaUsuario(RepositoryUsuarios iUsuario, RepositoryRoles iRol) {
		this.iUsuario = iUsuario;
		this.iRol = iRol;
	}

	// Metodos Publicos
	public EntityUsuarios recuperarUsuarioAuth(String usuario) throws Exception {
		log.debug("Recuperando datos de autenticacion del usuario " + usuario);

		// validamos que se recibio un usuario
		if (usuario == null || usuario.equals("")) {
			throw new Exception("usuario en formato incorrecto");
		}

		// recuperamos los datos del usuario
		EntityUsuarios mUsuario;
		try {
			mUsuario = this.iUsuario.findbynombre(usuario);
		} catch (Exception e) {
			log.error("Error recuperando los datos del usuario, error ", e);
			throw new Exception("Error recuperando los datos del usuario", e);
		}
		if (mUsuario == null) {
			throw new Exception("Usuario no recuperado");
		}

		// traducimos los datos segun lo require la autenticacion
		EntityUsuarios auth = new EntityUsuarios();
		auth.setId(mUsuario.getId());
		auth.setUsuario(mUsuario.getUsuario());
		auth.setPassword(mUsuario.getPassword());
		auth.setIdRol(mUsuario.getIdRol());

		return auth;
	}

	public void guardar(EntityUsuarios usuario) {
		iUsuario.save(usuario);

	}

	public void actualizar(EntityUsuarios usuario) {
		EntityUsuarios modelo = new EntityUsuarios();

		try {
			modelo = iUsuario.findById(usuario.getId()).orElseThrow(() -> new Exception("Nota no encontrada"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usuario.getUsuario() != "") {
			modelo.setUsuario(usuario.getUsuario());
		}
		if (usuario.getIdRol() != null) {
			modelo.setIdRol(Integer.valueOf(usuario.getIdRol()));
		}
		if (usuario.getIdEmpleado() != null) {
			modelo.setIdEmpleado(Integer.valueOf(usuario.getIdEmpleado()));
		}
		if (usuario.getId() != null) {
			modelo.setId(Integer.valueOf(usuario.getId()));
		}
		if (usuario.getEstatus() != null) {
			modelo.setEstatus(Integer.valueOf(usuario.getEstatus()));
		}
		if (usuario.getPassword() != "") {
			modelo.setPassword(usuario.getPassword());
		}
		modelo.setId(usuario.getId());
		iUsuario.save(modelo);

	}

	public void eliminar(Integer usuario) {
		iUsuario.deleteById(usuario);
	}

	public mLusuario obtenerUsuario(EntityUsuarios usuario) {
		mLusuario modelo = new mLusuario();
		List<EntityUsuarios> listausuario = iUsuario.buscarporFiltro(usuario.getUsuario(), usuario.getPassword(),
				usuario.getFechaCreacion(), usuario.getEstatus(), usuario.getIdEmpleado());
		modelo.setUsuarios(listausuario);
		System.out.println("respuesta::" + listausuario);
		return modelo;
	}

	public ModeloLlogin login(String user, String passwd) {

		ModeloLlogin modelo = new ModeloLlogin();
		EntityUsuarios usuario = new EntityUsuarios();
		usuario.setUsuario(user);
		usuario.setPassword(passwd);
		try {
			// ve.com.persistencia.DTO.modeloRespuestausuario respuesta =
			// (modeloRespuestausuario)
			// iUsuario.buscarporFiltroRol(usuario.getUsuario(),usuario.getPassword(),
			// usuario.getFechaCreacion(),usuario.getEstatus(),usuario.getIdEmpleado());
			modeloRespuestausuario respuesta = iUsuario.login(user, passwd);
			modelo.setAcceso(true);
			modelo.setRol(respuesta.getNombre());
			modelo.setUsuario(usuario.getUsuario());
			modelo.setIdEmpleado(respuesta.getIdEmpleado());

		} catch (Exception e) {
			modelo.setAcceso(false);
			modelo.setRol("u");
			e.toString();
		}
		;
		return modelo;
	}

}
