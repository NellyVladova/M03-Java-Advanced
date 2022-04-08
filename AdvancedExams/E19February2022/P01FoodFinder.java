package JavaAdvanced.AdvancedExams.E19February2022;

import java.util.*;

public class P01FoodFinder {
    private static final String PEAR = "pear";
    private static final String FLOUR = "flour";
    private static final String PORK = "pork";
    private static final String OLIVE = "olive";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        List<String> productList = new ArrayList<>();
        HashSet<String> pearSet = new HashSet<>();
        HashSet<String> flourSet = new HashSet<>();
        HashSet<String> porkSet = new HashSet<>();
        HashSet<String> oliveSet = new HashSet<>();

        for (String vowel : input) {
            vowelsQueue.offer(vowel);
        }
        input = scanner.nextLine().split("\\s+");
        for (String consonant : input) {
            consonantsStack.push(consonant);
        }

        while (!vowelsQueue.isEmpty() && !consonantsStack.isEmpty()) {
            String firstVowel = vowelsQueue.peek();
            String lastConsonant = consonantsStack.peek();

            if (PEAR.contains(firstVowel)) {
                pearSet.add(firstVowel);
            }
            if (FLOUR.contains(firstVowel)) {
                flourSet.add(firstVowel);
            }
            if (PORK.contains(firstVowel)) {
                porkSet.add(firstVowel);
            }
            if (OLIVE.contains(firstVowel)) {
                oliveSet.add(firstVowel);
            }
            vowelsQueue.poll();
            vowelsQueue.offer(firstVowel);

            if (PEAR.contains(lastConsonant)) {
                pearSet.add(lastConsonant);
            }
            if (FLOUR.contains(lastConsonant)) {
                flourSet.add(lastConsonant);
            }
            if (PORK.contains(lastConsonant)) {
                porkSet.add(lastConsonant);
            }
            if (OLIVE.contains(lastConsonant)) {
                oliveSet.add(lastConsonant);
            }
            consonantsStack.pop();
        }
        if (pearSet.size() == 4) {
            productList.add(PEAR);
        }
        if (flourSet.size() == 5) {
            productList.add(FLOUR);
        }
        if (porkSet.size() == 4) {
            productList.add(PORK);
        }
        if (oliveSet.size() == 5) {
            productList.add(OLIVE);
        }

        System.out.println("Words found: " + productList.size());
        productList.forEach(System.out::println);
    }
}

