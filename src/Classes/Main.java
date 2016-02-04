package Classes;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import myProject.*;;

public class Main {
	
	private static final String USERNAME = "db" ;
	private static final String PASSWORD = "123" ;
	private static final String CONN_STRING = "jdbc:mysql://localhost/java";
	//private static final String CONN_STRING = "jdbc:mysql://localhost:3306/java" ;
	static View v ;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		open();
		//View v1 = new View(1);
		//v.setBackgr//ound(Color.red);
		//Admin a  = new Admin("c1", "c2", "s", 12, 3, 4, 2, 2, 1);
		//User.display();
		//User.insertUser("khan", "23", "er@yahoo.ocm", 1233);
		//String s = Admin.getValuesAdmin(2);
		//System.out.println(Admin.getRowCount());
		//MoreInfo mf = new MoreInfo();
		//Admin.deleteValuesAdmin(3);
		
		
		
	}
	public static View close(){
		return v;
	}
	public static void open(){
		v = new View();
	}


}
