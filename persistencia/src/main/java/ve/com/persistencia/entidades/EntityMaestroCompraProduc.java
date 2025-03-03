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
@Table(name = "maestro_compras_produc")
@Data
public class EntityMaestroCompraProduc {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "num_factura")
	private String numFactura;
	@Column(name = "sub_total")
	private String subTotal;
	@Column(name = "iva")
	private String iva;
	@Column(name = "total")
	private String total;
	@Column(name = "id_estatus")
	private String estatus;
}