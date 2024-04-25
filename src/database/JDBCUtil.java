package database;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class JDBCUtil {
	    public static Connection getConnection() {
	        Connection c = null;
	        
	        try {
	            String url = "jdbc:sqlserver://DESKTOP-171AVQP\\SQLEXPRESS:1433;databaseName=bt;encrypt=false;trustServerCertificate=true;";
	            String username= "sa";
	            String pass ="01112004";
	            c = DriverManager.getConnection(url, username, pass);
	        } catch (SQLException e) {
	            e.printStackTrace();
	           
	        }
	        
	        return c;
	    }
	    
	    public static void main(String[] args) {
	        Connection con =  JDBCUtil.getConnection();
	        System.out.println(con != null ? con : "Failed");

	    }
	}

