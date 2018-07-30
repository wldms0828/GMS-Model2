package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.*;

public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("비번변경입장");
			
			MemberBean mem3 = new MemberBean();
			mem3.setUserId(request.getParameter("USERID"));
			mem3.setPassword(request.getParameter("PASSWORD")+
					"/"+
					request.getParameter("NEWPASSWORD"));
			mem3.setTeamId(request.getParameter("TEAM_ID"));
			mem3.setRoll(request.getParameter("ROLL"));
			System.out.println(mem3);
			MemberServiceImpl.getInstance().updateMember(mem3);
			break;

		default:
			break;
		}
		super.execute();
	}
}
