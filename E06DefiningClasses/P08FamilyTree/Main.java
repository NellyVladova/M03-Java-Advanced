package JavaAdvanced.E06DefiningClasses.P08FamilyTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameOrDate = scanner.nextLine().split("\\s+");
        if (nameOrDate.length == 1){
            //date of birth
        }else {
            //first and last name
        }
        String input = scanner.nextLine();
        //•	"{FirstName} {LastName} – {FirstName} {LastName}" -> 2 elements
        //•	"{FirstName} {LastName} – {day/month/year}" -> 2
        //•	"{day/month/year} – {FirstName} {LastName}" ->
        //•	"{day/month/year} – {day/month/year}"
        //•	"{FirstName} {LastName} {day/month/year}"
        String[] info = input.split(" - ");
        try {
            //parent name
            String[] parentName = info[0].split("\\s+");
            try {
                //child name
                String[] childrenName = info[1].split("\\s+");
            }catch (Exception exception){
                //child date of birth
                String childDate = info[1];
            }
        }catch (Exception e){
            //parent date of birth
            String parentDate = info[0];

        }
    }
}
