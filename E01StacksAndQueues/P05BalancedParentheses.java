package JavaAdvanced.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currBracket = input.charAt(i);
            if (currBracket == '{' || currBracket == '[' || currBracket == '(') {
                openBrackets.push(currBracket);
            } else if (currBracket == '}' || currBracket == ']' || currBracket == ')') {
                if (openBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop();
                if (lastOpenBracket == '{' && currBracket == '}') {
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && currBracket == ']') {
                    areBalanced = true;
                } else if (lastOpenBracket == '(' && currBracket == ')') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if(areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
