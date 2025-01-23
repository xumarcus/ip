import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class TaskList extends ArrayList<Task> {
    public TaskList(List<Task> list) {
        super(list);
    }
}
