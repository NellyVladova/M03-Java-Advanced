package JavaAdvanced.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        if(num == 0){
            System.out.println("0");
        }else {
            while (num != 0) {
                numStack.push(num % 2);
                num /= 2;
            }
            int stackSize = numStack.size();
            for (int i = 0; i < stackSize; i++) {
                System.out.print(numStack.pop());
            }
        }
    }
}
