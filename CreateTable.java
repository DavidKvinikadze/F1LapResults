package Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends ConnectionManager {
    
    public static void createTable(String url) 
    {
        try (Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement()) 
            {
                statement.executeUpdate("CREATE TABLE F1LapResults ("
                + "RaceID INT,"
                + "DriverID INT,"
                + "LapNumber INT,"
                + "Position INT,"
                + "Time VARCHAR(10),"
                + "Milliseconds INT)");
                System.out.println(" 'F1LapResults' table created!");
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
    }
}
