package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.*;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
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
			System.out.println("회원탈퇴입장");
			MemberBean mem4 = new MemberBean();
			mem4.setUserId(request.getParameter("USERID"));
			mem4.setPassword(request.getParameter("PASSWORD"));
			MemberServiceImpl.getInstance().deleteMember(mem4);
			System.out.println("회원탈퇴성공");
			break;

		default:
			break;
		}
		super.execute();
	}
}
