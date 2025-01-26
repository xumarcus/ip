package zoe.command;

import lombok.NoArgsConstructor;
import zoe.storage.Storage;
import zoe.task.TaskList;
import zoe.ui.Ui;

@NoArgsConstructor
public class ByeCommand implements Command {
    public static final String COMMAND_WORD = "bye";

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) {
        ui.showGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
