package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P6SortLines {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        Path input = Paths.get(inPath);
        Path output = Paths.get(outPath);
        List<String> allLines = Files.readAllLines(input);
        Collections.sort(allLines);
        Files.write(output, allLines);

    }
}
