package zoe.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import zoe.ZoeIOException;
import zoe.adapters.gson.TaskTypeAdapter;
import zoe.task.Task;
import zoe.task.TaskList;

import java.io.*;
import java.util.List;

@AllArgsConstructor
public class Storage {
    // Call registerTypeAdapter(LocalDate.class, new zoe.adapters.gson.LocalDateTypeAdapter()) in zoe.adapters.gson.TaskTypeAdapter!
    private final static Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Task.class, new TaskTypeAdapter())
            .create();
    private final String path;

    public void save(TaskList taskList) throws ZoeIOException {
        File file = new File(path);

        //noinspection ResultOfMethodCallIgnored
        file.getParentFile().mkdirs();

        try (Writer writer = new FileWriter(file)) {
            gson.toJson(taskList, writer);
        } catch (JsonIOException | IOException e) {
            throw new ZoeIOException("Fail to write to file: " + e.getMessage());
        }
    }

    public List<Task> load() throws ZoeIOException {
        try (Reader reader = new FileReader(path)) {
            List<Task> tasks = gson.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (tasks == null) throw new ZoeIOException("File is empty");
            return tasks;
        } catch (FileNotFoundException e) {
            throw new ZoeIOException("File not found");
        } catch (IOException e) {
            throw new ZoeIOException("Fail to read from file");
        } catch (JsonParseException e) {
            throw new ZoeIOException("Fail to parse file");
        }
    }
}
