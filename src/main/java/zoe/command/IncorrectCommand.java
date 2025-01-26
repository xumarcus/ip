package zoe.command;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import zoe.ZoeException;
import zoe.storage.Storage;
import zoe.task.TaskList;
import zoe.ui.Ui;

@NoArgsConstructor
@AllArgsConstructor
public class IncorrectCommand implements Command {
    private String message = "OOPS!!! I'm sorry, but I don't know what that means :-(";

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException {
        ui.showMessage(message);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
