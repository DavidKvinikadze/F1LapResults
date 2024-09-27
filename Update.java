package Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update extends ConnectionManager
{
    public static void updateData(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            // Example UPDATE query
            String updateQuery = "UPDATE F1LapResults SET Position = 2 WHERE DriverID = 20 AND LapNumber = 3";
            int rowsAffected = stmt.executeUpdate(updateQuery);

            //output message about the changes
            System.out.println("Rows affected by update operation: " + rowsAffected);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
