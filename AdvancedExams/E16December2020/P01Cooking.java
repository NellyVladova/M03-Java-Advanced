package JavaAdvanced.AdvancedExams.E16December2020;

import java.util.*;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        int breadCount = 0;
        int cakeCount = 0;
        int pieCount = 0;
        int pastryCount = 0;
        Map<String, Integer> allFood = new TreeMap<>();
        for (int i = 0; i < input.length; i++) {
            liquidsQueue.offer(input[i]);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            ingredientsStack.push(input[i]);
        }

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            if(sum == 25){
                breadCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 50) {
                cakeCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            }else if(sum == 75){
                pastryCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 100) {
                pieCount++;
                liquidsQueue.poll();
                ingredientsStack.pop();
            }else {
                liquidsQueue.poll();
                int newIngredientAmount = ingredientsStack.pop() + 3;
                ingredientsStack.push(newIngredientAmount);
            }
        }
        allFood.put("Bread", breadCount);
        allFood.put("Cake", cakeCount);
        allFood.put("Pastry", pastryCount);
        allFood.put("Fruit Pie", pieCount);

        if (breadCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >= 1){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if(liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            System.out.println("Liquids left: " + String.join(", ", liquidsQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        if(ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            System.out.println("Ingredients left: " + String.join(", ", ingredientsStack.toString().replaceAll("[\\[\\]]", "")));
        }
        allFood.forEach((key, value) -> {
            System.out.printf("%s: %d\n", key, value);
        });
    }
}
