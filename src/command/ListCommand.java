package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import oracle.net.aso.r;
import service.MemberServiceImpl;

public class ListCommand extends Command {

	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();

	}
	@Override
	public void execute() {
		System.out.println("--리스트 진입--");
		request.setAttribute("list", MemberServiceImpl.getInstance().listMember());
		super.execute();
	}
}
