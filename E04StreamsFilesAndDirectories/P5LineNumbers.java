package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.*;

public class P5LineNumbers {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter("lineNumbersOutput.txt"));
        BufferedReader buffReader = new BufferedReader(new FileReader(inPath));

        int counter = 1;
        String currLine = buffReader.readLine();
        while (currLine != null){
            String newLine = counter + ". " + currLine;
            buffWriter.write(newLine);
            buffWriter.newLine();
            counter++;

            currLine = buffReader.readLine();
        }
        buffWriter.close();
        buffReader.close();
    }
}
