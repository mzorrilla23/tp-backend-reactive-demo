package pe.com.techpeople.logistic.service;

import java.time.LocalDate;

import pe.com.techpeople.logistic.model.bean.CambioMonedaRequest;
import pe.com.techpeople.logistic.model.bean.TransaccionBean;
import pe.com.techpeople.logistic.model.entity.TblTipoCambio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoCambioServiceInterface {
	
	public Mono<TblTipoCambio> save(TblTipoCambio tblTipoCambio);
	
	public Mono<TransaccionBean> update(Long id, TblTipoCambio tblTipoCambio);
	
	public Mono<TblTipoCambio> get(Long id);
	
	public Flux<TblTipoCambio> getFecha(LocalDate fecha);

	Flux<Double> cambioMonedaCompra(CambioMonedaRequest cambioMonedaRequest);

	Flux<Double> cambioMonedaVenta(CambioMonedaRequest cambioMonedaRequest);
	

}
