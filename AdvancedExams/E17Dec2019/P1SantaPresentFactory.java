package JavaAdvanced.AdvancedExams.E17Dec2019;

import java.util.*;

public class P1SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materials = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] magicLevel = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();
        Map<String, Integer> presentMap = new TreeMap<>();
        boolean containsPresent = false;
        String present;
        for (int material : materials) {
            materialsStack.push(material);
        }
        for (int magic : magicLevel) {
            magicLevelQueue.offer(magic);
        }

        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int lastMaterial = materialsStack.peek();
            int firstMagicLevel = magicLevelQueue.peek();
            int multiplyResult = lastMaterial * firstMagicLevel;
            if (multiplyResult < 0) {
                int sum = lastMaterial + firstMagicLevel;
                materialsStack.pop();
                magicLevelQueue.poll();
                materialsStack.push(sum);
            } else if (multiplyResult > 0 && (multiplyResult != 150 && multiplyResult != 250 && multiplyResult != 300 && multiplyResult != 400)) {
                magicLevelQueue.poll();
                int newMaterial = materialsStack.pop() + 15;
                materialsStack.push(newMaterial);
            } else if (firstMagicLevel == 0 || lastMaterial == 0) {
                if (lastMaterial == 0) {
                    materialsStack.pop();
                }
                if (firstMagicLevel == 0) {
                    magicLevelQueue.poll();
                }
            } else if (multiplyResult == 150) {
                present = "Doll";
                presentMap.putIfAbsent(present, 0);
                presentMap.put(present, presentMap.get(present) + 1);
                materialsStack.pop();
                magicLevelQueue.poll();
            } else if (multiplyResult == 250) {
                present = "Wooden train";
                presentMap.putIfAbsent(present, 0);
                presentMap.put(present, presentMap.get(present) + 1);
                materialsStack.pop();
                magicLevelQueue.poll();
            } else if (multiplyResult == 300) {
                present = "Teddy bear";
                presentMap.putIfAbsent(present, 0);
                presentMap.put(present, presentMap.get(present) + 1);
                materialsStack.pop();
                magicLevelQueue.poll();
            } else {
                present = "Bicycle";
                presentMap.putIfAbsent(present, 0);
                presentMap.put(present, presentMap.get(present) + 1);
                materialsStack.pop();
                magicLevelQueue.poll();
            }
        }
        if (presentMap.containsKey("Doll")) {
            if (presentMap.containsKey("Wooden train")) {
                if (presentMap.get("Doll") > 0 && presentMap.get("Wooden train") > 0) {
                    containsPresent = true;
                }
            }
        } else if (presentMap.containsKey("Teddy bear")) {
            if (presentMap.containsKey("Bicycle")) {
                if (presentMap.get("Teddy bear") > 0 && presentMap.get("Bicycle") > 0) {
                    containsPresent = true;
                }
            }
        }
        if (containsPresent) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsStack.isEmpty()) {
            System.out.println("Materials left: " + String.join(", ", materialsStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!magicLevelQueue.isEmpty()) {
            System.out.println("Magic left: " + String.join(", ", magicLevelQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        presentMap.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}
