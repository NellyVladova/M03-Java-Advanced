package JavaAdvanced.L06DefiningClasses.P03BankAccount;

public class BankAccount {
    private int ID;
    private double balance;
    private static double interestRate = 0.02;
    private static int counter = 0;

    public BankAccount() {
        counter++;
        this.ID = counter;
        this.balance = 0;
    }

    public int getID() {
        return ID;
    }

    public static void setInterestRate(double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years){
        return interestRate * years * this.balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
}
