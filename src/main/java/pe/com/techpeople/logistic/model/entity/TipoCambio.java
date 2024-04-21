package pe.com.techpeople.logistic.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

//import org.hibernate.annotations.Table;
//import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;


@Entity
//@Table("tbl_tipo_cambio")
@NamedQuery(name="TblTipoCambio.findAll", query="SELECT t FROM TblTipoCambio t")
public class TipoCambio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9118981718096513027L;
	
	@Id
    private Long id;
    private LocalDate fecha;
    private Long compra;
    private Long venta;
    private Long periodo;
    private LocalDate fecha_crea;
    private String usuario_crea;
    private LocalDate fecha_update;
    private String usuario_update;
    private Long flagEstado;
    
}
