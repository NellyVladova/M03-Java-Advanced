package JavaAdvanced.L03SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        for (int round = 0; round < 50; round++) {
            if(firstPlayerCards.isEmpty()){
                System.out.println("Second player win!");
                return;
            } else if (secondPlayerCards.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            int currCardPlayer1 = firstPlayerCards.iterator().next();
            int currCardPlayer2 = secondPlayerCards.iterator().next();

            firstPlayerCards.remove(currCardPlayer1);
            secondPlayerCards.remove(currCardPlayer2);

            if(currCardPlayer1 > currCardPlayer2){
                //first player win all cards
                firstPlayerCards.add(currCardPlayer1);
                firstPlayerCards.add(currCardPlayer2);
            }else if(currCardPlayer1 < currCardPlayer2){
                //second player win all the cards
                secondPlayerCards.add(currCardPlayer1);
                secondPlayerCards.add(currCardPlayer2);
            }else {
                // back the cards up to the quires
                firstPlayerCards.add(currCardPlayer1);
                secondPlayerCards.add(currCardPlayer2);
            }
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        }else if(firstPlayerCards.size() < secondPlayerCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}
