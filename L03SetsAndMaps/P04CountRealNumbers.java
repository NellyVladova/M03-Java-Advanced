package JavaAdvanced.L03SetsAndMaps;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> occurrencesNumbers = new LinkedHashMap<>();
        double[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < array.length; i++) {
            if(occurrencesNumbers.containsKey(array[i])){

                occurrencesNumbers.put(array[i], occurrencesNumbers.get(array[i]) + 1);
            }else {
                occurrencesNumbers.put(array[i], 1);
            }
        }
        for(Double num : occurrencesNumbers.keySet()){
            System.out.printf("%.1f -> %d\n", num, occurrencesNumbers.get(num));
        }
    }
}
