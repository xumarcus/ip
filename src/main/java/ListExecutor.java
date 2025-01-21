public class ListExecutor implements Executor {
    public ListExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) {
        if (command.equals("list")) {
            taskList.list();
            return true;
        }
        return false;
    }
}
