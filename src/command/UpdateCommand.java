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
			mem3.setUserId(((MemberBean) request.getSession().getAttribute("user")).getUserId());
			//hidden을 사용하지 않고 session으로 아이디를 불러오는 방법
			//session->attribute->userId를 불러오는데 MemberBean으로 캐스트를 해줘야 가능하다.
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
