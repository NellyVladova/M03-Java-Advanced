package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class P1ReadFile {
    public static void main(String[] args) {

        String path = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream inputStream = new FileInputStream(path)){
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = inputStream.read();
            }
        }catch (IOException io){
            io.printStackTrace();
        }

    }
}
