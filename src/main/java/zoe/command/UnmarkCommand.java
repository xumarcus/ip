package zoe.command;

import lombok.AllArgsConstructor;
import zoe.ZoeException;
import zoe.storage.Storage;
import zoe.task.Task;
import zoe.task.TaskList;
import zoe.ui.Ui;

@AllArgsConstructor
public class UnmarkCommand implements Command {
    public static final String COMMAND_WORD = "unmark";
    private final int index;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        Task task = taskList.get(index);
        task.markAsUndone();
        storage.save(taskList);
        ui.showUnmarkedTask(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
