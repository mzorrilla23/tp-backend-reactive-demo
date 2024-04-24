package pe.com.techpeople.logistic.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.techpeople.logistic.model.bean.Conductor;
import pe.com.techpeople.logistic.model.entity.TblTipoCambio;
import pe.com.techpeople.logistic.repository.TipoCambioRepository;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tipocambio")
//@RestController
public class TipoCambioController {
	
	 //@Autowired
	 private final TipoCambioRepository tipoCambioRepository;
	 
	 public TipoCambioController(TipoCambioRepository tipoCambioRepository) {
	        this.tipoCambioRepository = tipoCambioRepository;
	    }
	 
	 //@RequestBody Conductor conducto
	 @PostMapping(path="")
	 public Mono<TblTipoCambio> crearTipoCambio(@RequestBody TblTipoCambio tblTipoCambio){
		 System.out.println("Llego a api mono");
		 
		 return tipoCambioRepository.save(tblTipoCambio);
	 }

}
