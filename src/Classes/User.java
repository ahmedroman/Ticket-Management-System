package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	private static final String USERNAME = "db" ;
	private static final String PASSWORD = "123" ;
	private static final String CONN_STRING = "jdbc:mysql://localhost/java" ;
	
	public static void insertUser(String name ,String pas ,String emil , int num) throws SQLException{
		Connection conn = null;
		Statement sm = null;
		String c = "INSERT INTO user (userId,username,password,email,number) "
				+ "VALUES (NULL , ? , ? , ? , ?)";
		PreparedStatement ps;
		try {			
			conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);		
			ps = conn.prepareStatement(c);			
			ps.setString(1,name);
			ps.setString(2,pas);
			ps.setString(3,emil);
			ps.setInt(4,num);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e);
		}finally{
			if(sm != null){
				sm.close();
			}
			if(conn != null){
				conn.close();
			}             		
		}

	}
	
	public static int match(String user , String pass){
		int c = 0;
		try {
			Connection conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);
			Statement sm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = sm.executeQuery("Select * From user");
			while(rs.next()){
				if((rs.getString("UserName")).equals(user)){
					if((rs.getString("password")).equals(pass)){						
						c=1;
						break;
					}
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
		}
		return c;
	}
	
}
