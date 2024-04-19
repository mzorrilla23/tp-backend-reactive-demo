package pe.com.techpeople.logistic.model.bean.proyecciones;

import java.math.BigDecimal;
import java.util.Date;

public interface EnvioConductorProyeccion {
	
	Integer getenvioId();
	String getapellidoMaternoRef();
	String getapellidoPaternoRef();
	BigDecimal getcoordenadaAx();
	BigDecimal getcoordenadaAy();
	BigDecimal getcoordenadaBx();
	BigDecimal getcoordenadaBy();
	String getcreatedBy();
	Date getcreatedDate();
	String getdetalle();
	String getdni();
	BigDecimal getestado();
	String getlastModifiedBy();
	Date getlastModifiedDate();
	String getmotivoFallo();
	String getnombreRef();
	String getreferencia();
	String gettelefonoRef();
	String getubicacion();
	
	Integer getconductorId();
	Integer getuserId();
	String getapellidoMaterno();
	String getapellidoPaterno();
	String getemail();
	Date getfechaNacimiento();
	BigDecimal getidSexo();
	String getimageUrl();
	String getnombre();
	String getnroBrevete();
	Date getresetDate();
}
