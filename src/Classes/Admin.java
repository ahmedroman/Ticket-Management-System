package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Admin {
	
	static ArrayList<Integer> al = new ArrayList<Integer>();
			
	private static final String USERNAME = "db" ;
	private static final String PASSWORD = "123" ;
	private static final String CONN_STRING = "jdbc:mysql://localhost/java" ;


	
	
	
	public static void addByAdmin(String con1,String con2,
		String ste,int vip,int gal,int stand,String date) throws SQLException{
		Connection conn = null;
		Statement sm = null;
		String c = "INSERT INTO admin (adminId,country1,country2,stedium,vipTkt,galTkt,standTkt,date) "
				+ "VALUES (NULL , ? , ? , ? , ? , ? , ? , ?)";
		PreparedStatement ps;
		try {			
			conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);		
			ps = conn.prepareStatement(c);			
			ps.setString(1,con1);
			ps.setString(2,con2);
			ps.setString(3,ste);
			ps.setInt(4,vip);
			ps.setInt(5,gal);
			ps.setInt(6,stand);
			ps.setString(7,date);
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
	
	static int i =0;
	public static ArrayList getPid(){
		al.clear();
		int rowCount = 0;
			String count = "SELECT * from admin";
			ResultSet rs = null;		
			try (
					Connection conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);			
					Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
					){
				//get row count
				rs = st.executeQuery(count);				
				while(rs.next()){
					al.add(rs.getInt("adminId"));
					i++;
				}
				
				rs.last();
				rowCount = rs.getRow();				
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		return al;
	}
	
	public static String getValuesAdmin(int adminId){
		String s = null;
		
			String sql = "SELECT * from admin where adminId = ?";
			ResultSet rs = null;
			
			try (
					Connection conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);
					PreparedStatement ps = conn.prepareStatement(sql);
					){
				//get row
				ps.setInt(1 , adminId);
				rs = ps.executeQuery();
				if(rs.next()){
				s = rs.getString("country1")+"/"+rs.getString("country2")+"/"+rs.getString("stedium")
					+"/"+rs.getInt("vipTkt")+"/"+rs.getInt("galTkt")+"/"+rs.getInt("standTkt")
					+"/"+rs.getDate("date");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		return s;
	}
	public static void deleteValuesAdmin(int adminId){
		//String s = null;
			String sql = "DELETE FROM admin WHERE adminId = ?";
			//ResultSet rs = null;
			
			try (
					Connection conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);
					PreparedStatement ps = conn.prepareStatement(sql);
					){
				//get row
				ps.setInt(1 , adminId);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}						
		//return s;
	}
	
}
