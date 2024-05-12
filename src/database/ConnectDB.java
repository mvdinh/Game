package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entity.*;
import database.JDBC;

public class ConnectDB {
	Connection con = new JDBC().getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Point getMaxPoint() {
		String user="";
		int point =0;
		String query ="select top 1 * from Point order by Point desc";
		try {
			con = new JDBC().getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Point(rs.getString(1), rs.getInt(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void setMaxPoint(String username,int point) {
		
		String query = "INSERT INTO Point(username,point) "
			+ "VALUES (,??)";
	try {
		con = new JDBC().getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1,username);
		ps.setInt(2,point);
		
		ps.executeUpdate();
		
		} catch (Exception e1) {
		// TODO: handle exception
		}
	}
	public Account login(String user, String pass) {
		String query="select * from account\n "
				+	"where username = ?\n"
				+	"and pass = ?";
		try {
			con = new JDBC().getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1),rs.getString(2),rs.getString(3));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void signup(String user, String pass) {
		String query = 
				"INSERT INTO account (username,pass) VALUES (?,?)";
		try {
			con = new JDBC().getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		
	}
}
