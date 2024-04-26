package pe.com.techpeople.logistic.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.techpeople.logistic.model.bean.CambioMonedaRequest;
import pe.com.techpeople.logistic.model.bean.CambioMonedaResponse;
import pe.com.techpeople.logistic.model.bean.TransaccionBean;
import pe.com.techpeople.logistic.model.entity.TblTipoCambio;
import pe.com.techpeople.logistic.repository.TipoCambioRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoCambioServiceImpl implements TipoCambioServiceInterface{
	
	 @Autowired
	 private TipoCambioRepository tipoCambioRepository;
	 /*
	 public TipoCambioServiceImpl(TipoCambioRepository tipoCambioRepository) {
	        this.tipoCambioRepository = tipoCambioRepository;
	 }*/

	@Override
	public Mono<TblTipoCambio> save(TblTipoCambio tblTipoCambio){
		 
		 return tipoCambioRepository.save(tblTipoCambio);
	 }

	@Override
	public Mono<TransaccionBean> update(Long id, TblTipoCambio tblTipoCambio) {
		// TODO Auto-generated method stub
		 System.out.println("id tipo envio a: " + id);
		 System.out.println("id tipo envio b: " + tblTipoCambio.getIdTipoCambio());
		Mono<TblTipoCambio> findById=tipoCambioRepository.findByIdTipoCambio(id);
		
		Mono<TblTipoCambio> updateTipoCambioMono=findById.map(tipoCambio->{
			tipoCambio.setUsuarioCrea(tblTipoCambio.getUsuarioCrea());
			tipoCambio.setUsuarioUpdate(tblTipoCambio.getUsuarioUpdate());
			return tipoCambio;
		});
		/*Mono<Long> idMono = findById.map(p-> p.getIdTipoCambio());
		idMono.subscribe(z->{
			 System.out.println("id tipo envio c: " + z);
		});*/
		TblTipoCambio block = findById.block();
		if (block == null) {
			 System.out.println("block tipo envio d: ");
			return Mono.just(new TransaccionBean("-1", "", "no existe id"));
		}
			
		return updateTipoCambioMono.flatMap(tipoCambioRepository::save)
				.doOnSuccess(p->{
					System.out.println("Llego e:: "+ p.getIdTipoCambio());
					System.out.println("Llego e:: "+ p.getUsuarioCrea());
 				})
			.flatMap((Function<TblTipoCambio, Mono<TransaccionBean>>) t -> Mono
			.just(new TransaccionBean("1", t.getIdTipoCambio() + " - " + t.getUsuarioCrea(), "satisfactorio")));
	}

	@Override
	public Mono<TblTipoCambio> get(Long id) {
	
		// TODO Auto-generated method stub
		return tipoCambioRepository.findByIdTipoCambio(id);
	}

	@Override
	public Flux<TblTipoCambio> getFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		return tipoCambioRepository.findByFecha(fecha);
	}
	
	 
	@Override 
	 public Flux<CambioMonedaResponse> cambioMonedaCompra(  CambioMonedaRequest cambioMonedaRequest){
	     System.out.println("Llego a api mono id: " + cambioMonedaRequest.getFecha());
	     LocalDate fechaConsulta = LocalDate.parse(cambioMonedaRequest.getFecha());
	     
	     // Obtener los registros de tipo cambio para la fecha especificada
	     Flux<TblTipoCambio> tipoCambioFlux =  getFecha(fechaConsulta);
	     
	     // Filtrar los registros por la moneda especificada
	     Flux<TblTipoCambio> tipoCambioMonedaFlux = tipoCambioFlux.filter(tc -> tc.getMoneda().equals(cambioMonedaRequest.getMoneda()));
	     Flux<CambioMonedaResponse> valorCambiadoFlux = tipoCambioMonedaFlux.map(tc -> {
			CambioMonedaResponse cambioMonedaResponse = new CambioMonedaResponse();
			cambioMonedaResponse.setFecha(cambioMonedaRequest.getFecha());
			BigDecimal respuesta = tc.getCompra().multiply(BigDecimal.valueOf(cambioMonedaRequest.getCantidad()))  ;
			cambioMonedaResponse.setCantidad(respuesta.setScale(3, RoundingMode.HALF_UP));
			cambioMonedaResponse.setTipoCambio(  tc.getCompra()   );
			return cambioMonedaResponse ;
		} );

	     return valorCambiadoFlux;
	 }
	 
	@Override
	 public Flux<CambioMonedaResponse> cambioMonedaVenta(  CambioMonedaRequest cambioMonedaRequest){
	     System.out.println("Llego a api mono id: " + cambioMonedaRequest.getFecha());
	     LocalDate fechaConsulta = LocalDate.parse(cambioMonedaRequest.getFecha());
	     
	     // Obtener los registros de tipo cambio para la fecha especificada
	     Flux<TblTipoCambio> tipoCambioFlux =  getFecha(fechaConsulta);
	     
	     Flux<TblTipoCambio> tipoCambioMonedaFlux = tipoCambioFlux.filter(tc -> tc.getMoneda().equals(cambioMonedaRequest.getMoneda()));
	     Flux<CambioMonedaResponse> valorCambiadoFlux = tipoCambioMonedaFlux.map(tc -> {
	    	 CambioMonedaResponse cambioMonedaResponse = new CambioMonedaResponse();
				cambioMonedaResponse.setFecha(cambioMonedaRequest.getFecha());
				BigDecimal respuesta = tc.getVenta().multiply(BigDecimal.valueOf(cambioMonedaRequest.getCantidad()))  ;
				cambioMonedaResponse.setCantidad(respuesta.setScale(3, RoundingMode.HALF_UP));
				cambioMonedaResponse.setTipoCambio(  tc.getCompra()   );
				return cambioMonedaResponse ;
		} );

	     return valorCambiadoFlux;
	 }

}
