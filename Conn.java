package airlinesystem;

import java.sql.*;

public class Conn {
    
    public Connection c;
    public Statement s;
    
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establish Connection 
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinesystem", "root", "Harshali@1209");
            
            // 3. Create Statement
            s = c.createStatement();
            
            System.out.println("Database Connected Successfully!");
            
        } catch (Exception e) {
            // This will tell you exactly what went wrong (e.g., wrong password or missing JAR)
            e.printStackTrace();
        }
    }
}