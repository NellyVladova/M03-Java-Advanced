package JavaAdvanced.AdvancedExams.E28June2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        int daturaBombCount = 0;
        int cherryBombCount = 0;
        int smokeDecoyBombCount = 0;
        for (int j : input) {
            bombEffectsQueue.offer(j);
        }
        input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int j : input) {
            bombCasingStack.push(j);
        }

        while (!bombEffectsQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            int sum = bombEffectsQueue.peek() + bombCasingStack.peek();
            if (sum == 40) {
                daturaBombCount++;
                bombEffectsQueue.poll();
                bombCasingStack.pop();
            } else if (sum == 60) {
                cherryBombCount++;
                bombEffectsQueue.poll();
                bombCasingStack.pop();
            } else if (sum == 120) {
                smokeDecoyBombCount++;
                bombEffectsQueue.poll();
                bombCasingStack.pop();
            } else {
                int removed = bombCasingStack.pop() - 5;
                bombCasingStack.push(removed);
            }
            if (daturaBombCount >= 3 && cherryBombCount >= 3 && smokeDecoyBombCount >= 3) {
                break;
            }
        }
        if (daturaBombCount >= 3 && cherryBombCount >= 3 && smokeDecoyBombCount >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: " + String.join(", ", bombEffectsQueue.toString().replaceAll("[\\[\\]]", "")) + " ");
            System.out.println();
        }
        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: " + String.join(", ", bombCasingStack.toString().replaceAll("[\\[\\]]", "")) + " ");
            System.out.println();
        }
        System.out.println("Cherry Bombs: " + cherryBombCount);
        System.out.println("Datura Bombs: " + daturaBombCount);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombCount);
    }
}
