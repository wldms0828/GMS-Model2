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
	}

	@Override
	void startPlay() {
		System.out.println(" LoginQuery+ startPlay() ");
		try {
			pstmt=DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1,map.get("USERID").toString());
			pstmt.setString(2, map.get("PASSWORD").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				((MemberBean) o).setUserId(rs.getString("USERID"));
				((MemberBean) o).setTeamId(rs.getString("TEAMID"));
				((MemberBean) o).setAge(rs.getString("AGE"));
				((MemberBean) o).setGender(rs.getString("GENDER"));
				((MemberBean) o).setName(rs.getString("NAME"));
				((MemberBean) o).setPassword(rs.getString("PASSWORD"));
				((MemberBean) o).setRoll(rs.getString("ROLL"));
				((MemberBean) o).setSsn(rs.getString("SSN"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

}
