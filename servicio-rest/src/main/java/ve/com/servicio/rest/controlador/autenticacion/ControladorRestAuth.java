package ve.com.servicio.rest.controlador.autenticacion;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ve.com.negocio.usuario.LogicaUsuario;
import ve.com.negocio.usuario.modelo.ModeloLlogin;
import ve.com.servicio.rest.DTO.request.autenticacion.ModeloReqLogin;
import ve.com.servicio.rest.DTO.response.ModeloRespBase;
import ve.com.servicio.rest.DTO.response.autenticacion.ModeloRespLogin;
import ve.com.servicio.rest.utils.EnumRespuesta;

/**
 * 
 * Controlador que contiene las operaciones de consulta de esta tus
 *
 * @author Jose Bustamante
 *
 */
@RestController
@RequestMapping("/api/bm/auth")
@CrossOrigin
public class ControladorRestAuth {
	// Atributos
	@Autowired
	private LogicaUsuario lUser;

	// Metodos Publicos Web
	@PostMapping("/login")
	public ModeloRespBase login(@RequestHeader Map<String, String> headers,@RequestBody ModeloReqLogin request) {

		ModeloLlogin consulta = lUser.login(request.getUsuario(), request.getPassword());
		// Procesamos la peticion 
		ModeloRespLogin respuesta = new ModeloRespLogin();
		if ( consulta.isAcceso() ) {
			respuesta.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			respuesta.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			respuesta.setMensajeSistema("Usuario valido para acceso al sistema");
			respuesta.setRol(consulta.getRol());
			respuesta.setAcceso(consulta.isAcceso());
			respuesta.setUsuario(consulta.getUsuario());
			respuesta.setIdEmpleado(consulta.getIdEmpleado());
		} else {
			respuesta.setCodigo("05");
			respuesta.setMensajeCliente("Usuario no autenticado por login invalido ");
			if (consulta.getRol().equals("u")) {
				respuesta.setMensajeSistema("El nombre de usuario no se encuentra registrado");
			} else if (consulta.getRol().equals("p")) {
				respuesta.setMensajeSistema("La contraseña utilizada es invalida, verifiquela e intente nuevamente");
			}
			respuesta.setAcceso(consulta.isAcceso());
		}
		// entregamos la respuesta
		return respuesta;

	}
}
