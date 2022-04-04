package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P5WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        Scanner scanner = new Scanner(new FileReader(inPath));
        PrintWriter printOut = new PrintWriter(new FileWriter(outPath));
        int counter = 1;
        String readLine = scanner.nextLine();
        while (scanner.hasNextLine()){
            if (counter % 3 == 0) {
                printOut.println(readLine);
            }
            counter++;
            readLine = scanner.nextLine();
            printOut.flush();
        }
        scanner.close();
        printOut.close();
    }
}
