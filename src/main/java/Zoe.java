import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Zoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Zoe\nWhat can I do for you?\n");

        ArrayList<String> tasks = new ArrayList<>();
        io:
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "bye":
                    break io;
                case "list":
                    for (ListIterator<String> iter = tasks.listIterator(); iter.hasNext();) {
                        System.out.printf("%d. %s\n", iter.nextIndex() + 1, iter.next());
                    }
                    break;
                default:
                    tasks.add(command);
                    System.out.printf("added: %s\n", command);
                    break;
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
