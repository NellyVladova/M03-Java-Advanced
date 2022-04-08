package JavaAdvanced.AdvancedExams.E19August2020;

import java.util.*;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        int wreathsCount = 0;
        int storedFlowers = 0;

        for (int i = 0; i < input.length; i++) {
            rosesQueue.offer(input[i]);
        }
        input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            liliesStack.push(input[i]);
        }

        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
            int sum = rosesQueue.peek() + liliesStack.peek();
            if (sum == 15) {
                wreathsCount++;
                rosesQueue.poll();
                liliesStack.pop();
            } else if (sum > 15) {
                int lilies = liliesStack.pop() - 2;
                liliesStack.push(lilies);
            } else {
                storedFlowers += sum;
                rosesQueue.poll();
                liliesStack.pop();
            }
        }
        wreathsCount += storedFlowers / 15;

        if(wreathsCount >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", wreathsCount);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", 5 - wreathsCount);
        }
    }
}
