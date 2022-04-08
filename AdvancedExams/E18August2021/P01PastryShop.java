package JavaAdvanced.AdvancedExams.E18August2021;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        int biscuitsCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;
        for (Integer integer : input){
            liquidsQueue.offer(integer);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer integer : input){
            ingredientsStack.push(integer);
        }
        while (!ingredientsStack.isEmpty() && !liquidsQueue.isEmpty()){
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            switch (sum){
                case 25:
                    biscuitsCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 50:
                    cakeCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75:
                    pastryCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100:
                    pieCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    int newIngredientAmount = ingredientsStack.pop() + 3;
                    ingredientsStack.push(newIngredientAmount);
                    break;
            }
        }
        if(biscuitsCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >= 1){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
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
        System.out.println("Biscuit: " + biscuitsCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Pie: " + pieCount);
        System.out.println("Pastry: " + pastryCount);
    }
}
