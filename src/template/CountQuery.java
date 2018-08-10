package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDAOImpl;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("count query");
		map.put("sql", MemberQuery.COUNT.toString());
		
	}

	@Override
	void startPlay() {
		System.out.println("countQuery startPlay() : " + map.get("sql"));
		try {
			pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection().prepareStatement((String) map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				number = rs.getInt("COUNT");
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
