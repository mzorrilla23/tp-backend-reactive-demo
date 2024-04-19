package pe.com.techpeople.logistic.model.bean;

 import java.time.LocalDateTime;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolTechUser {
	
	private Integer rolId;
	private Integer userId;
	private String createdby;
	private LocalDateTime createddate;
	private String estado;
	private String lastmodifiedby;
	private LocalDateTime lastmodifieddate;
	
	 

	 
}
