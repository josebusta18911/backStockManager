package ve.com.servicio.rest.DTO.response.usuarios;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ve.com.servicio.rest.DTO.response.ModeloRespBase;  
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class Usuarios extends ModeloRespBase{ 
	
		private List<ModeloUsuario>  usuarios;
}
