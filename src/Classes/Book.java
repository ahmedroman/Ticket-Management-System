package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {
	private static final String USERNAME = "db" ;
	private static final String PASSWORD = "123" ;
	private static final String CONN_STRING = "jdbc:mysql://localhost/java" ;
	
	static String vTkt ;
	static String gTkt;
	static String sTkt;
	static String ste;
	static String d;
	static String p;
	
	public static void info(String vipTkt,
			String galTkt,String standTkt,String stedium , String date , String play){
		vTkt = vipTkt;
		gTkt = galTkt ;
		sTkt = standTkt ;
		ste = stedium;
		d =date ;
		p =play;
	}
	public static String getInfo(){
		return vTkt+"/"+gTkt+"/"+sTkt+"/"+ste+"/"+d+"/"+p;
	}
	
	public static void book(String name,int vipTkt,int galTkt,int standTkt,
			int price,String stedium , String date , String play) throws SQLException{
		Connection conn = null;
		Statement sm = null;
		String c = "INSERT INTO book (bookId,username,vipTkt,galTkt,standTkt,price,stedium,date,play) "
				+ "VALUES (NULL , ? , ? , ? , ? , ? , ? , ? , ?)";
		PreparedStatement ps;
		try {			
			
		
			conn = DriverManager.getConnection(CONN_STRING , USERNAME, PASSWORD);		
			ps = conn.prepareStatement(c);			
			ps.setString(1,name);
			ps.setInt(2,vipTkt);
			ps.setInt(3,galTkt);
			ps.setInt(4,standTkt);
			ps.setInt(5,price);
			ps.setString(6,stedium);
			ps.setString(7,date);
			ps.setString(8,play);
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
	
}
