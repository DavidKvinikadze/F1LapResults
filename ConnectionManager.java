package Final;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionManager 
{
    public static void main(String[] args) throws SQLException 
    {   
        try (Scanner scanner = new Scanner(System.in)) {
            String url = "jdbc:derby:testdb;create=true";
              
            while (true) 
            {
                System.out.println("\nMenu:");
                System.out.println("1. Create Table");
                System.out.println("2. Insert Data");
                System.out.println("3. Select Data");
                System.out.println("4. Update Data");
                System.out.println("5. Delete Data");
                System.out.println("6. Perform statistical calculations");
                System.out.println("7. Drop Table");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
            
                int choice = scanner.nextInt();
                // Consume newline
                scanner.nextLine();
            
                switch (choice) 
                {
                    case 1:
                        CreateTable.createTable(url);
                        break;
                    case 2:
                        Insert.insertData(url);
                        break;
                    case 3:
                        System.out.println("\t1. Select with OR");
                        System.out.println("\t2. Select with AND");
                        System.out.println("\t3. Select with WITH");
                        int choice2 = scanner.nextInt();
                        if(choice2 == 1)
                        {
                            Select.selectWithOR(url);
                        }
                        if(choice2 == 2)
                        {
                            Select.selectWithAND(url);
                        }
                        if(choice2 == 3)
                        {
                            Select.selectWithWHERE(url);
                        }
                        break;
                    case 4:
                        Update.updateData(url);
                        break;
                    case 5:
                        Delete.deleteData(url);
                        break;
                    case 6:
                        CalculationMethods.calculation(url);
                        break;
                    case 7:
                        DropTable.dropTable(url);
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 7.");
                }
              
                
            }
        }
    }
}

/* public static String checkA(int b) {

                // Creating a string connection and testing it.
                try {
        
                    Connection conn = DriverManager.getConnection(url);
        
                    System.out.println("New DB Connection");
        
                    conn.close();
        
                } catch (SQLException e) {
        
                    // TODO Auto-generated catch block
        
                    e.printStackTrace();
        
                }
        
                // Calling CreateTable
                CreateTable.createTable(url);
                
                // Call InsertData
                Insert.insertData(url);
         */
/* 
public class ConnectionManager {

	public static void main(String[] args) 

	{

		String url = "jdbc:mysql://localhost:3306/mydatabase";

        String username = "root";

        String password = "your_password";



        // JDBC connection object

        ConnectionManager connection = null;



        try {

            // Register JDBC driver

            Class.forName("com.mysql.cj.jdbc.Driver");



            // Establish database connection

            connection =  DriverManager.getConnection(url, username, password);



            // Print success message if connection is successful

            System.out.println("Connected to the database successfully!");



            // Perform database operations here



        } catch (ClassNotFoundException e) {

            System.out.println("Failed to load JDBC driver. Please check your classpath.");

            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Failed to connect to the database.");

            e.printStackTrace();

        } finally {

            // Close the connection in the finally block to ensure it's always closed

            if (connection != null) {

                try {

                    ((java.sql.Connection) connection).close();

                } catch (SQLException e) {

                    System.out.println("Failed to close the database connection.");

                    e.printStackTrace();

                }

            }

        }

	}

}
*/