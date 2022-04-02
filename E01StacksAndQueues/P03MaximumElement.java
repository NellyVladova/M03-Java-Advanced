package JavaAdvanced.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String firstCom = commands[0];
            switch (firstCom) {
                case "1":
                    int number = Integer.parseInt(commands[1]);
                    numberStack.push(number);
                    break;
                case "2":
                    numberStack.pop();
                    break;
                case "3":
                    if (numberStack.size() > 0) {
                        System.out.println(Collections.max(numberStack));
                    }
                    break;
            }
        }
    }
}
