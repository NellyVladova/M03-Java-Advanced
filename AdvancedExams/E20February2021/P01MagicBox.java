package JavaAdvanced.AdvancedExams.E20February2021;

import java.util.*;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstMagicBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagicBoxStack = new ArrayDeque<>();
        List<Integer> claimedItems = new ArrayList<>();
        int claimedItemsSum = 0;


        for (int i = 0; i < input.length; i++) {
            firstMagicBoxQueue.offer(input[i]);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            secondMagicBoxStack.push(input[i]);
        }

        while (!firstMagicBoxQueue.isEmpty() && !secondMagicBoxStack.isEmpty()) {
            int sum = firstMagicBoxQueue.peek() + secondMagicBoxStack.peek();
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstMagicBoxQueue.poll();
                secondMagicBoxStack.pop();
            } else {
                int newQueueElement = secondMagicBoxStack.pop();
                firstMagicBoxQueue.offer(newQueueElement);
            }
        }
        if (firstMagicBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        for (int i = 0; i < claimedItems.size(); i++) {
            claimedItemsSum += claimedItems.get(i);
        }
        if(claimedItemsSum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d\n", claimedItemsSum);
        }else {
            System.out.printf("Poor prey... Value: %d\n", claimedItemsSum);
        }

    }
}
