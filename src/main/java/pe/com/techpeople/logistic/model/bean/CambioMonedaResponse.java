package pe.com.techpeople.logistic.model.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.techpeople.logistic.model.entity.TblTipoCambio;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambioMonedaResponse {
	private String fecha;
	BigDecimal   tipoCambio;
	BigDecimal    cantidad;
	

}
