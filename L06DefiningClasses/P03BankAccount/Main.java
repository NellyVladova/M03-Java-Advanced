package JavaAdvanced.L06DefiningClasses.P03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();
        while (!command.equals("End")){
            String[] commandParts = command.split("\\s+");
            String firstCommand = commandParts[0];
            String result = "";
            switch (firstCommand){
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccountMap.put(account.getID(), account);
                    result = String.format("Account ID%d created", account.getID());
                    break;
                case "Deposit":
                    int counter = Integer.parseInt(commandParts[1]);
                    int amount = Integer.parseInt(commandParts[2]);
                    if(bankAccountMap.containsKey(counter)){
                        bankAccountMap.get(counter).deposit(amount);
                        result = String.format("Deposited %d to ID%d", amount, counter);
                    }else {
                        result = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(commandParts[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int id = Integer.parseInt(commandParts[1]);
                    int years = Integer.parseInt(commandParts[2]);
                    if(bankAccountMap.containsKey(id)){
                        result = String.format("%.2f", bankAccountMap.get(id).getInterest(years));
                    }else {
                        result = "Account does not exist";
                    }
                    break;
            }
            if (!result.isEmpty()){
                System.out.println(result);
            }
            command = scanner.nextLine();
        }

    }
}
