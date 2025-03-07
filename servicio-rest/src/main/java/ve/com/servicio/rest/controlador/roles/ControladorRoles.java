package ve.com.servicio.rest.controlador.roles;

import java.util.ArrayList;
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

import ve.com.negocio.roles.LogicaRol;
import ve.com.negocio.roles.modelo.mLrol;
import ve.com.persistencia.entidades.EntityRoles;
import ve.com.servicio.rest.DTO.request.rol.ModeloReqRol;
import ve.com.servicio.rest.DTO.response.roles.ModeloRol;
import ve.com.servicio.rest.DTO.response.roles.Roles;
import ve.com.servicio.rest.utils.EnumRespuesta;

@RestController	
@RequestMapping("/api/bm/roles/")
@CrossOrigin
public class ControladorRoles {

	// Atributos
	@Autowired
	private LogicaRol lRol;

	// Metodos publicos
	@PostMapping("registrar")
	public Roles registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqRol request)
			throws Exception {
		// Creamos Rol
		EntityRoles rol = new EntityRoles();
		// rol.setCodigo(request.getCodigo());
		rol.setEstatus(Integer.valueOf(request.getEstatus()));
		rol.setNombre(request.getNombre());
		Roles resp = new Roles();
		try {

			// Almacenamos la informacion
			boolean exitoso = false;
			exitoso = lRol.guardar(rol);
			// Procesamos los resultados
			if (exitoso) {
				resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
				resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
				resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());
			}

		} catch (Exception e) {
			resp.setCodigo(EnumRespuesta.EstatusDataInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.EstatusDataInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());
		}
		return resp;
	}

	@PostMapping("buscar")
	public Roles consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqRol request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Roles resp = new Roles();
		EntityRoles consulta = new EntityRoles();
		mLrol modelo = new mLrol();
		try {

			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}

			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			modelo = lRol.obtenerRol(consulta);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloRol> roles = modelo.getRoles().stream()
					.map(r -> new ModeloRol(r.getId(), r.getNombre(),r.getEstatus(),r.getDescripcion()))
					.collect(Collectors.toList());
			resp.setRoles(roles);
			// }

		} catch (Exception e) {
			resp.setCodigo(EnumRespuesta.EstatusDataInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.EstatusDataInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());

		}
		// entregamos la respuesta
		return resp;

	}

	@PostMapping("actualizar")
	public Roles actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqRol request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion

		Roles resp = new Roles();
		EntityRoles consulta = new EntityRoles();
		try {
			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}
			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			if (request.getId() != null) {
				consulta.setId(Integer.valueOf(request.getId()));
			}

			lRol.actualizar(consulta);
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

	@PostMapping("eliminar")
	public Roles eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqRol request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Roles resp = new Roles();
		try {

			lRol.eliminarRol(Integer.valueOf(request.getId()));
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