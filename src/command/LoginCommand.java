package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".") ));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("--로그인진입--");
			MemberBean mem5 = new MemberBean();
			mem5.setUserId(request.getParameter("USERID"));
			mem5.setPassword(request.getParameter("PASSWORD"));
			
			if(MemberServiceImpl.getInstance().login(mem5)) {
				request.setAttribute("match", "TRUE");
				request.getSession().setAttribute("user",
						MemberServiceImpl.getInstance().retrive(request.getParameter("USERID")));
				System.out.println("로그인성공");
		
			}else {
				request.setAttribute("match", "FALSE");
				System.out.println("로그인실패");
			}
			System.out.println("--로그인페이지 끝--");
			break;

		default:
			break;
		}
		
		super.execute();
	}
}
