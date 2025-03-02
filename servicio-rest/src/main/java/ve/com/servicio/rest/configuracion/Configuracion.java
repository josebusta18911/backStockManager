package ve.com.servicio.rest.configuracion;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Clase que contiene los elementos de configuracion general de la plataforma
 * 
 * @author jose bustamante
 *
 */
@Slf4j
@Configuration
@Order(1)
public class Configuracion {

	// Inicializador
	@PostConstruct
	private void init() {
		log.info("Inicializador de Aplicacion");
	}
}
