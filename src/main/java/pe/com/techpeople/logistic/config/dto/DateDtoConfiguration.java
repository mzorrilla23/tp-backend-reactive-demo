package pe.com.techpeople.logistic.config.dto;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateDtoConfiguration {
 private static final DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    private static LocalDate parseFecha(String fecha) {
	    	
	    	
	        return LocalDate.parse(fecha.substring(0,10), fechaFormatter);
	    }

    private static String writeFecha(LocalDate fecha) {
    	System.out.println(fecha);
        return fechaFormatter.format(fecha);
    }

    public static class FechaJacksonDeserializer extends StdDeserializer<LocalDate> {

        private static final long serialVersionUID = -3248031647654176348L;

        public FechaJacksonDeserializer() {
            this(null);
        }

        public FechaJacksonDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            String date = p.getText();
            return parseFecha(date.substring(0,10));
        }

    }

    public static class FechaJacksonSerializer extends StdSerializer<LocalDate> {

        private static final long serialVersionUID = -4994523788442753333L;

        public FechaJacksonSerializer() {
            this(null);
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        public FechaJacksonSerializer(Class t) {
            super(t);
        }

        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider arg2)
                throws IOException, JsonProcessingException {
            gen.writeString(writeFecha(value));
        }

    }
}


