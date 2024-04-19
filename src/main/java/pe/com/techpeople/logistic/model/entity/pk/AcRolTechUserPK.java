package pe.com.techpeople.logistic.model.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AC_ROL_TECH_USER database table.
 * 
 */
@Embeddable
public class AcRolTechUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ROL_ID", insertable=false, updatable=false)
	private Integer rolId;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private Integer userId;
	
	public AcRolTechUserPK(Integer rolId, Integer userId) {
		super();
		this.rolId = rolId;
		this.userId = userId;
	}
	
	public AcRolTechUserPK() {
	}
	public Integer getRolId() {
		return this.rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcRolTechUserPK)) {
			return false;
		}
		AcRolTechUserPK castOther = (AcRolTechUserPK)other;
		return 
			(this.rolId == castOther.rolId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.rolId ^ (this.rolId >>> 32)));
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		
		return hash;
	}
}