package template;

import java.sql.ResultSet;
import java.sql.*;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", String.format("SELECT "
				+ColumnFinder.find(Domain.MEMBER)
				+"	FROM %s"
				+ "	WHERE %s "
				+ "	LIKE ?", map.get("table"),map.get("column")));
		System.out.println(map.get("sql"));
		
	}

	@Override
	void startPlay() {
		System.out.println("-----------------");
		System.out.println("--------startPlay()---------");
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
			pstmt.setString(1, "%"+map.get("value").toString()+"%");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	@Override
	void endPlay() {
		 try {
			ResultSet rs = pstmt.executeQuery();
            MemberBean mem = null;
            while (rs.next()) {
                 mem = new MemberBean();
                 mem.setName(rs.getString("NAME"));
                 mem.setSsn(rs.getString("SSN"));
                 mem.setUserId(rs.getString("USERID"));
                 mem.setTeamId(rs.getString("TEAMID"));
                 mem.setPassword(rs.getString("PASSWORD"));
                 mem.setRoll(rs.getString("ROLL"));
                 mem.setAge(rs.getString("AGE"));
                 mem.setGender(rs.getString("GENDER"));
                 list.add(mem);}	
            }
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

		
	}	
}

