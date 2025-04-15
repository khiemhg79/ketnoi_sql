import java.sql.*;

public class ConnectiontoSQL1 {
    private static final String DB_URL = "jdbc:sqlserver://GIAKHIEM;databaseName=QuanLyXeMay;integratedSecurity=true;encrypt=false;";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection(DB_URL);
            if (conn == null) {
                System.out.println("Connection failed!");
                return;
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM XeMay");
 
            System.out.printf("| %-12s | %-25s | %-10s | %n", "Ten xe", "HangXe", "MauSac");
            System.out.println("|---------------|----------------|------------|");

            while (rs.next()) {
                System.out.printf("| %-12s | %-25s |%-10s | %n", rs.getString("Tenxe"), rs.getString("HangXe"), rs.getString("MauSac"));
            }
             conn.close();
        } 
        catch (Exception e) {
               System.out.println("Error: " + e.getMessage());
               e.printStackTrace();
         }
    }
    public static Connection getConnection(String db_url) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(db_url);
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
 
 }
