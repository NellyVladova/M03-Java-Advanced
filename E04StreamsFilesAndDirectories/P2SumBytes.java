package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P2SumBytes {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long totalSum = 0;

        byte [] allBytes = Files.readAllBytes(Path.of(inPath));
        for (byte currentByte : allBytes) {
            if (currentByte != 10 && currentByte != 13) {
                totalSum += currentByte;
            }
        }
        System.out.println(totalSum);
    }
}
