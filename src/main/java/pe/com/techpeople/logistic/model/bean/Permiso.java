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
public class Permiso {
	private Integer idPermiso; // ERA long
	private String createdBy;
	private LocalDateTime createdDate;
	private String descripcion;
	private BigDecimal estado;
	private String icon;
	private BigDecimal idPadre;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	private BigDecimal nivel;
	private String nombre;
	private String path;
	private String type;
	
	 
	
}
