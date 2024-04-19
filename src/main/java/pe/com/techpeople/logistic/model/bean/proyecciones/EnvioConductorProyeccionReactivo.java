package pe.com.techpeople.logistic.model.bean.proyecciones;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class EnvioConductorProyeccionReactivo {
				     
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
	private  LocalDateTime lastModifiedDate;
	private String motivoFallo;
	private String nombreRef;
	private String referencia;
	private String telefonoRef;
	private String ubicacion;
	
	private Integer conductorId;
	private Integer userId;
	
 	private LocalDateTime fechaEntrega;
	private String ubicacionRecojo;
	private String ubicacionEntrega;
	
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String email;
	private LocalDateTime fechaNacimiento;
	private BigDecimal idSexo;
	private String imageUrl;
	private String nombre;
	private String nroBrevete;
	private LocalDateTime resetDate;
	 

}
