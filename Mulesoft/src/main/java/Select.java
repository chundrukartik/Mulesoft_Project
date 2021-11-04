import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.*;
   
public class Select {  
     /** 
     * Connect to a sample database 
     * @throws ClassNotFoundException 
     */  
    public static void connect() throws ClassNotFoundException {  
    	Connection con=null;
    	ResultSet rs=null;
        try {  
            // db parameters  
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","krishna");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Movie";
            
            //Step 4 : Executing The Query
 
            //We are using executeQuery() method as we are executing SELECT statement
 
            rs = stmt.executeQuery(sql);
 
            //Processing the ResultSet object
 
            while (rs.next())
            {
                System.out.println("ID :"+rs.getInt(1));
 
                System.out.println("First Name : "+rs.getString(2));
 
                System.out.println("Last Name :"+rs.getString(3));
 
                System.out.println("Designation :"+rs.getInt(4));
 
                System.out.println("-------------------");
            }
        }
              
  catch (SQLException e) {  
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