package JavaAdvanced.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> reverseNumbers = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            reverseNumbers.push(input[i]);
        }
        for (String str : reverseNumbers){
            System.out.print(str + " ");
        }
    }
}
