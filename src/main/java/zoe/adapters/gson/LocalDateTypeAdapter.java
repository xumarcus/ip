package zoe.adapters.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// https://mkyong.com/java/gson-supports-java-8-date-time-types/#default-gson-does-not-support-java-8-date-time-type
public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDate.format(formatter));
    }

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString(), formatter);
    }
}
