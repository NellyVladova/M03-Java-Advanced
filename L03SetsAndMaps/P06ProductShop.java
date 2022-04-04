package JavaAdvanced.L03SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> shopsProductList = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] inputParts = input.split(", ");
            String shop = inputParts[0];
            String product = inputParts[1];
            double price = Double.parseDouble(inputParts[2]);

            if(shopsProductList.containsKey(shop)){
                Map<String, Double> newProductsMap = new LinkedHashMap<>(shopsProductList.get(shop));
                newProductsMap.put(product, price);
                shopsProductList.put(shop, newProductsMap);
            }else {
                Map<String, Double> newToPut = new LinkedHashMap<>();
                newToPut.put(product, price);
                shopsProductList.put(shop, newToPut);
            }
            input = scanner.nextLine();
        }

        shopsProductList.forEach((shop, product) -> {
            System.out.println(shop + "->");
            product.forEach((productName, price) ->{
                System.out.printf("Product: %s, Price: %.1f\n", productName, price);
            });
        });
        System.out.println();
    }
}
