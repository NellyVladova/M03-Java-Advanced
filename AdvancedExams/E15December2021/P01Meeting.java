package JavaAdvanced.AdvancedExams.E15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        int matchesCount = 0;

        for (Integer integer : input) {
            maleStack.push(integer);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (Integer integer : input) {
            femaleQueue.offer(integer);
        }

        while (!femaleQueue.isEmpty() && !maleStack.isEmpty()) {
            int female = femaleQueue.peek();
            int male = maleStack.peek();
            if (female <= 0) {
                femaleQueue.poll();
                continue;
            }
            if (male <= 0) {
                maleStack.pop();
                continue;
            }
            if (female % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }
            if (female == male) {
                matchesCount++;
                femaleQueue.poll();
                maleStack.pop();
            } else {
                femaleQueue.poll();
                int newMaleAmount = maleStack.pop() - 2;
                maleStack.push(newMaleAmount);
            }

        }
        System.out.println("Matches: " + matchesCount);
        if(maleStack.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.println("Males left: " + String.join(", ", maleStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if(femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.println("Females left: " + String.join(", ", femaleQueue.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
