package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P4ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inPath));
        FileOutputStream out = new FileOutputStream(outPath);
        PrintWriter print = new PrintWriter(out);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                print.println(scanner.nextInt());
            }
            scanner.next();
        }

        print.close();

    }
}
