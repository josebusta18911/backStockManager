package ve.com.servicio.rest.controlador.empleados;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;
import ve.com.negocio.empleados.LogicaEmpleados;
import ve.com.persistencia.entidades.EntityEmpleados;
import ve.com.servicio.rest.DTO.request.empleados.ModeloReqEmpleados;
import ve.com.servicio.rest.DTO.response.empleados.Empleados;
import ve.com.servicio.rest.DTO.response.empleados.ModeloRespEmpleados;
import ve.com.servicio.rest.utils.EnumRespuesta;

public class ControladorEmpleados {

	// Atributos
	@Autowired
	private LogicaEmpleados lEmpleado;

	// Metodos publicos
	@PostMapping("registrar")
	public Empleados registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqEmpleados request)
			throws Exception {
		// Creamos Proveedor
		EntityEmpleados Proveedor = new EntityEmpleados();
		Proveedor.setEstatus(Integer.valueOf(request.getEstatus()));
		Proveedor.setNombre(request.getNombre());
		Empleados resp = new Empleados();
		try {
			// Almacenamos la informacion
			boolean exitoso = false;
			exitoso = lEmpleado.guardar(Proveedor);
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
	public Empleados consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqEmpleados request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Empleados resp = new Empleados();
		EntityEmpleados consulta = new EntityEmpleados();
		try {

			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}

			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			List<EntityEmpleados> listaEmpleados = lEmpleado.obtenerEmpleado(consulta);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloRespEmpleados> Empleados = listaEmpleados.stream()
					.map(r -> new ModeloRespEmpleados(r.getId(), r.getNombre(), r.getApellido(),r.getCedRif(),
						r.getFechaNac(),r.getDireccion(),r.getNroTelefono(),r.getEmail(),r.getCargo(),r.getFechaIngreso(),
					    r.getSalario(),r.getEstatus()))
					.collect(Collectors.toList());
			resp.setEmpleados(Empleados);
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
	public Empleados actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqEmpleados request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion

		Empleados resp = new Empleados();
		EntityEmpleados consulta = new EntityEmpleados();
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

			lEmpleado.actualizar(consulta);
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
	public Empleados eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqEmpleados request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Empleados resp = new Empleados();
		try {

			lEmpleado.eliminarEmpleado(Integer.valueOf(request.getId()));
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
