package template;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate {
	HashMap<String, Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	public final void play(HashMap<String, Object>map) {
		this.pstmt = null;
		this.list=null;
		this.map=map;
		this.map.put("vendor",Vendor.ORACLE);
		this.map.put("vendor",DBConstant.USER_NAME);
		this.map.put("vendor",DBConstant.PASSWORD);
		// initialize the game
		initialize();
		// start game
		startPlay();
		// end game
		endPlay();
	}
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	// template method

}
