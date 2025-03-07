package ve.com.servicio.rest.controlador.usuarios;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import ve.com.negocio.usuario.LogicaUsuario;
import ve.com.negocio.usuario.modelo.mLusuario;
import ve.com.persistencia.entidades.EntityUsuarios;
import ve.com.servicio.rest.DTO.request.usuario.ModeloReqUsuario;
import ve.com.servicio.rest.DTO.response.usuarios.ModeloUsuario;
import ve.com.servicio.rest.DTO.response.usuarios.Usuarios;
import ve.com.servicio.rest.utils.EnumRespuesta;
import ve.com.servicio.rest.utils.FormatearFecha;

@RestController
@RequestMapping("/api/bm/usuarios/")
@CrossOrigin
public class ControladorUsuario {

	@Autowired
	private LogicaUsuario lUs;

	// Metodos publicos
	@PostMapping("registrar")
	public Usuarios registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqUsuario request)
			throws Exception {

		Usuarios resp = new Usuarios();
		EntityUsuarios user = new EntityUsuarios();
		String fecha = FormatearFecha.getFormattedFecha(new Date());
		user.setEstatus(Integer.valueOf(request.getEstatus()));
		System.out.println("fecha:" + fecha);
		user.setFechaCreacion(fecha);
		System.out.println("fecha2: " + user.getFechaCreacion());
		user.setIdEmpleado(Integer.valueOf(request.getIdEmpleado()));
		user.setIdRol(Integer.valueOf(request.getIdRol()));
		user.setPassword(request.getPassword());
		user.setUsuario(request.getUsuario());

		try {
			// Almacenamos la informacion

			lUs.guardar(user);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

		} catch (Exception e) {
			resp.setCodigo(EnumRespuesta.EstatusDataInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.EstatusDataInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());
		}
		return resp;
	}

	@PostMapping("buscar")
	public Usuarios consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqUsuario request)
			throws HttpClientErrorException, Exception {
		// Procesamos la peticion
		Usuarios resp = new Usuarios();
		EntityUsuarios consulta = new EntityUsuarios();
		mLusuario modelo = new mLusuario();
		try {

			if (request.getUsuario() != "") {
				consulta.setUsuario(request.getUsuario());
			}
			if (request.getPassword() != "") {
				consulta.setPassword(request.getPassword());
			}
			if (request.getIdRol() != null) {
				consulta.setIdRol(Integer.valueOf(request.getIdRol()));
			}
			if (request.getUsuario() != "") {
				consulta.setUsuario(request.getUsuario());
			}
			if (request.getIdRol() != null) {
				consulta.setIdRol(Integer.valueOf(request.getIdRol()));
			}
			if (request.getIdEmpleado() != null) {
				consulta.setIdEmpleado(Integer.valueOf(request.getIdEmpleado()));
			}
			if (request.getId() != null) {
				consulta.setId(Integer.valueOf(request.getId()));
			}
			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}

			modelo = lUs.obtenerUsuario(consulta);

			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloUsuario> usuarios = modelo.getUsuarios().stream()
					.map(u -> new ModeloUsuario(u.getId(), u.getUsuario(), u.getPassword(),u.getIdEmpleado(), 
							 u.getIdRol(),u.getFechaCreacion(), u.getFechaActualizacion(),
							u.getEstatus()))
					.collect(Collectors.toList());
			resp.setUsuarios(usuarios);
			// }

		} catch (Exception e) {
			resp.setCodigo(EnumRespuesta.EstatusDataInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.EstatusDataInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());

		}
		// entregamos la respuesta
		return resp;

	}

	@PostMapping("eliminar")
	public Usuarios eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqUsuario request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Usuarios resp = new Usuarios();

		try {

			lUs.eliminar(Integer.valueOf(request.getId()));
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());
		} catch (Exception e) {
			resp.setCodigo(EnumRespuesta.EstatusDataInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.EstatusDataInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());

		}
		// entregamos la respuesta
		return resp;
	}

	@PostMapping("actualizar")
	public Usuarios actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqUsuario request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Usuarios resp = new Usuarios();
		EntityUsuarios consulta = new EntityUsuarios();
		try {
			if (request.getUsuario() != "") {
				consulta.setUsuario(request.getUsuario());
			}
			if (request.getIdRol() != null) {
				consulta.setIdRol(Integer.valueOf(request.getIdRol()));
			}
			if (request.getIdEmpleado() != null) {
				consulta.setIdEmpleado(Integer.valueOf(request.getIdEmpleado()));
			}
			if (request.getId() != null) {
				consulta.setId(Integer.valueOf(request.getId()));
			}
			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			if (request.getPassword() != "") {
				consulta.setPassword(request.getPassword());
			}

			lUs.actualizar(consulta);

			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());
		} catch (Exception e) {
			resp.setCodigo(EnumRespuesta.EstatusDataInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.EstatusDataInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());

		}
		// entregamos la respuesta
		return resp;
	}
}
