package ve.com.servicio.rest.controlador.categorias;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;
import ve.com.negocio.categorias.LogicaCategorias;
import ve.com.persistencia.entidades.EntityCategorias;
import ve.com.servicio.rest.DTO.request.categorias.ModeloReqCategorias;
import ve.com.servicio.rest.DTO.response.categorias.Categorias;
import ve.com.servicio.rest.DTO.response.categorias.ModeloRespCategorias;
import ve.com.servicio.rest.utils.EnumRespuesta;

public class ControladorCategorias {

	// Atributos
	@Autowired
	private LogicaCategorias lCategoria;

	// Metodos publicos
	@PostMapping("registrar")
	public Categorias registrar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqCategorias request)
			throws Exception {
		// Creamos Proveedor
		EntityCategorias Proveedor = new EntityCategorias();
		Proveedor.setEstatus(Integer.valueOf(request.getEstatus()));
		Proveedor.setNombre(request.getNombre());
		Categorias resp = new Categorias();
		try {
			// Almacenamos la informacion
			boolean exitoso = false;
			exitoso = lCategoria.guardar(Proveedor);
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
	public Categorias consulta(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqCategorias request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Categorias resp = new Categorias();
		EntityCategorias consulta = new EntityCategorias();
		try {

			if (request.getNombre() != "") {
				consulta.setNombre(request.getNombre());
			}

			if (request.getEstatus() != null) {
				consulta.setEstatus(Integer.valueOf(request.getEstatus()));
			}
			List<EntityCategorias> listaCategorias = lCategoria.obtenerCategoria(consulta);
			// Procesamos los resultados
			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			List<ModeloRespCategorias> Categorias = listaCategorias.stream()
					.map(r -> new ModeloRespCategorias(r.getId(), r.getNombre(), r.getDescripcion(), r.getEstatus()))
					.collect(Collectors.toList());
			resp.setCategorias(Categorias);
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
	public Categorias actualizar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqCategorias request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion

		Categorias resp = new Categorias();
		EntityCategorias consulta = new EntityCategorias();
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

			lCategoria.actualizar(consulta);
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
	public Categorias eliminar(@RequestHeader Map<String, String> headers, @RequestBody ModeloReqCategorias request)
			throws HttpClientErrorException, Exception {

		// Procesamos la peticion
		Categorias resp = new Categorias();
		try {

			lCategoria.eliminar(Integer.valueOf(request.getId()));
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
