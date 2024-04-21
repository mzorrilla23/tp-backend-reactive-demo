package pe.com.techpeople.logistic.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table("tbl_tipo_cambio")
@NamedQuery(name="TblTipoCambio.findAll", query="SELECT t FROM TblTipoCambio t")
public class TblTipoCambio implements Serializable{
	
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
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return flagEstado;
	}
	public void setFlagEstado(Long flagEstado) {
		this.flagEstado = flagEstado;
	}
    
    
}
