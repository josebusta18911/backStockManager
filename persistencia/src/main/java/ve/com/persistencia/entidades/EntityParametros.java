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
@Table(name = "INFI_TB_002_PARAM_TIPOS")
@Data
public class EntityParametros {

	@Id
	@Column(name = "PARTIP_NOMBRE_PARAMETRO")
	private String partipNombreParametro;
	@Column(name = "PARTIP_DESCRIPCION")
	private String partipDescripcion;
	@Column(name = "PARGRP_ID")
	private String pargrpId;
	@Column(name = "PARTIP_VALOR_DEFECTO")
	private String partipValorDefecto;
	@Column(name = "PARVAL_VALOR")
	private String parvalValor;
}
