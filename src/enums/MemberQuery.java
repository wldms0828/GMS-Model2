package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, JOIN, COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_BY_NAME, SEARCH_BY_ID
	,SELECT_BY_TEAM,SELECT_LIST,SELECT_SOME;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN:
			query = " SELECT USERID  " +
						", TEAMID   " +
						", NAME  " +
						", SSN  " +
						", PASSWORD   " 
						+ "FROM MEMBER "
					+ " WHERE USERID LIKE '%s' " + " AND PASSWORD LIKE '%s' ";
			break;
	case INSERT_MEMBER:
			query = "INSERT INTO MEMBER( USERID,"
					+ " NAME , "
					+ " SSN, "
					+ " PASSWORD, "
					+ " GENDER, "
					+ " AGE, "
					+ " ROLL,"
					+ " TEAMID) "
					+ " VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')";
			break;
		
		case COUNT_MEMBER:	
			query = "SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_MEMBER:
			query = "UPDATE MEMBER SET PASSWORD = '%s', "
					+ "	TEAMID ='%s', "
					+ "	ROLL='%s'" + 
					"	WHERE USERID LIKE '%s'" + 
					"	AND PASSWORD LIKE '%s'";
              ;
			break;
		case DELETE_MEMBER:
			query = "DELETE FROM MEMBER " + 
				" WHERE USERID LIKE '%s' " + 
				" AND PASSWORD LIKE '%s'";
			
			break;
		case SELECT_ALL: 
			query = "SELECT " + 
					"    USERID," + 
					"    TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD,"
					+ " GENDER,"
					+ " AGE" + 
					" FROM MEMBER";
			break;
//		case SELECT_LIST : 
//			query = "SELECT T.* " + 
//					"	FROM(SELECT ROWNUM SEQ, M.* " + 
//					"	FROM MEMBER M " + 
//					"	ORDER BY SEQ DESC)T " + 
//					"	WHERE T.SEQ BETWEEN %s AND %s";
//			break;

		case SEARCH_BY_ID : 
			query = "SELECT USERID," + 
					"    TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD,"
					+ " GENDER,"
					+ " AGE" + 
					" FROM MEMBER" + 
					" WHERE USERID LIKE '%s'";
			
			break;
		case SELECT_BY_NAME : 
			query = "SELECT USERID," + 
					"    TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD,"
					+ " GENDER,"
					+ " AGE" + 
					"    FROM MEMBER"+ 
					"    WHERE NAME LIKE '%s' " ;
			break;
		case SELECT_BY_TEAM : 
			query = "SELECT " + 
					"    USERID," + 
					"    TEAMID," + 
					"    NAME," + 
					"    SSN," + 
					"    ROLL," + 
					"    PASSWORD,"
					+ " GENDER,"
					+ " AGE" + 
					"    FROM MEMBER"+ 
					"    WHERE TEAMID LIKE '%s' " ;
			break;
			default :
				query = super.toString();
				break;
		}

		return query;
	}
}
