package enums;


public enum ImageQuery {
	INSERT,
	RETRIEVE;
	
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case INSERT:
			query = 
					"	INSERT INTO IMAGE("
					+ "	IMG_SEQ, "
					+ "	IMAGE_NAME , "
					+ "	EXTENSION, "
					+ "	USERID )" 
					+ "	VALUES(	IMG_SEQ.NEXTVAL , ? , ? , ? )" ;
			break;
		case RETRIEVE:
			query=
					"SELECT " + 
					"    IMAGE_NAME," + 
					"    EXTENSION" + 
					"	FROM IMAGE" + 
					"	WHERE USERID LIKE ?";
		default:
			break;
		}
		return query;
	}
	
	
}
