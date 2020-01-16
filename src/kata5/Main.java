package kata5;

public class Main {

    public static void main(String[] args) {
        String URL = new String("jdbc:sqlite:C:people.db");
        DataBase db = new DataBase(URL);
        db.open();
        People people = new People("Daniel", "Martinez", "Ventas"); 
        db.insertPeople(people);
        db.selectPeople();
        db.deletePeople("Daniel");        
        db.close();
    }
    
}
