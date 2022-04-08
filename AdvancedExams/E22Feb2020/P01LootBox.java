package JavaAdvanced.AdvancedExams.E22Feb2020;

import java.util.*;

public class P01LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> lootBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> lootBoxStack = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();
        for (int j : input) {
            //queue
            lootBoxQueue.offer(j);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int j : input) {
            //stack
            lootBoxStack.push(j);
        }
        while (!lootBoxQueue.isEmpty() && !lootBoxStack.isEmpty()){
            int sum = lootBoxQueue.peek() + lootBoxStack.peek();
            if(sum % 2 == 0){
                resultList.add(sum);
                lootBoxQueue.poll();
                lootBoxStack.pop();
            }else {
                int toRemove = lootBoxStack.pop();
                lootBoxQueue.offer(toRemove);
            }
        }
        if(lootBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }else if(lootBoxStack.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        int totalResult = 0;
        for (int number : resultList){
            totalResult+=number;
        }
        if(totalResult >= 100){
            System.out.printf("Your loot was epic! Value: %d\n", totalResult);
        }else {
            System.out.printf("Your loot was poor... Value: %d\n", totalResult);
        }
    }
}
