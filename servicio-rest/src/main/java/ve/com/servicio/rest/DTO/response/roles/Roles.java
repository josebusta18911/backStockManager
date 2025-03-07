package ve.com.servicio.rest.DTO.response.roles;

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
@EqualsAndHashCode(callSuper=false)
public class Roles extends ModeloRespBase{
	
	private List<ModeloRol>  roles;
}
