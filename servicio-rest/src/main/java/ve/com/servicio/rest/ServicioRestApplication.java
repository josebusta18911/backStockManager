package ve.com.servicio.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * inicializador del componente rest
 * 
 * @author Jose Bustamante
 *
 */
@SpringBootApplication(scanBasePackages = "ve.com")
public class ServicioRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioRestApplication.class, args);
	}

}
