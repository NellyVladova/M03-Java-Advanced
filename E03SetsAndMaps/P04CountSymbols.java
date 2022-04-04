package JavaAdvanced.E03SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (countSymbols.containsKey(currentSymbol)) {
                countSymbols.put(currentSymbol, countSymbols.get(currentSymbol) + 1);
            }else {
                countSymbols.put(currentSymbol, 1);
            }
        }
        countSymbols.forEach((symbol, count) -> {
            System.out.printf("%c: %d time/s\n", symbol, count);
        });
    }
}
