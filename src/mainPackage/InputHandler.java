package mainPackage;
import java.util.Scanner;

public abstract class InputHandler {
    private Scanner scanner;
    public InputHandler() {
        scanner = new Scanner(System.in);
    }
    protected int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid Integer ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
