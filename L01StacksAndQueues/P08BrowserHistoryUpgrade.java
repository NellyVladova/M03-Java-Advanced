package JavaAdvanced.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistoryStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String toForward = browserHistoryStack.pop();
                    forwardHistory.push(toForward);
                    System.out.println(browserHistoryStack.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.size() < 1){
                    System.out.println("no next URLs");
                }else {
                    String toBack = forwardHistory.peek();
                    browserHistoryStack.push(toBack);
                    System.out.println(forwardHistory.pop());
                }
            } else {
                browserHistoryStack.push(input);
                forwardHistory.clear();
                System.out.println(browserHistoryStack.peek());
            }
            input = scanner.nextLine();
        }
    }
}
