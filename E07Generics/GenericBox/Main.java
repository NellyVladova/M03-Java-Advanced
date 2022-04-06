package JavaAdvanced.E07Generics.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //Exercise 1
        /*Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }
        System.out.println(box);*/

        //Exercise 2
        /*Box<Integer> integerBox = new Box<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            integerBox.add(number);
        }
        System.out.println(integerBox);*/

        //Exercise 3
        /*Box<String> box = new Box<String>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        box.swap(firstIndex, secondIndex);

        System.out.println(box);*/

        //Exercise 4
        /*Box<Integer> box = new Box<Integer>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        box.swap(firstIndex, secondIndex);

        System.out.println(box);*/

        //Exercise 5
        /*Box<String> box = new Box<String>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }

        String element = scanner.nextLine();
        System.out.println(box.countGreaterThan(element));*/

        //Exercise 6
        Box<Double> box = new Box<Double>();
        for (int i = 0; i < n; i++) {
            double text = Double.parseDouble(scanner.nextLine());
            box.add(text);
        }

        double element = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterThan(element));

    }
}

