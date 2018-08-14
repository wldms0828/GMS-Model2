package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;
import oracle.net.aso.p;

public class LoginQuery extends QueryTemplate {

	@Override
	void initialize() {
		System.out.println(" LoginQuery ");
		map.put("sql", MemberQuery.LOGIN.toString());
		System.out.println("sql : "+ MemberQuery.LOGIN.toString());
	}

	@Override
	void startPlay() {
		System.out.println(" LoginQuery + startPlay() ");
		try {
			pstmt=DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1,map.get("USERID").toString());
			pstmt.setString(2,map.get("PASSWORD").toString());
			System.out.println(map.get("USERID").toString());
			System.out.println(map.get("PASSWORD").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBean mem = new MemberBean();
				mem.setUserId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				o=mem;
				System.out.println("endPlay() : " + o);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

}
