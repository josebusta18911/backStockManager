package ve.com.servicio.rest.controlador.proveedores;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;

import ve.com.negocio.proveedores.LogicaProveedores;
import ve.com.persistencia.entidades.EntityProveedores;
import ve.com.servicio.rest.DTO.request.proveedores.ModeloReqProveedores;
import ve.com.servicio.rest.DTO.response.proveedores.ModeloProveedores;
import ve.com.servicio.rest.DTO.response.proveedores.Proveedores;
import ve.com.servicio.rest.utils.EnumRespuesta;

public class ControladorProveedores {

	// Atributos
	@Autowired
	private LogicaProveedores lProveedor;

	// Metodos publicos
	@PostMapping("registrar")
	public Proveedores registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProveedores request)
			throws Exception {
		// Creamos Proveedor
		EntityProveedores Proveedor = new EntityProveedores();
		Proveedor.setEstatus(Integer.valueOf(request.getEstatus()));
		Proveedor.setEmpresa(request.getEmpresa());
		Proveedores resp = new Proveedores();
		try {
			// Almacenamos la informacion
			boolean exitoso = false;
			exitoso = lProveedor.guardar(Proveedor);
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
	public Proveedores consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProveedores request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Proveedores resp = new Proveedores();
		EntityProveedores consulta = new EntityProveedores();
		try {

			if (request.getEmpresa() != "") {
				consulta.setEmpresa(request.getEmpresa());
			}

			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			List<EntityProveedores> listaProveedores = lProveedor.obtenerProveedor(consulta);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloProveedores> Proveedores = listaProveedores
					.stream().map(r -> new ModeloProveedores(r.getId(), r.getEmpresa(), r.getTipoProducto(),
							r.getNroTelefono(), r.getDescripcion(), r.getEmail(), r.getEstatus()))
					.collect(Collectors.toList());
			resp.setProveedores(Proveedores);
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
	public Proveedores actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProveedores request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion

		Proveedores resp = new Proveedores();
		EntityProveedores consulta = new EntityProveedores();
		try {
			if (request.getEmpresa() != "") {
				consulta.setEmpresa(request.getEmpresa());
			}
			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			if (request.getId() != null) {
				consulta.setId(Integer.valueOf(request.getId()));
			}

			lProveedor.actualizar(consulta);
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
	public Proveedores eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProveedores request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Proveedores resp = new Proveedores();
		try {

			lProveedor.eliminarProveedor(Integer.valueOf(request.getId()));
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
