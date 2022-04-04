package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class P2WriteToFile {
    public static void main(String[] args) {
        try {
            String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
            String outPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
            FileInputStream inputStream = new FileInputStream(inPath);
            FileOutputStream outputStream = new FileOutputStream(outPath);
            Set<Character> punctuationList = new HashSet<>();
            punctuationList.add(',');
            punctuationList.add('.');
            punctuationList.add('!');
            punctuationList.add('?');
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                char currentSymbol = (char) oneByte;
                if(!punctuationList.contains(currentSymbol)){
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
