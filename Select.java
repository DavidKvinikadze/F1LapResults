package Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select extends ConnectionManager
{
    public static void selectWithAND(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            // Query using AND
            ResultSet rs = stmt.executeQuery("SELECT * FROM F1LapResults WHERE DriverID = 20 AND LapNumber = 3");

            // Print the results
            System.out.println("View with AND:");
            printResultSet(rs);

            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectWithOR(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            // Query using OR
            ResultSet rs = stmt.executeQuery("SELECT * FROM F1LapResults WHERE DriverID = 20 OR LapNumber = 3");

            // Print the results
            System.out.println("View with OR:");
            printResultSet(rs);

            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectWithWHERE(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            // Query using WHERE
            ResultSet rs = stmt.executeQuery("SELECT * FROM F1LapResults WHERE DriverID = 20");

            // Print the results
            System.out.println("View with WHERE:");
            printResultSet(rs);

            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        System.out.println("RaceID\tDriverID\tLapNumber\tPosition\tTime\t\tMilliseconds");
        while (rs.next()) {
            System.out.println(rs.getInt("RaceID") + "\t"
                    + rs.getInt("DriverID") + "\t"+"\t"
                    + rs.getInt("LapNumber") + "\t"+"\t"
                    + rs.getInt("Position") + "\t"+"\t"
                    + rs.getString("Time") + "\t"
                    + rs.getInt("Milliseconds"));
        }
    }
}
