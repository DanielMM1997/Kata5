package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {
    private String URL;
    private Connection connection = null;
    
    public DataBase(String URL) {
        this.URL = URL;
    }

    public void open() {
        try {
            //if (this.connection != null)
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de Datos abierta.");
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
                System.out.println("Base de Datos cerrada.");
            } catch (SQLException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void selectPeople() {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID\tNAME\tSURNAME\tDEPARTAMENT");
            while (resultset.next()) {
                System.out.println(resultset.getInt("ID") + "\t" +
                                   resultset.getString("NAME") + "\t" +
                                   resultset.getString("SURNAME") + "\t" +
                                   resultset.getString("DEPARTAMENT"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void insertPeople(People people) {
        String SQL = "INSERT INTO PEOPLE(NAME, SURNAME, DEPARTAMENT) VALUES(?, ?, ?)";
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement(SQL);
            prepareStatement.setString(1, people.getName());
            prepareStatement.setString(2, people.getSurname());
            prepareStatement.setString(3, people.getDepartament());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void deletePeople(String name) {
        String SQL = "DELETE FROM PEOPLE WHERE Name = " + '"' + name + '"';
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
