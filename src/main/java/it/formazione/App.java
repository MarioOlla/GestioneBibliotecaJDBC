package it.formazione;

import it.formazione.util.DBConnection;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try{
            DBConnection.getConnection();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}
