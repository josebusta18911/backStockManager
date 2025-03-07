package ve.com.servicio.rest.DTO.response.empleados;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ve.com.servicio.rest.DTO.response.ModeloRespBase;

/**
 * Modelo de respuesta base del servicio
 * 
 * @author Jose bustamante
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Empleados extends ModeloRespBase {

	private List<ModeloRespEmpleados> empleados;

}
