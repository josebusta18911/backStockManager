package ve.com.servicio.rest.DTO.request.autenticacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqLogin {
	private String usuario;
	private String password;
}
