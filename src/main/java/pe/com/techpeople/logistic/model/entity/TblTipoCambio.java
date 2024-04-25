package pe.com.techpeople.logistic.model.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("tbl_tipo_cambio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TblTipoCambio{
	
	/**
	 * 
	 */
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column("id_tipo_cambio")
    private Long idTipoCambio;
	

    private LocalDate fecha;
	
    private Long compra;

    private Long venta;

    private Long periodo;

    private LocalDate fechaCrea;

    private String usuarioCrea;

    private LocalDate fechaUpdate;

    private String usuarioUpdate;

    private Long flagEstado;
    
}
