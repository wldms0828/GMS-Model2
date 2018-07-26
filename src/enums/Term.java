package enums;

public enum Term {
	CTX,WEBPATH,MAIN;
	@Override
	public String toString() {
		String res = "";
		switch(this) {
			case CTX : res = "ctx";break;
			case WEBPATH : res = "/WEB-INF/view";break;
			case MAIN : res = "/main.jsp";break;
			default:break;
		
		}
		return res;
	}
}
