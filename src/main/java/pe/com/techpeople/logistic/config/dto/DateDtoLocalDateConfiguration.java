package pe.com.techpeople.logistic.config.dto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateDtoLocalDateConfiguration {
	//yyyy-MM-dd HH:mm
	private static final DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static LocalDateTime parseFecha(String fecha) {
    	
    	System.out.println(fecha);
    	System.out.println(fecha.substring(0,19).replace("T", " "));
    	
        return LocalDateTime.parse(fecha.substring(0,19).replace("T", " "), fechaFormatter);
    }

    private static String writeFecha(LocalDateTime fecha) {
        return fechaFormatter.format(fecha);
    }

    public static class FechaJacksonDeserializer extends StdDeserializer<LocalDateTime> {

        private static final long serialVersionUID = -3248031647654176348L;

        public FechaJacksonDeserializer() {
            this(null);
        }

        public FechaJacksonDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            String date = p.getText();
            return parseFecha(date);
        }

    }

    public static class FechaJacksonSerializer extends StdSerializer<LocalDateTime> {

        private static final long serialVersionUID = -4994523788442753333L;

        public FechaJacksonSerializer() {
            this(null);
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        public FechaJacksonSerializer(Class t) {
            super(t);
        }

        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider arg2)
                throws IOException, JsonProcessingException {
            gen.writeString(writeFecha(value));
        }

    }


}
