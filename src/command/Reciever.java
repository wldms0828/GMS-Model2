package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reciever {
	//servletPath = /member.do
	//servletPath.substring(1,servletPath.indexOf(".")) 는 domain
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request, HttpServletResponse response) {

		cmd = Commander.order(
				request, response);		
	}
}
