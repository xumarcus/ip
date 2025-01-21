import java.util.List;
import java.util.ListIterator;

public class ListExecutor implements Executor {
    public ListExecutor() {
    }

    @Override
    public boolean run(String command, List<Task> tasks) {
        if (command.equals("list")) {
            for (ListIterator<Task> iter = tasks.listIterator(); iter.hasNext();) {
                System.out.printf("%d. %s\n", iter.nextIndex() + 1, iter.next());
            }
            return true;
        }
        return false;
    }
}
