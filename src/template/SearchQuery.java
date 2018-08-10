package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class SearchQuery extends QueryTemplate {

	@Override
	void initialize() {
		System.out.println("8.SearchQuery");
		map.put("sql", (!map.containsKey("column"))?
				MemberQuery.LIST.toString()
				: MemberQuery.SEARCH.toString());
		
	}

	@Override
	void startPlay() {
		try {
			System.out.println("9.startPlay():"+map.get("sql"));
			pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String) map.get("sql"));
			System.out.println("10.colum : "+map.get("column"));
			int j=0;
			if(map.containsKey("column")) {
				System.out.println("11. map contain 내부");
				j++;
				pstmt.setString(j, "%" + map.get("value").toString()+"%");
			}
			System.out.println("12. map contain 외부");
			j++;
			pstmt.setString(j,map.get("beginRow").toString());
			j++;
			pstmt.setString(j,map.get("endRow").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
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
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
