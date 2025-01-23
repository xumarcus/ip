import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoCommand implements Command {
    public static final String COMMAND_WORD = "todo";
    private final String taskName;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        Task task = new Todo(taskName);
        taskList.add(task);
        storage.save(taskList);
        ui.showAddedTask(taskList, task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
