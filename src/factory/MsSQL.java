package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class MsSQL implements Database {
	private Connection conn;
	private String driver,url,id,pass;
	public MsSQL(String driver,String url,String id,String pass) {
		this.driver = driver;
		this.id = id;
		this.pass = pass;
		this.url = url;
	}
	
	public Connection getConnection() {
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


}
