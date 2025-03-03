package ve.com.servicio.rest.controlador.parametros;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import ve.com.negocio.parametros.LogicaParametros;
import ve.com.persistencia.entidades.EntityParametros;
import ve.com.servicio.rest.DTO.request.DTOReqParametros;
import ve.com.servicio.rest.DTO.response.parametros.DTORespParametros;
import ve.com.servicio.rest.DTO.response.parametros.Parametros;
import ve.com.servicio.rest.utils.EnumRespuesta;

/**
 * 
 * Controlador que contiene las operaciones para la interaccion con los
 * parametros
 * 
 * @author Jose Bustamante
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/stockManager")
@CrossOrigin
public class ControladorParametros {

	@Autowired
	private LogicaParametros logicaParametros;

	@PostMapping("/parametros")
	public Parametros buscarParametrosGrupo(@RequestBody DTOReqParametros request) {
		Parametros resp = new Parametros();
		Optional<EntityParametros> listaParametros;
		System.out.println("request::"+request);
		try {
			listaParametros = logicaParametros.obtenerParametrosPorId(request.getId());

			resp.setCodigo(EnumRespuesta.Aprobada.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.Aprobada.getMensajeCliente());
			resp.setMensajeSistema(EnumRespuesta.Aprobada.getMensajeCliente());

			// Procesamos la lista de parametros			
			List<DTORespParametros> parametros = listaParametros.stream()
					.map(p -> new DTORespParametros(p.getId(),p.getNombre(),p.getValor(),p.getValorDefecto(),
							p.getDescripcion(),p.getEstatus()))
					.collect(Collectors.toList()); 

			resp.setParametros(parametros);
		} catch (Exception e) {
			log.error("Error al intentar Obtener los parametros por grupo" + e.getMessage());
			resp.setCodigo(EnumRespuesta.ConsultaParametrosInvalida.getCodigo());
			resp.setMensajeCliente(EnumRespuesta.ConsultaParametrosInvalida.getMensajeCliente());
			resp.setMensajeSistema(e.getMessage());
		}
		return resp;
	}

}
