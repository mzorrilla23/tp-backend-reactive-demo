package pe.com.techpeople.logistic.config.persistencia;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

public class NumberSecuenceGenerator extends SequenceStyleGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    	//System.out.println("lLLEGO A SECUENCIA DETALLE");
    	//System.out.println(object);
    	//System.out.println(":::::::::::::: "+String.format("%d", super.generate(session, object)));
    	//System.out.println(":::::::::::::: "+super.generate(session, object));
        return super.generate(session, object);
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    	//System.out.println(params);
    	//System.out.println("Llego a configure IntegerType ");
        super.configure(IntegerType.INSTANCE, params, serviceRegistry);
    }
    
}