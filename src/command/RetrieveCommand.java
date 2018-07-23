package command;



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
		System.out.println("--id검색--");
		request.setAttribute("member",  MemberServiceImpl.getInstance().findMemberById(request.getParameter("USERID")));
		System.out.println("--id검색확인--");
		
		super.execute();
	}
}
