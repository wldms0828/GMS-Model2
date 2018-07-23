package command;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class SearchTeamCommand extends Command {
	
	public SearchTeamCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("---팀이름 입장---");
		request.setAttribute("team", MemberServiceImpl.getInstance().findMemberByName(request.getParameter("TEAMID")));
		System.out.println("---팀이름 검색성공 ---");
		super.execute();
	}
}
