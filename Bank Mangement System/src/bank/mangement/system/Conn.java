
package bank.mangement.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
       try {
            // Corrected the DriverManager method and URL
            c = DriverManager.getConnection("jdbc:mysql://localhost/bankmangementsystem", "root", "4671");

            s = c.createStatement();
                    
        }
        catch(Exception e)
                {
                     e.printStackTrace();
            System.out.println("Error message: " + e.getMessage());
//                System.out.print(e);
                }
    }
    
}
