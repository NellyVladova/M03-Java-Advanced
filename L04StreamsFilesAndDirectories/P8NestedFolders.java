package JavaAdvanced.L04StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P8NestedFolders {
    public static void main(String[] args) {
        String inPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(inPath);
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int foldersCount = 0;
        while (!dirs.isEmpty()){
            File currFile = dirs.poll();
            File[] nestedFiles = currFile.listFiles();
            for(File f : nestedFiles){
                if(f.isDirectory()){
                    dirs.offer(f);
                }
            }
            foldersCount++;
            System.out.println(currFile.getName());
        }
        System.out.println(foldersCount + " folders");
    }
}
