package ve.com.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * Entidad para la tabla parametros
 * 
 * @author Jose Bustamante
 *
 */

@Entity
@Table(name = "compras_clientes")
@Data
public class EntityComprasClientes {
	
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_venta")
	private String idVenta;
	@Column(name = "id_cliente")
	private String idCliente;
}
