package pe.com.techpeople.logistic.model.bean;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
 
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	
	private Integer userId;
	private String activated;
	private String activationKey;
	private String createdBy;
	private LocalDateTime createdDate;

	private String email;
	private String firstName;
	private String imageUrl;
	private String langKey;
	private String lastModifiedBy;

	private LocalDateTime lastModifiedDate;
	private String lastName;

	private String passtoken;

	private String passwordHash;

	private Date resetDate;

	private String resetKey;

	private String username;
	
	private String color;
	
	private LocalDate  fechaNacimiento;
	private String motherLastName;
	
	private Integer companiaId;

	private byte[] fotoArrayByte;
	
	private String nombreFoto;
	 
	 
	
	
}
