package command;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {


	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		System.out.println("1. retrieveCommand");
		request.setAttribute("pagename", request.getParameter("page"));
		request.setAttribute("member",  MemberServiceImpl.getInstance().retrive(request.getParameter("USERID")));
		request.setAttribute("user", MemberServiceImpl.getInstance().retrive(request.getParameter("USERID")));
		String img = "";
		
		String imgPath="/upload/19122206_1362190413865352_4304764215186423808_n.jpg";
		request.setAttribute("img",imgPath );
		System.out.println("--id검색확인--");
		
		super.execute();
	}
}
