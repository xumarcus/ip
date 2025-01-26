package zoe.task;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks that extends the ArrayList class.
 * Provides additional constructors to initialize the list with
 * existing task data.
 */
@NoArgsConstructor
public class TaskList extends ArrayList<Task> {
    public TaskList(List<Task> list) {
        super(list);
    }
}
