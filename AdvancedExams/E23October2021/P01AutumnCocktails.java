package JavaAdvanced.AdvancedExams.E23October2021;

import java.util.*;

public class P01AutumnCocktails {
    public static final String PEAR_SOUR = "Pear Sour";
    public static final String THE_HARVEST = "The Harvest";
    public static final String APPLE_HINNY = "Apple Hinny";
    public static final String HIGH_FASHION = "High Fashion";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredientQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Map<String, Integer> cocktailsMap = new TreeMap<>();
        int pearSourCount = 0;
        int theHarvestCount = 0;
        int appleHinnyCount = 0;
        int highFashionCount = 0;

        cocktailsMap.put(PEAR_SOUR, 0);
        cocktailsMap.put(THE_HARVEST, 0);
        cocktailsMap.put(APPLE_HINNY, 0);
        cocktailsMap.put(HIGH_FASHION, 0);

        for (Integer integer : input) {
            ingredientQueue.offer(integer);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer integer : input) {
            freshnessStack.push(integer);
        }

        while (!ingredientQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int firstIngredient = ingredientQueue.poll();

            if (firstIngredient == 0) {
                continue;
            }
            int lastFreshness = freshnessStack.pop();
            int multiplyResult = firstIngredient * lastFreshness;

            switch (multiplyResult) {
                case 150:
                    pearSourCount++;
                    cocktailsMap.put(PEAR_SOUR, pearSourCount);
                    break;
                case 250:
                    theHarvestCount++;
                    cocktailsMap.put(THE_HARVEST, theHarvestCount);
                    break;
                case 300:
                    appleHinnyCount++;
                    cocktailsMap.put(APPLE_HINNY, appleHinnyCount);
                    break;
                case 400:
                    highFashionCount++;
                    cocktailsMap.put(HIGH_FASHION, highFashionCount);
                    break;
                default:
                    int newIngredientValue = firstIngredient + 5;
                    ingredientQueue.offer(newIngredientValue);
                    break;
            }
        }
        if (pearSourCount > 0 && theHarvestCount > 0 && appleHinnyCount > 0 && highFashionCount > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientQueue) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum);
        }
        cocktailsMap.forEach((key, value) -> {
            if(value > 0) {
                System.out.println(" # " + key + " --> " + value);
            }
        });
    }
}
