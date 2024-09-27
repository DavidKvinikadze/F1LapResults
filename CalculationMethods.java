package Final;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CalculationMethods extends ConnectionManager
{
    public static void calculation(String url) throws SQLException 
    {
        // Perform statistical analysis with proper functions.
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) 
        {
            // Min
            ResultSet minResult = stmt.executeQuery("SELECT MIN(Milliseconds) AS MinTime FROM F1LapResults");
            if (minResult.next()) 
            {
                System.out.println("Minimum Lap Time: " + formatTime(minResult.getInt("MinTime")) + " milliseconds");
            }

            // Max
            ResultSet maxResult = stmt.executeQuery("SELECT MAX(Milliseconds) AS MaxTime FROM F1LapResults");
            if (maxResult.next()) 
            {
                System.out.println("Maximum Lap Time: " + formatTime(maxResult.getInt("MaxTime")) + " milliseconds");
            }

            // Count
            ResultSet countResult = stmt.executeQuery("SELECT COUNT(*) AS TotalLapTimes FROM F1LapResults");
            if (countResult.next()) 
            {
                System.out.println("Total Number of Lap Times: " + countResult.getInt("TotalLapTimes"));
            }

            // Avg
            ResultSet avgResult = stmt.executeQuery("SELECT AVG(Milliseconds) AS AvgTime FROM F1LapResults");
            if (avgResult.next()) 
            {
                System.out.println("Average Lap Time: " + formatTime(avgResult.getDouble("AvgTime")) + " milliseconds");
            }

            // Sum
            ResultSet sumResult = stmt.executeQuery("SELECT SUM(Milliseconds) AS TotalTime FROM F1LapResults");
            if (sumResult.next()) 
            {
                System.out.println("Total Time of All Lap Times: " + formatTime(sumResult.getInt("TotalTime")) + " milliseconds");
            }   
        }
    }
        
    public static String formatTime(double milliseconds) 
    {
        long minutes = (long) (milliseconds / 60000);
        long seconds = (long) ((milliseconds / 1000) % 60);
        long millis = (long) (milliseconds % 1000);
        return String.format("%02d:%02d.%03d", minutes, seconds, millis);
    }
}
