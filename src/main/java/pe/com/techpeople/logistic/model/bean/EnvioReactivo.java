package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("techapplogistic.tech_envio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnvioReactivo {

	@Id
	private Integer envioId;
	private String apellidoMaternoRef;
	private String apellidoPaternoRef;
	private BigDecimal coordenadaAx;
	private BigDecimal coordenadaAy;
	private BigDecimal coordenadaBx;
	private BigDecimal coordenadaBy;
	private String createdBy;
	private LocalDateTime createdDate;
	private String detalle;
 	private String dni;
	private String estado;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	private String motivoFallo;
	private String nombreRef;
	private String referencia;
	private String telefonoRef;
	private String ubicacion;

	private Integer conductorId;
	private Integer userId;

	private LocalDateTime fechaEntrega;
	private String ubicacionRecojo;
	private String ubicacionEntrega;

}
