package zoe.adapters.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import zoe.task.Task;

import java.lang.reflect.Type;
import java.time.LocalDate;

// https://www.baeldung.com/gson-polymorphism
@SuppressWarnings("unchecked")
public class TaskTypeAdapter implements JsonSerializer<Task>, JsonDeserializer<Task> {
    private final static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    @Override
    public JsonElement serialize(Task task, Type type, JsonSerializationContext context) {
        JsonElement jsonElement = gson.toJsonTree(task);
        jsonElement.getAsJsonObject().addProperty("type", task.getClass().getSimpleName());
        return jsonElement;
    }

    @Override
    public Task deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String typeName = jsonObject.get("type").getAsString();
        try {
            Class<? extends Task> cls = (Class<? extends Task>) Class.forName(typeName);
            return gson.fromJson(jsonElement, cls);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }
}
