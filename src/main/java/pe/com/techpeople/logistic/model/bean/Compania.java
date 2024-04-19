package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
 

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
 public class Compania {
	private Integer companiaId; //long tenia
	private String activoPdt;
	private String cargoRepresentante;
	private BigDecimal codPais;
	private String createdby;
	private LocalDateTime createddate;
	private String descripcion;
	private String descripcionComercial;
	private String direccion;
	private BigDecimal dniRepresentante;
	private String email;
	private BigDecimal flagEstado;
	private String lastmodifiedby;
	private LocalDateTime lastmodifieddate;
	private String latitud;
	private String logo;
	private String longitud;
	private BigDecimal nroRuc;
	private String representante;
	private BigDecimal telefonoDos;
	private BigDecimal telefonoTres;
	private BigDecimal telefonoUno;
	private String webSite;
	
	
	
	 
}
