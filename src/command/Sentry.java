package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sentry {
	//servletPath = /member.do
	//servletPath.substring(1,servletPath.indexOf(".")) 는 domain
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request, HttpServletResponse response) {
		String servletPath = request.getServletPath();
		System.out.println("---센트리진입---" + servletPath.substring(1, servletPath.indexOf(".")));
		cmd = Commander.order(
				request, response);
				/*servletPath.substring(1,servletPath.indexOf(".")),
				request.getParameter("action"),//move로 들어왔고
				request.getParameter("page"));//page로 이동하라고 해서 왔습니다.
*/		
	}
}
