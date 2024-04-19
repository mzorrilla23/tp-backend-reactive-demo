package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogConductor {

	
	private Integer conductorLogId;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String createdBy;
	private LocalDateTime createdDate;
	private String email;
	private BigDecimal estado;
	private LocalDate fechaNacimiento;
	private BigDecimal idSexo;
	private String imageUrl;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	private String nombre;
	private String nroBrevete;
	private LocalDateTime  resetDate;
	private long envioId;
	
	
	 

	
	

}
