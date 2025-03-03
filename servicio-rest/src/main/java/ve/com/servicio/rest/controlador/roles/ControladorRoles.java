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
			throws ExcepcionLogicaRol {
		// Creamos Rol
		EntityRoles rol = new EntityRoles();
		// rol.setCodigo(request.getCodigo());
		rol.setEstatus(Integer.valueOf(request.getEstatus()));
		rol.setNombre(request.getNombre());
		rol.setTipo(Integer.valueOf(request.getTipo()));
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
			throws HttpClientErrorException, ExcepcionLogicaRol {

		// Procesamos la peticion
		Roles resp = new Roles();
		EntityRoles consulta = new EntityRoles();
		mLrol modelo = new mLrol();
		try {

			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}
			if (request.getTipo() != "") {
				consulta.setTipo(Integer.valueOf(request.getTipo()));
			}
			if (request.getEstatus() != "") {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			modelo = lRol.obtenerRol(consulta);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloRol> roles = modelo.getRoles().stream()
					.map(r -> new ModeloRol(r.getCodigo(), r.getNombre(), r.getTipo(), r.getEstatus()))
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
			throws HttpClientErrorException, ExcepcionLogicaRol {

		// Procesamos la peticion

		Roles resp = new Roles();
		EntityRoles consulta = new EntityRoles();
		try {
			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}
			if (request.getTipo() != "") {
				consulta.setTipo(Integer.valueOf(request.getTipo()));
			}
			if (request.getEstatus() != "") {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			if (request.getCodigo() != "") {
				consulta.setCodigo(Integer.valueOf(request.getCodigo()));
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
			throws HttpClientErrorException, ExcepcionLogicaRol {

		// Procesamos la peticion
		Roles resp = new Roles();
		try {

			lRol.eliminarRol(Integer.valueOf(request.getCodigo()));
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