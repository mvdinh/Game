package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.JDBCUtil;

public class dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int getMaxPoint() {
		int point =0;
		String query ="select top 1 * from Point order by point desc";
		try {
			con = new JDBCUtil().getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				point = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return point;
	}
	public void setMaxPoint(int a) {
		
		String query = "INSERT INTO Point(point) "
			+ "VALUES (?)";
	try {
		con = new JDBCUtil().getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1,a);
		
		ps.executeUpdate();
		
		
		} catch (Exception e1) {
		// TODO: handle exception
		}
	}
}
