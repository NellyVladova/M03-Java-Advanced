import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String mathExpression = null;
        String result = null;
        Socket s = new Socket("localhost", 3005);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(s.getInputStream());
        PrintStream printOutput = new PrintStream(s.getOutputStream());


        System.out.print("Enter mathematical expression: ");
        mathExpression = scanner.nextLine();
        while (!mathExpression.equals("end")) {
            printOutput.println(mathExpression);
            result = scanner2.nextLine();
            System.out.println(result);
            System.out.print("Enter mathematical expression: ");
            mathExpression = scanner.nextLine();
        }

        System.out.println("Bye!");
        s.close();
        scanner.close();
        scanner2.close();

    }
}
