import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarkCommand implements Command {
    public static final String COMMAND_WORD = "mark";
    private final int index;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        Task task = taskList.get(index);
        task.markAsDone();
        storage.save(taskList);
        ui.showMarkedTask(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
