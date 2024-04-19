package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermisoRol {
	private String createdBy;
	private LocalDateTime createdDate;
	private BigDecimal estado;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	
	private Integer IdPermiso; //era long
	private Integer RolId;// era long
	
	
	
	 
 
	
}
