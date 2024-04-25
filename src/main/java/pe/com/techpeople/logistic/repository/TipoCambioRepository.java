package pe.com.techpeople.logistic.repository;

import java.time.LocalDate;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.techpeople.logistic.model.entity.TblTipoCambio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TipoCambioRepository extends ReactiveCrudRepository<TblTipoCambio, Long>{
	
	public  Mono<TblTipoCambio> findByIdTipoCambio(Long id);
	
	public  Flux<TblTipoCambio> findByFecha(LocalDate fecha);

}
