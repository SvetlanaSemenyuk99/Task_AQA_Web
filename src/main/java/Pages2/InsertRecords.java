package Pages2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\ololo\\IdeaProjects\\Task\\sqLite\\CountryDataBase.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String Country, int Population, int Area) {
        String sql = "INSERT INTO Countries(Country, Population, Area) VALUES(?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Country);
            pstmt.setInt(2, Population);
            pstmt.setInt(3, Area);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertRecords app = new InsertRecords();
        // insert three new rows
        app.insert("Ukraine", 41588354, 603628);
        app.insert("France", 67399000, 640679);
        app.insert("USA",    328239523, 9833520);
        app.insert("China",  1400050000, 9596961);
    }

}