package kata5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String URL = "jdbc:sqlite:Kata5_DB.db";
        String mail = "email.txt";
        List<String> lista = MailListReader.read(mail);
        DataBase db = new DataBase(URL);
        db.open();
        db.insertEmail(lista);
        db.selectEmails();
        db.close();
    }
    
}
