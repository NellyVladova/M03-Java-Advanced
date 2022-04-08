package JavaAdvanced.AdvancedExams.E14April2021;

import java.util.*;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        List<Integer> removedFlowers = new ArrayList<>();
        int bouquetsCount = 0;

        for (Integer integer : input) {
            tulipsStack.push(integer);
        }
        input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (Integer integer : input) {
            daffodilsQueue.offer(integer);
        }

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int sum = daffodilsQueue.peek() + tulipsStack.peek();
            if (sum == 15) {
                bouquetsCount++;
                daffodilsQueue.poll();
                tulipsStack.pop();
            } else if (sum >= 15) {
                int newTulips = tulipsStack.pop() - 2;
                tulipsStack.push(newTulips);
            } else {
                removedFlowers.add(sum);
                daffodilsQueue.poll();
                tulipsStack.pop();
            }
        }
        int totalFlowers = 0;
        for (Integer flower : removedFlowers){
            totalFlowers+=flower;
        }
        totalFlowers/=15;
        bouquetsCount+=totalFlowers;
        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.\n", 5 - bouquetsCount);
        }

    }
}
