package JavaAdvanced.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> mathExpression = new ArrayDeque<>();
//        for (int i = 0; i < input.length; i++) {
//            mathExpression.add(input[i]);
//        }
        mathExpression.addAll(Arrays.asList(input));
        int firstNum = 0;
        String result = "";
        int secondNum = 0;
        while (mathExpression.size() >= 3){
             firstNum = Integer.parseInt(mathExpression.pop());
            String operator = mathExpression.pop();
            secondNum = Integer.parseInt(mathExpression.pop());
            if(operator.equals("+")){
                result = String.valueOf(firstNum + secondNum);
                mathExpression.push(result);
            }else if(operator.equals("-")){
                result = String.valueOf(firstNum - secondNum);
                mathExpression.push(result);
            }
        }
        System.out.println(mathExpression.peek());
    }
}
