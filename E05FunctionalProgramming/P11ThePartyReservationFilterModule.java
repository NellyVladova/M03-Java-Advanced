package JavaAdvanced.E05FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 40/100???
        ArrayList<String> invitedPeople = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
        String input = scanner.nextLine();
        HashMap<String, Predicate> predicates = new HashMap<>();


        while (!input.equals("Print")) {
            String[] inputParts = input.split(";");
            String command = inputParts[0];
            String filterType = inputParts[1];
            String filterParameter = inputParts[2];

            String name = filterType + filterParameter;

            if (command.equals("Add filter")){
                Predicate<String> predicate = null;

                if (filterType.equals("Starts with")) {
                    predicate = x -> x.startsWith(filterParameter);
                    predicates.putIfAbsent(name, predicate);
                } else if (filterType.equals("Ends with")) {
                    predicate = x -> x.endsWith(filterParameter);
                    predicates.putIfAbsent(name, predicate);
                }else if(filterType.equals("Length")){
                    predicate = x -> x.length() == Integer.parseInt(filterParameter);
                    predicates.putIfAbsent(name, predicate);
                }else {

                    predicate = x -> x.contains(filterType);
                    predicates.putIfAbsent(name, predicate);
                }
            }else {
                predicates.remove(name);
            }

            input = scanner.nextLine();
        }

        for (String guest : invitedPeople){
            boolean isGoing = true;

            for (String entry : predicates.keySet()){
                if (predicates.get(entry).test(guest)) {
                    isGoing = false;
                    break;
                }
            }
            if(isGoing){
                System.out.print(guest + " ");
            }
        }

    }
}
