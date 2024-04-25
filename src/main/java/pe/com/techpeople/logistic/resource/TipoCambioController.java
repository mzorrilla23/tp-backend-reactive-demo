package pe.com.techpeople.logistic.resource;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.techpeople.logistic.model.bean.TransaccionBean;
import pe.com.techpeople.logistic.model.entity.TblTipoCambio;
import pe.com.techpeople.logistic.service.TipoCambioServiceImpl;
import pe.com.techpeople.logistic.service.TipoCambioServiceInterface;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tipocambio")
//@RestController
public class TipoCambioController {
	
	@Autowired
	private TipoCambioServiceInterface tipoCambioService;
	
	/*public TipoCambioController(TipoCambioServiceImpl tipoCambioService) {
		this.tipoCambioService = tipoCambioService;
	}*/
	 
	 @PostMapping
	 public Mono<TblTipoCambio> crearTipoCambio(@RequestBody TblTipoCambio tblTipoCambio){
		 System.out.println("Llego a api mono");
		 
		 return tipoCambioService.save(tblTipoCambio);
	 }
	 
	 @PutMapping("/{id}")
	 public Mono<TransaccionBean> updateTipoCambio(@PathVariable Long id, @RequestBody TblTipoCambio tblTipoCambio){
		 System.out.println("Llego a api mono id: "+ id);
		 tblTipoCambio.setIdTipoCambio(id);
		 return tipoCambioService.update(id, tblTipoCambio);
	 }
	 
	 @GetMapping("/{id}")
	 public Mono<TblTipoCambio> updateTipoCambio(@PathVariable("id") Long id){
		 System.out.println("Llego a api mono id: "+ id);
		
		 return tipoCambioService.get(id);
	 }
	 
	 @GetMapping("/fecha/{fecha}")
	 public Flux<TblTipoCambio> getFecha(@PathVariable("fecha") String fecha){
		 System.out.println("Llego a api mono id: "+ fecha);
		
		 return tipoCambioService.getFecha(LocalDate.parse(fecha));
	 }

}
