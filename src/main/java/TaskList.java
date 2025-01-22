import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TaskList {
    @AllArgsConstructor
    public static class TaskResource implements AutoCloseable {
        private final TaskList taskList;
        @Getter private final Task task;

        @Override
        public void close() {
            taskList.writeWithErrorLogging();
        }
    }

    private final static Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Task.class, new TaskTypeAdapter()).create();
    private final String PATH = "data/zoe.txt";
    private List<Task> tasks;

    public TaskList() {
        try (Reader reader = new FileReader(PATH)) {
            tasks = gson.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (tasks == null) tasks = new ArrayList<>();
        } catch (JsonIOException | IOException e) {
            tasks = new ArrayList<>();
        }
    }

    void add(Task task) {
        tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.printf("\t%s\n", task.getFullDescription());
        System.out.printf("Now you have %d tasks in your list.\n", tasks.size());
        writeWithErrorLogging();
    }

    void remove(int index) {
        if (hasIndex(index)) {
            Task task = tasks.remove(index);
            System.out.println("Noted. I've removed this task:");
            System.out.printf("\t%s\n", task.getFullDescription());
            System.out.printf("Now you have %d tasks in your list.\n", tasks.size());
            writeWithErrorLogging();
        }
    }

    void write() throws IOException {
        File file = new File(PATH);

        //noinspection ResultOfMethodCallIgnored
        file.getParentFile().mkdirs();

        try (Writer writer = new FileWriter(PATH)) {
            gson.toJson(tasks, writer);
        } catch (JsonIOException e) {
            throw new IOException(e);
        }
    }
    
    void writeWithErrorLogging() {
        try {
            write();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    void list() {
        for (ListIterator<Task> iter = tasks.listIterator(); iter.hasNext();) {
            System.out.printf("%d. %s\n", iter.nextIndex() + 1, iter.next().getFullDescription());
        }
    }

    boolean hasIndex(int index) {
        return 0 <= index && index <= tasks.size();
    }

    TaskResource with(int index) {
        if (hasIndex(index)) {
            return new TaskResource(this, tasks.get(index));
        }
        return null;
    }
}
