package enums;

import template.ColumnFinder;

public enum MemberQuery {
	 INSERT, 
	 LIST,COUNT,RETRIEVE,SEARCH,
	 UPDATE,DELETE,
	 LOGIN;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
	case INSERT:
			query = "INSERT INTO MEMBER( USERID,"
					+ " NAME , "
					+ " SSN, "
					+ " PASSWORD, "
					+ " GENDER, "
					+ " AGE, "
					+ " ROLL,"
					+ " TEAMID) "
					+ " VALUES "
					+ "(?,?,?,?,?,?,?,?)";
			break;
		
		case COUNT:	
			query = "SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE:
			query = "UPDATE MEMBER SET %s = ?, "
					+ "	WHERE USERID LIKE ?" ;
              ;
			break;
		case DELETE:
			query = "DELETE "
				+ "FROM MEMBER " + 
				" WHERE USERID LIKE ? " + 
				" AND PASSWORD LIKE ?";
			
			break;

		 case SEARCH : 
			 System.out.println("7.SEARCH query");
			query = "SELECT T.* " + 
					"	FROM(SELECT ROWNUM SEQ, M.* " + 
					"	FROM MEMBER M " +
					"	WHERE %s LIKE ? " + 
					"	ORDER BY SEQ DESC)T " + 
					"	WHERE T.SEQ BETWEEN ? AND ?";
			
			break;
		
		case RETRIEVE : 
			query = " SELECT USERID,  " 
					+ " TEAMID , "
					+ " AGE, "
					+ " GENDER, "
					+ " NAME, "
					+ " PASSWORD, "
					+ " ROLL,"
					+ " SSN"
					+"	FROM MEMBER "
					+"	WHERE USERID"
					+"	LIKE ? " ;
			break;
		case LIST : 
			 System.out.println("LIST query");
			query ="SELECT T.* " + 
					"	FROM(SELECT ROWNUM SEQ, M.* " + 
					"	FROM MEMBER M "+
					"	ORDER BY SEQ DESC)T " + 
					"	WHERE T.SEQ BETWEEN ? AND ?";
			break;
		case LOGIN:
			query = " SELECT USERID,  " 
							+ " TEAMID , "
							+ " AGE, "
							+ " GENDER, "
							+ " NAME, "
							+ " PASSWORD, "
							+ " ROLL,"
							+ " SSN"
						+ "	FROM MEMBER "
						+ " WHERE USERID LIKE ? " 
						+ " AND PASSWORD LIKE ? ";
			break;
			default :
				query = super.toString();
				break;
		}

		return query;
	}
}
