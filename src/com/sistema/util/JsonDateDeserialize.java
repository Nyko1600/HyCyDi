package com.sistema.util;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.stereotype.Component;
/**
 * Used to serialize Java.util.Date, which is not a common JSON
 * type, so we have to create a custom deserialize method.
**/
@Component
public class JsonDateDeserialize extends JsonDeserializer<Timestamp>{
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		@Override
		public Timestamp deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
		    
		    String dt = jp.getText().trim();
		    
		    if (dt == null || dt.trim().length() == 0) {
		        return null;
		    }
		    Timestamp timestamp = null;
		    try {
		        timestamp = new Timestamp(dateFormat.parse(dt).getTime());
		    } catch (ParseException e) {
		        throw new IOException(e);
		    }
		
		    return timestamp;
		}
}
