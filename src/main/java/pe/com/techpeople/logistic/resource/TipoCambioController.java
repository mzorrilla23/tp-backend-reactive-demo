package pe.com.techpeople.logistic.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.techpeople.logistic.model.entity.TblTipoCambio;
import pe.com.techpeople.logistic.repository.TipoCambioRepository;
import reactor.core.publisher.Mono;

@RestController
public class TipoCambioController {
	
	 @Autowired
	 TipoCambioRepository tipoCambioRepository;
	 
	 @PostMapping("/tipoCambio")
	 public Mono<TblTipoCambio> crearTipoCambio(@RequestBody TblTipoCambio tblTipoCambio){
		 
		 return tipoCambioRepository.save(tblTipoCambio);
	 }

}
