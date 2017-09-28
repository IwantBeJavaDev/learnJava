package pl.michal.learn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class GetUserDetailsUsingPS {

	public static void main(String[] args) throws SQLException  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Get your email address:");
		String email = scanner.nextLine();
		System.out.println("Eneter your password");
		String pwd = scanner.nextLine();
		
		loginToDB(email, pwd);

	}
	private static void loginToDB(String email, String pwd) throws SQLException{
		DBConnection db = new DBConnection();
		Connection con = null;
		PreparedStatement prStmt = null;
		ResultSet rs = null;
		String query = "select name,country,password from learn.users where email = ? " +
				" and password = ? ";
		try{		
			Properties prop = db.getProperties("db.properties");
			con = db.getConection(prop);
			prStmt = con.prepareStatement(query);
			prStmt.setString(1, email);
			prStmt.setString(2, pwd);
			rs = prStmt.executeQuery(query);
			
			while(rs.next()){
				String name = rs.getString("name");
				String country = rs.getString("country");
				String password = rs.getString("password");
				System.out.println(name+  "," +country+ "," +password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			prStmt.close();
			con.close();
		}
		
	}
	
}
