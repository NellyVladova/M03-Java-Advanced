package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.*;

public class P3AllCapitals {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter("output.txt"));

        BufferedReader buffReader = new BufferedReader(new FileReader(inPath));
        String currLine = buffReader.readLine();
        while (currLine != null) {
            buffWriter.write(currLine.toUpperCase());
            buffWriter.newLine();

            currLine = buffReader.readLine();
        }

        buffWriter.close();
        buffReader.close();
    }
}
