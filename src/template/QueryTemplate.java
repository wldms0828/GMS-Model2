package template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate {
	int number;
	/*count 넘길때 return*/
	Object o;
	/*하나만검색했을때*/
	List<Object> list;
	/*뭐든지 다담아서 return 할 때*/
	HashMap<String, Object>map;
	PreparedStatement pstmt;
	public final void play(Map<?, ?>map) {
		this.number = 0;
		this.o=null;
		this.map=new HashMap<>();
		this.pstmt = null;
		this.list=new ArrayList<>();
		this.map=new HashMap<>();
		this.map.put("vendor",Vendor.ORACLE);
		this.map.put("username",DBConstant.USER_NAME);
		this.map.put("password",DBConstant.PASSWORD);
		Iterator<?> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, map.get(key));
		}
		
		/*this를 setter에서 쓰는게 맞긴하지만 훨씬 효율적이기 때문에 
		 *에러가 나지 않는 선에서 변칙을 한다.*/
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	public void play() {
		this.number=0;
		this.o=null;
		this.pstmt=null;
		this.list=new ArrayList<>();
		this.map=new HashMap<>();
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USER_NAME);
		this.map.put("password", DBConstant.PASSWORD);
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
		
	}
	// template method
	public void pstmtInit() {
		try {
			this.pstmt=DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String) map.get("sql"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
