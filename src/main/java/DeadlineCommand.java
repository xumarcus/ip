import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class DeadlineCommand implements Command {
    public static final String COMMAND_WORD = "deadline";
    private final String taskName;
    private final LocalDate by;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        Task task = new Deadline(taskName, by);
        taskList.add(task);
        storage.save(taskList);
        ui.showAddedTask(taskList, task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
