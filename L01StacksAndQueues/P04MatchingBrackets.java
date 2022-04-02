package JavaAdvanced.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> expression = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currSymbol = input.charAt(i);
            if(currSymbol == '('){
                expression.push(i);
            }else if(currSymbol == ')'){
                String contents = input.substring(expression.pop(), i + 1);
                System.out.println(contents);
            }
        }
    }
}
