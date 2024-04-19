package pe.com.techpeople.logistic.model.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AC_PERMISO_ROL database table.
 * 
 */
@Embeddable
public class AcPermisoRolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PERMISO", insertable=false, updatable=false)
	private Integer idPermiso; //era long

	@Column(name="ROL_ID", insertable=false, updatable=false)
	private Integer rolId;


	public AcPermisoRolPK(Integer idPermiso, Integer rolId) {
		super();
		this.idPermiso = idPermiso;
		this.rolId = rolId;
	}
	public AcPermisoRolPK() {
	}
	public Integer getIdPermiso() {
		return this.idPermiso;
	}
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}
	public Integer getRolId() {
		return this.rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcPermisoRolPK)) {
			return false;
		}
		AcPermisoRolPK castOther = (AcPermisoRolPK)other;
		return 
			(this.idPermiso == castOther.idPermiso)
			&& (this.rolId == castOther.rolId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idPermiso ^ (this.idPermiso >>> 32)));
		hash = hash * prime + ((int) (this.rolId ^ (this.rolId >>> 32)));
		
		return hash;
	}
}