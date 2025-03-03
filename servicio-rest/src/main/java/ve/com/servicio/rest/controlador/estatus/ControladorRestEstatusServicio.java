package ve.com.servicio.rest.controlador.estatus;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ve.com.servicio.rest.DTO.response.ModeloRespBase;
import ve.com.servicio.rest.utils.EnumRespuesta;

/**
 * 
 * Controlador que contiene las operaciones de consulta de esta tus
 * 
 * @author Jose Bustamante
 *
 */

@RestController
@RequestMapping("/api/stockManager")
@CrossOrigin
public class ControladorRestEstatusServicio {

	// Metodos Publicos Web
	@GetMapping("/test")
	public ModeloRespBase estatus() {

		// Procesamos la peticion
		ModeloRespBase respuesta = new ModeloRespBase(EnumRespuesta.Aprobada.getCodigo(),
				EnumRespuesta.Aprobada.getMensajeCliente(), "Servicio ACTIVO");
		// entregamos la respuesta
		return respuesta;

	}

}
