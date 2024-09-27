package Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable extends ConnectionManager
{
    public static void dropTable(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            String dropTableSQL = "DROP TABLE F1LapResults";
            stmt.executeUpdate(dropTableSQL);

            System.out.println("Table 'F1LapResults' dropped successfully.");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
