package JavaAdvanced.L07Generics.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integer = ArrayCreator.create(Integer.class, 10, 0);

        System.out.println(strings.length);
        System.out.println(integer.length);
    }
}
