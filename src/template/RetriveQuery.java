package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class RetriveQuery extends  QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.RETRIEVE.toString());
		
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String) map.get("sql"));
			pstmt.setString(1,(String) map.get("USERID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		
	}

}
