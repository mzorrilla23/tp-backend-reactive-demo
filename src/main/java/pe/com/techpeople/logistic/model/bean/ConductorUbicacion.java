package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConductorUbicacion {
	
	private Integer envioId;
	private Integer conductorId;
	private BigDecimal coordenadaX;
	private BigDecimal coordenadaY;
	private String createdBy;
	private LocalDateTime createdDate;
	private String detalle;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	
	 
	
}
