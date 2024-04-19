package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.techpeople.logistic.config.dto.DateDtoLocalDateConfiguration;

import org.springframework.data.annotation.Id;

import org.springframework.data.relational.core.mapping.Table;
 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("techapplogistic.tech_envio")
public class Envio {

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
	
	@JsonSerialize(using = DateDtoLocalDateConfiguration.FechaJacksonSerializer.class)
    @JsonDeserialize(using = DateDtoLocalDateConfiguration.FechaJacksonDeserializer.class)
	private LocalDateTime fechaEntrega;
	private String ubicacionRecojo;
	private String ubicacionEntrega;
	 

	 
	
	
	
}
