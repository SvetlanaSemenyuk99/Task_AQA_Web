package Pages2;

import java.awt.desktop.OpenURIEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectRecords {

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


    public List<Object> selectAll(){
        String sql = "SELECT * FROM Countries";
        List<Object> out = new ArrayList<>();
        List<Integer> myList = new ArrayList<Integer>();
        List<Integer> plotUsa = new ArrayList<Integer>();
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                if (rs.getString("Country").equals("USA")) {
                    plotUsa.add (rs.getInt("Population"));
                    plotUsa.add (rs.getInt("Area"));
                }
                myList.add(rs.getInt("Population"));
//                System.out.println(rs.getString("Country") +  "\t" +
//                        rs.getInt("Population") + "\t" +
//                        rs.getInt("Area"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        int pl1 = plotUsa.get(0);
        int pl2 = plotUsa.get(1);
        float plotUsa1 = pl1 / pl2;
//        System.out.println(plotUsa1);
        int a = 0;
        int b = 0;
        for (int i=0; i< myList.size(); i++){
            a =  myList.get(i);
            b = a+b;
        }
        out.add(b);
        out.add(plotUsa1);
        return out;
    }


    public static void main(String[] args) {
        SelectRecords app = new SelectRecords();
        app.selectAll();
    }

}