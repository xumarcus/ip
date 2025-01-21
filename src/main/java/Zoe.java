import java.util.Scanner;

public class Zoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Zoe\nWhat can I do for you?\n");
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) break;
            System.out.println(command);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
