package JavaAdvanced.E03SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        Map<String, Integer> resourceAndQuantity = new LinkedHashMap<>();

        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (resourceAndQuantity.containsKey(resource)) {
                resourceAndQuantity.put(resource, resourceAndQuantity.get(resource) + quantity);
            }else {
                resourceAndQuantity.put(resource, quantity);
            }

            resource = scanner.nextLine();
        }
        resourceAndQuantity.forEach((currResource, quantity) -> {
            System.out.println(currResource + " -> " + quantity);
        });
    }
}
