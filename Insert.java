package Final;

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 import java.sql.Statement;

public class Insert extends ConnectionManager
{
    public static void insertData(String url) 
    {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            // Example rows of data
            String[] insertDataSQL = {
                    "INSERT INTO F1LapResults VALUES (841, 20, 1, 1, '1:38.109', 98109)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 2, 1, '1:33.006', 93006)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 3, 1, '1:32.713', 92713)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 4, 1, '1:32.803', 92803)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 5, 1, '1:32.342', 92342)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 6, 1, '1:32.605', 92605)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 7, 1, '1:32.502', 92502)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 8, 1, '1:32.537', 92537)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 9, 1, '1:33.240', 93240)",
                    "INSERT INTO F1LapResults VALUES (841, 20, 10, 1, '1:32.572', 92572)",
            };

            // data cleaning for missing values or nulls. 
            for (String input : insertDataSQL) 
            {
                if(input.contains("null") || input.contains("''"))
                {
                    System.out.println("Error: Null or empty values detected. Data not inserted: " + input);
                    continue;
                }
                stmt.executeUpdate(input);
            }
            
            System.out.println("Data inserted successfully!");
 
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
