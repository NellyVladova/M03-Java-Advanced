package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P6WordCount {
    public static void main(String[] args) throws IOException {
        String pathFromWords = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        PrintWriter printWriter = new PrintWriter("results.txt");
        Map<String, Integer> countWords = new HashMap<>();
        List<String> allWords = Files.readAllLines(Path.of(pathFromWords));

        for (String words : allWords){
            Arrays.stream(words.split("\\s+")).forEach(word -> {
                countWords.put(word, 0);
            });
        }
        String pathFromText = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathFromText));
        for (String line : allLines){
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if(countWords.containsKey(word)){
                    countWords.put(word, countWords.get(word) + 1);
                }
            });
        }
        countWords.entrySet().stream().sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                .forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));

        printWriter.close();
    }
}
