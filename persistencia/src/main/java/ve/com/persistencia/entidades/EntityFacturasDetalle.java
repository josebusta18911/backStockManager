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
@Table(name = "facturas_detalles")
@Data
public class EntityFacturasDetalle {
	
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_factura")
	private String idFactura;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "descr_factura")
	private String descrFactura;
	@Column(name = "subtotal")
	private String subtotal;
	@Column(name = "iva")
	private String iva;
	@Column(name = "descr_pago")
	private String descrPago;
	@Column(name = "id_metodo_de_pago")
	private String idMetodoPago;
}
