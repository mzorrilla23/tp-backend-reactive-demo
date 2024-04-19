package pe.com.techpeople.logistic.model.bean;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("techapplogistic.conductor_ubicacion_envio")
public class ConductorUbicacionReactivo {

	@Id
	private Integer conductorUbicacionId;

	private Integer conductorId;
	private double coordenadaX;
	private double coordenadaY;
	private String createdBy;
	private LocalDateTime createdDate;
	private String detalle;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;

}
