import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyThread extends Thread {
    private Socket client;
    private double result;
    private int counter;

    public MyThread(Socket socket, int counter) {
        this.client = socket;
        this.counter = counter;
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(client.getInputStream());
            PrintStream printout = new PrintStream(client.getOutputStream());
            String commandFromClient = scanner.nextLine();
            String result = null;
            String operation;
            String invalidDivide = null;

            while (!commandFromClient.equals("end")) {
                String[] input = commandFromClient.split(" ");
                double num1 = Double.parseDouble(input[0]);
                operation = input[1];
                double num2 = Double.parseDouble(input[2]);

                switch (operation) {
                    case "+":
                        result = "The result is: " + add(num1, num2);
                        break;
                    case "-":
                        result = "The result is: " + substitute(num1, num2);
                        break;
                    case "*":
                        result = "The result is: " + multiply(num1, num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            invalidDivide = "Can't divide by 0!";
                        } else {
                            result = "The result is: " + divide(num1, num2);
                        }
                        break;
                    default:
                        result = "Invalid operation!";
                        break;
                }
                if (num2 == 0 && operation.equals("/")) {
                    printout.println(invalidDivide);
                } else {
                    printout.println(result);
                }
                commandFromClient = scanner.nextLine();
            }
            client.close();
            scanner.close();
            printout.close();
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (IOException io){
            System.out.println(io);
        } catch (Exception e1) {
            System.out.println(e1);
        } finally {
            System.out.println("End calculating for client " + counter);
        }
    }

    public double add(double num1, double num2) {
        this.result = num1 + num2;
        return result;
    }

    public double substitute(double num1, double num2) {
        this.result = num1 - num2;
        return result;
    }

    public double multiply(double num1, double num2) {
        this.result = num1 * num2;
        return result;
    }

    public double divide(double num1, double num2) {
        this.result = num1 / num2;
        return result;
    }

}
