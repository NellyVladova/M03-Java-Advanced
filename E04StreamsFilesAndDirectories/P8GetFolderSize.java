package JavaAdvanced.E04StreamsFilesAndDirectories;

import java.io.File;

public class P8GetFolderSize {
    public static void main(String[] args) {

        String pathIn = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(pathIn);
        File[] allFiles = folder.listFiles();
        int folderTotalSize = 0;

        for (File f : allFiles){
            folderTotalSize+=f.length();
        }

        System.out.println("Folder size: " + folderTotalSize);
    }
}
