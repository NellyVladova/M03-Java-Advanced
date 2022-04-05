package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P4CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter("output_P4.txt"));
        int vowelsCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;
        Set<Character> vowels = getVowels();
        Set<Character> punctuation = getPunctuation();
        List<String> allLines = Files.readAllLines(Path.of(inPath));

        for (String str : allLines){
            for (int i = 0; i < str.length(); i++) {
                char currSymbol = str.charAt(i);
                if(currSymbol == ' '){
                    continue;
                }
                if (vowels.contains(currSymbol)) {
                    vowelsCount++;
                }else if(punctuation.contains(currSymbol)){
                    punctuationCount++;
                }else {
                    consonantCount++;
                }
            }
        }
        buffWriter.write("Vowels: " + vowelsCount);
        buffWriter.newLine();
        buffWriter.write("Consonants: " + consonantCount);
        buffWriter.newLine();
        buffWriter.write("Punctuation: " + punctuationCount);
        buffWriter.close();

    }

    private static Set<Character> getPunctuation() {
        Set<Character> punctuations = new HashSet<>();
        punctuations.add('!');
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('?');

        return punctuations;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        return vowels;
    }
}
