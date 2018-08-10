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
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		System.out.println("1. retrieveCommand");
		Map<String, Object> map = new HashMap<>();
		map.put("USERID", request.getParameter("USERID"));
		request.setAttribute("member",  MemberServiceImpl.getInstance().retrive(request.getParameter("USERID")));
		System.out.println("--id검색확인--");
		
		super.execute();
	}
}
