package ve.com.servicio.rest.controlador.clientes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;

import ve.com.negocio.clientes.LogicaClientes;
import ve.com.persistencia.entidades.EntityClientes;
import ve.com.servicio.rest.DTO.request.clientes.ModeloReqClientes;
import ve.com.servicio.rest.DTO.response.clientes.Clientes;
import ve.com.servicio.rest.DTO.response.clientes.ModeloRespClientes;
import ve.com.servicio.rest.utils.EnumRespuesta;

public class ControladorClientes {

	// Atributos
	@Autowired
	private LogicaClientes lCliente;

	// Metodos publicos
	@PostMapping("registrar")
	public Clientes registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqClientes request)
			throws Exception {
		// Creamos Proveedor
		EntityClientes Proveedor = new EntityClientes();
		Proveedor.setEstatus(Integer.valueOf(request.getEstatus()));
		Proveedor.setNombre(request.getNombre());
		Clientes resp = new Clientes();
		try {
			// Almacenamos la informacion
			boolean exitoso = false;
			exitoso = lCliente.guardar(Proveedor);
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
	public Clientes consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqClientes request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Clientes resp = new Clientes();
		EntityClientes consulta = new EntityClientes();
		try {

			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}

			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			List<EntityClientes> listaClientes = lCliente.obtenerCliente(consulta);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloRespClientes> Clientes = listaClientes.stream()
					.map(r -> new ModeloRespClientes(r.getId(), r.getNombre(), r.getApellido(), r.getTipoDoc(),
							r.getNroDoc(), r.getNroTelefono(), r.getEmail(), r.getEstatus()))
					.collect(Collectors.toList());
			resp.setClientes(Clientes);
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
	public Clientes actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqClientes request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion

		Clientes resp = new Clientes();
		EntityClientes consulta = new EntityClientes();
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

			lCliente.actualizar(consulta);
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
	public Clientes eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqClientes request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Clientes resp = new Clientes();
		try {

			lCliente.eliminarCliente(Integer.valueOf(request.getId()));
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
