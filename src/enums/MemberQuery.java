package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, JOIN, COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_BY_NAME, SEARCH_BY_ID;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN:
			query = " SELECT MEM_ID  " + ", TEAM_ID   " + ", NAME  " + ", SSN  " + ", PASSWORD   " + "FROM MEMBER "
					+ " WHERE MEM_ID LIKE '%s' " + " AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER:
			query = "INSERT INTO MEMBER( MEM_ID, NAME , SSN,  PASSWORD) VALUES ('%s','%s','%s','%s')";
			break;
		case JOIN:
			query = "SELECT MEM_ID USERID," + " NAME " + ",SSN " + ",PASSWORD " + "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'" + " AND PASSWORD LIKE '%s' " + "AND SSN LIKE '%s' "
					+ "AND NAME LIKE '%s'";
			break;
		case COUNT_MEMBER:	
			query = "SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_MEMBER:
			query = "UPDATE MEMBER SET PASSWORD = '%s'" + 
					" WHERE MEM_ID LIKE '%s'"
					+" AND PASSWORD LIKE '%s'";
			break;
		case DELETE_MEMBER:
			query = "DELETE FROM MEMBER " + 
				" WHERE MEM_ID LIKE '%s' " + 
				" AND PASSWORD LIKE '%s'";
			
			break;
		case SELECT_ALL: 
			query = "SELECT " + 
					"    MEM_ID USERID," + 
					"    TEAM_ID TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD" + 
					" FROM MEMBER";
			break;
		case SELECT_BY_NAME : 
			query = "SELECT " + 
					"    MEM_ID USERID," + 
					"    TEAM_ID TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD " + 
					"    FROM MEMBER"+ 
					"    WHERE TEAM_ID LIKE '%s' " ;
		case SEARCH_BY_ID : 
			query = "SELECT MEM_ID USERID," + 
					"    TEAM_ID TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD" + 
					" FROM MEMBER" + 
					" WHERE MEM_ID LIKE '%s'";
			
			break;
			
		}

		return query;
	}
}
