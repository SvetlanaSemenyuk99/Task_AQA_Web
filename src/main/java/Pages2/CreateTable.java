package Pages2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\ololo\\IdeaProjects\\Task\\sqLite\\CountryDataBase.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Countries (\n"
                + " Country VARCHAR(20),\n"
                + " Population INTEGER,\n"
                + " Area INTEGER\n"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}