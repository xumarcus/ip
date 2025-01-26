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
