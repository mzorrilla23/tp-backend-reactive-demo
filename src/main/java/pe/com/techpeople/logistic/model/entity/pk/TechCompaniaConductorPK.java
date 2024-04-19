package pe.com.techpeople.logistic.model.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TECH_COMPANIA_CONDUCTOR database table.
 * 
 */
@Embeddable
public class TechCompaniaConductorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMPANIA_ID", insertable=false, updatable=false)
	private Integer companiaId;

	@Column(name="CONDUCTOR_ID")
	private Integer conductorId;

	public TechCompaniaConductorPK() {
	}


	public TechCompaniaConductorPK(Integer companiaId, Integer conductorId) {
		super();
		this.companiaId = companiaId;
		this.conductorId = conductorId;
	}


	public Integer getCompaniaId() {
		return companiaId;
	}

	public void setCompaniaId(Integer companiaId) {
		this.companiaId = companiaId;
	}

	public Integer getConductorId() {
		return conductorId;
	}

	public void setConductorId(Integer conductorId) {
		this.conductorId = conductorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companiaId == null) ? 0 : companiaId.hashCode());
		result = prime * result + ((conductorId == null) ? 0 : conductorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechCompaniaConductorPK other = (TechCompaniaConductorPK) obj;
		if (companiaId == null) {
			if (other.companiaId != null)
				return false;
		} else if (!companiaId.equals(other.companiaId))
			return false;
		if (conductorId == null) {
			if (other.conductorId != null)
				return false;
		} else if (!conductorId.equals(other.conductorId))
			return false;
		return true;
	}
	


}