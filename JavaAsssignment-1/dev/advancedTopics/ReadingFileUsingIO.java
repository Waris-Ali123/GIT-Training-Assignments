package dev.advancedTopics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileUsingIO {
    public static void main(String[] args) {
        FileReader fr;
        File file;
        BufferedReader br;
        try {
            file = new
                    File("F:/NucleusTeq_Traninig_Program/Java/Java_Assignments/src/dev/advancedTopics/waris.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null)
                System.out.println(line);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
//            fr.close();
//            br.close();

            System.out.println("Resouces Closed");
        }

    }
}

