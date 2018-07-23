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
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("비번변경입장");
			String userId = request.getParameter("USERID");
			String pass = request.getParameter("PASSWORD")+
					"/"+
					request.getParameter("NEWPASSWORD");
			System.out.println("비밀번호 : " + pass);
			System.out.println("아이디 : " + userId);
			MemberBean mem3 = new MemberBean();
			mem3.setUserId(request.getParameter("USERID"));
			mem3.setPassword(request.getParameter("PASSWORD"));
			//MemberServiceImpl.getInstance().updateMember(mem3);
			break;

		default:
			break;
		}
		super.execute();
	}
}
