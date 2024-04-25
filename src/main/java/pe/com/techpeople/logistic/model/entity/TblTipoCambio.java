package pe.com.techpeople.logistic.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table("TBL_TIPO_CAMBIO")
//@NamedQuery(name="TblTipoCambio.findAll", query="SELECT t FROM TblTipoCambio t")
public class TblTipoCambio{
	
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column("id_tipo_cambio")
    private Long id_tipo_cambio;
	
	@Column("fecha")
    private LocalDate fecha;
	@Column("compra")
    private Long compra;
	@Column("venta")
    private Long venta;
	@Column("periodo")
    private Long periodo;
	@Column("fecha_crea")
    private LocalDate fecha_crea;
	@Column("usuario_crea")
    private String usuario_crea;
	@Column("fecha_update")
    private LocalDate fecha_update;
	@Column("usuario_update")
    private String usuario_update;
	@Column("flag_estado")
    private Long flag_estado;
    
    
    public TblTipoCambio() {
    	
    }
    
	public TblTipoCambio(Long id, LocalDate fecha, Long compra, Long venta, Long periodo, LocalDate fecha_crea,
			String usuario_crea, LocalDate fecha_update, String usuario_update, Long flagEstado) {
		super();
		this.id_tipo_cambio = id;
		this.fecha = fecha;
		this.compra = compra;
		this.venta = venta;
		this.periodo = periodo;
		this.fecha_crea = fecha_crea;
		this.usuario_crea = usuario_crea;
		this.fecha_update = fecha_update;
		this.usuario_update = usuario_update;
		this.flag_estado = flagEstado;
	}

	public Long getId() {
		return id_tipo_cambio;
	}
	public void setId(Long id) {
		this.id_tipo_cambio = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Long getCompra() {
		return compra;
	}
	public void setCompra(Long compra) {
		this.compra = compra;
	}
	public Long getVenta() {
		return venta;
	}
	public void setVenta(Long venta) {
		this.venta = venta;
	}
	public Long getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}
	public LocalDate getFecha_crea() {
		return fecha_crea;
	}
	public void setFecha_crea(LocalDate fecha_crea) {
		this.fecha_crea = fecha_crea;
	}
	public String getUsuario_crea() {
		return usuario_crea;
	}
	public void setUsuario_crea(String usuario_crea) {
		this.usuario_crea = usuario_crea;
	}
	public LocalDate getFecha_update() {
		return fecha_update;
	}
	public void setFecha_update(LocalDate fecha_update) {
		this.fecha_update = fecha_update;
	}
	public String getUsuario_update() {
		return usuario_update;
	}
	public void setUsuario_update(String usuario_update) {
		this.usuario_update = usuario_update;
	}
	public Long getFlagEstado() {
		return flag_estado;
	}
	public void setFlagEstado(Long flagEstado) {
		this.flag_estado = flagEstado;
	}
    
    
}
