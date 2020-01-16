package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    public static List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader (new File(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                if (Mail.isMail(line)) {
                    list.add(line);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("ERROR: " + e.getMessage());
        }catch(IOException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        return list;
    }

}
