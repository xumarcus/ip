package zoe.command;

import zoe.ZoeException;
import zoe.storage.Storage;
import zoe.task.TaskList;
import zoe.ui.Ui;

public interface Command {
    void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException;

    boolean isExit();
}
