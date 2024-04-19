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
@Table("techapplogistic.tech_envio_historial")
public class EnvioHistorialReactivo {

	@Id
	private Integer envioHistorialId;

	private Integer idEnvio;
	private Integer idConductor;
	private Integer idUsuario;
	private LocalDateTime fechaCreado;
	private String tipo;
	private String parametro;

}
