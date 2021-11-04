import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.*;
   
public class Table {  
     /** 
     * Connect to a sample database 
     * @throws ClassNotFoundException 
     */  
    public static void connect() throws ClassNotFoundException {  
    	Connection con=null;
        try {  
            // db parameters  
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","krishna");
            Statement stmt = con.createStatement();
            System.out.println("Connection to SQLite has been established.");  
            String sql = "CREATE TABLE Movie " +
                    "(Id INTEGER not NULL, " +
                    " Movie_Name VARCHAR(255), " + 
                    " Status VARCHAR(255), " + 
                    " Collection INTEGER)";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            
            System.out.println("Inserting records into the table...");          
            sql = "INSERT INTO Movie VALUES (1, 'Home Alone', 'Hit', 18000000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Movie VALUES (2, 'Terminator', 'Hit', 250000000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Movie VALUES (3, 'Beauty&Beast', 'Average', 3000000)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");   
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (con != null) {  
                    con.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
    /** 
     * @param args the command line arguments 
     * @throws ClassNotFoundException 
     */  
    public static void main(String[] args) throws ClassNotFoundException {  
        connect();  
    }  
}  