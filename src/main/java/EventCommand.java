import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class EventCommand implements Command {
    public static final String COMMAND_WORD = "event";
    private final String taskName;
    private final LocalDate from;
    private final LocalDate to;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        Task task = new Event(taskName, from, to);
        taskList.add(task);
        storage.save(taskList);
        ui.showAddedTask(taskList, task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
