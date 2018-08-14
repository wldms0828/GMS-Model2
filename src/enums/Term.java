package enums;

public enum Term {
	CTX,WEBPATH,MAIN,UPLOADPATH;
	@Override
	public String toString() {
		String res = "";
		switch(this) {
			case CTX : res = "ctx";break;
			case WEBPATH : res = "/WEB-INF/view/";break;
			case MAIN : res = "/main.jsp";break;
			case UPLOADPATH : 
				res="C:\\Users\\1027\\eclipse\\JeeWorkspace\\GMS-Model2\\WebContent\\resources\\img\\upload\\";
					break;
			default:break;
		
		}
		return res;
	}
}
