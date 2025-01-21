public class DefaultExecutor implements Executor {
    public DefaultExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) throws ZoeException {
        throw new ZoeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
