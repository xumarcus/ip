package zoe.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zoe.ZoeException;
import zoe.storage.Storage;
import zoe.task.Task;
import zoe.task.TaskList;
import zoe.ui.Ui;

@Getter
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
