package Final;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends ConnectionManager
{
    public static void deleteData(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            // Example DELETE query
            String deleteQuery = "DELETE FROM F1LapResults WHERE DriverID = 20 AND LapNumber = 3";
            int rowsAffected = stmt.executeUpdate(deleteQuery);

            // Output message about operation results:
            System.out.println("Rows affected by delete operation: " + rowsAffected);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
