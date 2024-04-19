package pe.com.techpeople.logistic.config.persistencia;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;

import java.io.Serializable;
import java.util.Properties;

public class StringSequenceGenerator extends SequenceStyleGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    	System.out.println("lLLEGO A SECUENCIA ::::::::::::::::");
    	System.out.println(object);
    	//System.out.println(":::::::::::::: "+String.format("%07d", super.generate(session, object)));
    	//System.out.println(":::::::::::::: "+super.generate(session, object));
    	String pt="0048";
    	try {
    		//System.out.println("=> "+super.generate(session, object));
    		pt=String.format("%05d", super.generate(session, object));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("llego a exp");
		}    	
    			
        return pt;
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    	System.out.println(params);
    	System.out.println("Llego a configure");
        super.configure(IntegerType.INSTANCE, params, serviceRegistry);
    }
    
}





