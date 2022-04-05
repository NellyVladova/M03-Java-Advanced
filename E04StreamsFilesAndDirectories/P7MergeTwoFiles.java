package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P7MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathInputOne = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathInputTwo = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        PrintWriter writer = new PrintWriter("outputP7.txt");

        List<String> textFromFirstFile = Files.readAllLines(Path.of(pathInputOne));
        textFromFirstFile.forEach(line -> writer.println(line));
        List<String> textFromSecondFile = Files.readAllLines(Path.of(pathInputTwo));
        textFromSecondFile.forEach(line -> writer.println(line));

        writer.close();
    }
}
