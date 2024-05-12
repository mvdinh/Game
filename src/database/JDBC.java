package database;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class JDBC {
	    public static Connection getConnection() {
	        Connection c = null;
	        
	        try {
	            String url = "jdbc:sqlserver://DESKTOP-171AVQP\\SQLEXPRESS:1433;databaseName=btjava;encrypt=false;trustServerCertificate=true;";
	            String username= "sa";
	            String pass ="01112004";
	            c = DriverManager.getConnection(url, username, pass);
	        } catch (SQLException e) {
	            e.printStackTrace();
	           
	        }
	        
	        return c;
	    }
	    
	    public static void main(String[] args) {
	        Connection con =  JDBC.getConnection();
	        System.out.println(con != null ? con : "Failed");

	    }
	}

