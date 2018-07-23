package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		//domain 을 Sentry.cmd.domain으로 하면 move가 아직 create 로 바뀌지 않은 상태이기 때문에 nullpointException 에러가 뜬다.
		case MEMBER:
			System.out.println("회원가입입장");
			MemberBean mem = new MemberBean();
			mem.setName(request.getParameter("NAME"));
			mem.setSsn(request.getParameter("SSN"));
			mem.setUserId(request.getParameter("USERID"));
			mem.setPassword(request.getParameter("PASSWORD"));
			MemberServiceImpl.getInstance().createMember(mem);
			System.out.println("회원가입성공");
	
			break;

		default:
			break;
		}
		super.execute();
	}
}
