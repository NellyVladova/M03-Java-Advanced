package JavaAdvanced.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenName = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        int counter = 0;

        for (int i = 0; i < childrenName.length; i++) {
            childrenQueue.offer(childrenName[i]);
        }
        while (childrenQueue.size() != 1) {
            counter++;
            for (int i = 1; i < number; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }
            if (isPrime(counter)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
        }
        System.out.printf("Last is %s\n", childrenQueue.peek());
    }

    public static boolean isPrime(int counter) {
        if (counter == 1) {
            return false;
        } else if (counter == 2) {
            return true;
        }
        for (int i = 2; i <= counter / 2; i++) {
            if (counter % i == 0) {
                return false;
            }
        }
        return true;
    }

}