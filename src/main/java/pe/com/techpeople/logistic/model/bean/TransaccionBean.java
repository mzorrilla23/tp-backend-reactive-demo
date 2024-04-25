package pe.com.techpeople.logistic.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionBean {

	private String codigo;
	private String descripcion;
	private String codigoBackEnd;
	
	 
	
	
}