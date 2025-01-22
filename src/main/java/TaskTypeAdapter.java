import com.google.gson.*;

import java.lang.reflect.Type;

// https://www.baeldung.com/gson-polymorphism
@SuppressWarnings("unchecked")
public class TaskTypeAdapter implements JsonSerializer<Task>, JsonDeserializer<Task> {
    @Override
    public JsonElement serialize(Task task, Type type, JsonSerializationContext context) {
        JsonElement jsonElement = new Gson().toJsonTree(task);
        jsonElement.getAsJsonObject().addProperty("type", task.getClass().getSimpleName());
        return jsonElement;
    }
    @Override
    public Task deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String typeName = jsonObject.get("type").getAsString();
        try {
            Class<? extends Task> cls = (Class<? extends Task>) Class.forName(typeName);
            return new Gson().fromJson(jsonElement, cls);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }
}
