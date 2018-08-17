package command;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.ImageServiceImpl;
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
		Map<String , Object> map = new HashMap<>();
		System.out.println("1. retrieveCommand");
		request.setAttribute("pagename", request.getParameter("page"));
		request.setAttribute("member",
				MemberServiceImpl.getInstance().retrive(((MemberBean)request.getSession().getAttribute("member")).getUserId()));
		String img = (String) map.get("IMGNAME")+(String)map.get("EXTENSION");
		String imgPath="/upload/"+img;
		request.setAttribute("img",imgPath );
		System.out.println("--id검색확인--");
		
		super.execute();
	}
}
