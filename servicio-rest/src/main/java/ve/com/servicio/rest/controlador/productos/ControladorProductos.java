package ve.com.servicio.rest.controlador.productos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;
import ve.com.negocio.productos.LogicaProductos;
import ve.com.persistencia.entidades.EntityProductos;
import ve.com.servicio.rest.DTO.request.productos.ModeloReqProductos;
import ve.com.servicio.rest.DTO.response.productos.ModeloProductos;
import ve.com.servicio.rest.DTO.response.productos.Productos;
import ve.com.servicio.rest.utils.EnumRespuesta;

public class ControladorProductos {

	// Atributos
	@Autowired
	private LogicaProductos lProducto;

	// Metodos publicos
	@PostMapping("registrar")
	public Productos registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProductos request)
			throws Exception {
		// Creamos Proveedor
		EntityProductos Proveedor = new EntityProductos();
		Proveedor.setEstatus(Integer.valueOf(request.getEstatus()));
		Proveedor.setNombre(request.getNombre());
		Productos resp = new Productos();
		try {
			// Almacenamos la informacion
			boolean exitoso = false;
			exitoso = lProducto.guardar(Proveedor);
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
	public Productos consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProductos request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Productos resp = new Productos();
		EntityProductos consulta = new EntityProductos();
		try {

			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}

			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			List<EntityProductos> listaProductos = lProducto.obtenerProducto(consulta);
		
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloProductos> Productos = listaProductos.stream()
					.map(r -> new ModeloProductos(r.getId(), r.getIdProveedor(),r.getCodigo(), r.getImagen(), r.getNombre(), 
							r.getMarca(),r.getPrecioUnidad(),r.getStock(), r.getIdCategoria(),r.getIdCompra(),r.getUtilidadPorcentaje(), r.getEstatus()))
					.collect(Collectors.toList());
			resp.setProductos(Productos);
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
	public Productos actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProductos request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion

		Productos resp = new Productos();
		EntityProductos consulta = new EntityProductos();
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

			lProducto.actualizar(consulta);
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
	public Productos eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqProductos request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Productos resp = new Productos();
		try {

			lProducto.eliminarProducto(Integer.valueOf(request.getId()));
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
