package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class RetriveQuery extends  QueryTemplate{

	@Override
	void initialize() {
		switch (String.valueOf(map.get("table"))) {
			case "MEMBER":
				map.put("sql", MemberQuery.RETRIEVE.toString());
					break;
			case "IMAGE":
				map.put("sql", ImageQuery.RETRIEVE.toString());
				break;
		}
		
		
	}

	@Override
	void startPlay() {
		try {
		switch (String.valueOf(map.get("table"))) {
		case "MEMBER":

				pstmt.setString(1,(String) map.get("USERID"));
			
			break;
		case "IMAGE":
			
			pstmt.setString(1, (String) map.get("USERID"));
			
			break;


		default:
			break;
		}} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem=null;
		switch (String.valueOf(map.get("table"))) {

		case "MEMBER":
			while(rs.next()) {
					mem=new MemberBean();
					mem.setUserId(rs.getString("USERID"));
					mem.setTeamId(rs.getString("TEAMID"));
					mem.setAge(rs.getString("AGE"));
					mem.setGender(rs.getString("GENDER"));
					mem.setName(rs.getString("NAME"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setSsn(rs.getString("SSN"));
					o=mem;
				}
			
			break;
		case "IMAGE":
			while(rs.next()) {
				mem=new MemberBean();
				Map<String, Object> map = new HashMap<>();
				mem.setUserId(rs.getString("USERID"));
				map.get("IMGNAME");
				map.get("EXTENSION");
			}
			break;
		default:
			break;
		}
		} catch (Exception e) {

			e.printStackTrace();
		}
		

		
	}

}
