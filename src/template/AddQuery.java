package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import enums.ImageQuery;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate{

	
	@Override
	void initialize() {
		System.out.println("AddQuery로 넘어온 map :"+ String.valueOf(map.get("table")));
		 switch(String.valueOf(map.get("table"))){
		 	case "MEMBER" :
		 		map.put("sql", MemberQuery.INSERT.toString());
		 		break;
		 	case "IMAGE" : 
		 		map.put("sql", ImageQuery.INSERT.toString());
		 		System.out.println("AddQuery의 IMAGE sql : "+ map.put("sql", ImageQuery.INSERT.toString()));
		 		break;
		 	default : break;
		}
	}

	@Override
	void startPlay() {
	System.out.println("AddQuery + startPlay()" + String.valueOf(map.get("table")));
	try {
	switch(String.valueOf(map.get("table"))) {
	case "MEMBER" :
		
			pstmt.setString(1, (String) map.get("USERID"));
			pstmt.setString(2, (String) map.get("NAME"));
			pstmt.setString(3, (String) map.get("SSN"));
			pstmt.setString(4, (String) map.get("PASSWORD"));
			pstmt.setString(5, (String) map.get("GENDER"));
			pstmt.setString(6, (String) map.get("AGE"));
			pstmt.setString(7, (String) map.get("ROLL"));
			pstmt.setString(8, (String) map.get("TEAMID"));
		
 		break;
 	case "IMAGE" : 
 
			pstmt.setString(1,(String) map.get("IMGNAME"));
			pstmt.setString(2, (String) map.get("EXTENSION"));
			pstmt.setString(3, (String) map.get("USERID"));
			System.out.println("AddQuery로 넘어온 startPlay()의 USERID : " + (String) map.get("USERID"));

 		break;
 	default : break;
	}
	} catch (Exception e) {

		e.printStackTrace();
	}
		
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
