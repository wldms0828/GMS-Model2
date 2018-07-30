package command;

import javax.servlet.http.HttpServletRequest;
//체크박스 값을 가져오는 유틸
public class ParamMap {
	public static String getValues(HttpServletRequest request, String name) {
		String rs = "";
		String[] values = request.getParameterMap().get(name);
		StringBuffer buff = new StringBuffer();
		for (String s : values) {
			buff.append(s+",");
		}
		rs = buff.toString().substring(0,buff.toString().length()-1);
		
		return rs;
	}
}
