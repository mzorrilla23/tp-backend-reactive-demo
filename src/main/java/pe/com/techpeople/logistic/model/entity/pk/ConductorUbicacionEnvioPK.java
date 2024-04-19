package pe.com.techpeople.logistic.model.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONDUCTOR_UBICACION_ENVIO database table.
 * 
 */
@Embeddable
public class ConductorUbicacionEnvioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ENVIO_ID")
	private Integer envioId;

	@Column(name="CONDUCTOR_ID")
	private Integer conductorId;

	
	public ConductorUbicacionEnvioPK() {
	}
	
	
	public ConductorUbicacionEnvioPK(Integer envioId, Integer conductorId) {
		super();
		this.envioId = envioId;
		this.conductorId = conductorId;
	}

	public Integer getEnvioId() {
		return this.envioId;
	}
	public void setEnvioId(Integer envioId) {
		this.envioId = envioId;
	}
	public Integer getConductorId() {
		return this.conductorId;
	}
	public void setConductorId(Integer conductorId) {
		this.conductorId = conductorId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConductorUbicacionEnvioPK)) {
			return false;
		}
		ConductorUbicacionEnvioPK castOther = (ConductorUbicacionEnvioPK)other;
		return 
			(this.envioId == castOther.envioId)
			&& (this.conductorId == castOther.conductorId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.envioId ^ (this.envioId >>> 32)));
		hash = hash * prime + ((int) (this.conductorId ^ (this.conductorId >>> 32)));
		
		return hash;
	}
}