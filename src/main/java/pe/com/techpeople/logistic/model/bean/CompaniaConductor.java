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
public class CompaniaConductor {


	private Integer companiaId;
	private Integer conductorId;	
	private String createdBy;	
	private LocalDateTime createdDate;	
	private BigDecimal estado;
	private String lastModifiedBy;	
	private LocalDateTime lastModifiedDate;	
	private LocalDateTime resetDate;
	
 
	
	

}
