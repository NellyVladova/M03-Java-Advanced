package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P1SumLines {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(inPath));

        allLines.stream().map(line -> line.toCharArray()).forEach(arr -> {
            int sum = 0;
            for (char symbol : arr) {
                sum += symbol;
            }
            System.out.println(sum);
        });
    }
}
