package factory;

import java.util.*;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	public static Database createDatabase(Vendor v,String id,String pass) {
		Database database = null;
		String driver = "",url = "";
		switch (v) {
			case ORACLE :
				database = new Oracle(DBConstant.ORACLE_DRIVER,DBConstant.CONNECTION_URL,id,pass);
			
				break;
			case MIRIADB : 
				database = new MariaDB(DBConstant.MARIADB_DRIVER,DBConstant.CONNECTION_URL,id,pass);
				
				break;
			case MYSQL : 
				database = new MySQL(DBConstant.MARIADB_DRIVER,DBConstant.CONNECTION_URL,id,pass);
				driver = DBConstant.MYSQL_DRIVER;
				url = DBConstant.CONNECTION_URL;
				break;
			case MSSQL : 
				database =  new MsSQL(DBConstant.MARIADB_DRIVER,DBConstant.CONNECTION_URL,id,pass);
				break;
		default:
			break;
		}
		return database;
	}
	
	public static Database createDatabase2(Map<String,Object>map) {
		Database database = null;
		String driver = "",url = "";
		switch ((Vendor)map.get("vendor")) {
			case ORACLE :
				database = new Oracle(driver,url,(String)map.get("username"),(String)map.get("password"));
				driver=DBConstant.ORACLE_DRIVER;
				url=DBConstant.CONNECTION_URL;
				
				break;
			case MIRIADB : 
				database = new MariaDB(DBConstant.MARIADB_DRIVER,DBConstant.CONNECTION_URL,(String)map.get("username"),(String)map.get("password"));
				
				
				break;
			case MYSQL : 
				database = new MySQL(DBConstant.MARIADB_DRIVER,DBConstant.CONNECTION_URL,(String)map.get("username"),(String)map.get("password"));
				driver = DBConstant.MYSQL_DRIVER;
				url = DBConstant.CONNECTION_URL;
				break;
			case MSSQL : 
				database =  new MsSQL(DBConstant.MARIADB_DRIVER,DBConstant.CONNECTION_URL,(String)map.get("username"),(String)map.get("password"));
				break;
		default:
			break;
		}
		return database;
	}
}

