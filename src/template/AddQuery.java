package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate{

	
	@Override
	void initialize() {
		System.out.println(" AddQuery ");
		map.put("sql", MemberQuery.INSERT.toString());
		switch(){
			
		}
	}

	@Override
	void startPlay() {
	System.out.println("AddQuery + startPlay()");
		try {
			pstmt=DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1, (String) map.get("USERID"));
			pstmt.setString(2, (String) map.get("NAME"));
			pstmt.setString(3, (String) map.get("SSN"));
			pstmt.setString(4, (String) map.get("PASSWORD"));
			pstmt.setString(5, (String) map.get("GENDER"));
			pstmt.setString(6, (String) map.get("AGE"));
			pstmt.setString(7, (String) map.get("ROLL"));
			pstmt.setString(8, (String) map.get("TEAMID"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
