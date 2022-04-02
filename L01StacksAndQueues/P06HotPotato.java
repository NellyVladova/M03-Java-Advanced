package JavaAdvanced.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenName = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (int i = 0; i < childrenName.length; i++) {
           childrenQueue.offer(childrenName[i]);
        }
        while (childrenQueue.size() != 1){
            for (int i = 1; i < number; i++) {
                String currChild = childrenQueue.poll();
                childrenQueue.offer(currChild);
            }
            System.out.println("Removed " + childrenQueue.poll());
        }
        System.out.printf("Last is %s", childrenQueue.peek());
    }
}
