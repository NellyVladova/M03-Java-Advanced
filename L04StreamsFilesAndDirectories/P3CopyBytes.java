package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P3CopyBytes {
    public static void main(String[] args) {
        try{
            String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
            String outPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

            FileInputStream inputStream = new FileInputStream(inPath);
            FileOutputStream outputStream = new FileOutputStream(outPath);

            int oneByte = inputStream.read();
            while (oneByte >= 0){
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                }else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
                oneByte = inputStream.read();
            }
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
