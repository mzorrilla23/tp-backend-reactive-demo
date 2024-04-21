package pe.com.techpeople.logistic.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.techpeople.logistic.model.entity.TblTipoCambio;

public interface TipoCambioRepository extends ReactiveCrudRepository<TblTipoCambio, Long>{
	
	

}
