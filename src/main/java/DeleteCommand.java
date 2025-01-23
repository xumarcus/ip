import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCommand implements Command {
    public static final String COMMAND_WORD = "delete";
    private final int index;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        Task task = taskList.remove(index);
        storage.save(taskList);
        ui.showRemovedTask(taskList, task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
