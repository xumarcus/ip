import java.util.ArrayList;
import java.util.ListIterator;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();
    void add(Task task) {
        tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.printf("\t%s\n", task);
        System.out.printf("Now you have %d tasks in your list.\n", tasks.size());
    }
    void remove(Task task) {
        tasks.remove(task);
        System.out.println("Noted. I've removed this task:");
        System.out.printf("\t%s\n", task);
        System.out.printf("Now you have %d tasks in your list.\n", tasks.size());
    }
    void list() {
        for (ListIterator<Task> iter = tasks.listIterator(); iter.hasNext();) {
            System.out.printf("%d. %s\n", iter.nextIndex() + 1, iter.next());
        }
    }
    boolean hasIndex(int index) {
        return 0 <= index && index <= tasks.size();
    }
    Task get(int index) {
        return tasks.get(index);
    }
}
