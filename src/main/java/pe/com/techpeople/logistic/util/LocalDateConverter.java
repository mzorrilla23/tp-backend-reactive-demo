package pe.com.techpeople.logistic.util;

import java.sql.Date;
import java.time.LocalDate;
 
import javax.persistence.AttributeConverter;

public class LocalDateConverter implements AttributeConverter <LocalDate, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return attribute != null ? Date.valueOf(attribute): null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return dbData != null ? dbData.toLocalDate() : null;
	}

}