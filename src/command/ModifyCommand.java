package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.*;

public class ModifyCommand extends Command{
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Reciever.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("비번변경입장");
			Map<String, Object> map=new HashMap<>();
			MemberBean mem3= new MemberBean();
			mem3.setUserId(((MemberBean) request.getSession().getAttribute("user")).getUserId());
			//hidden을 사용하지 않고 session으로 아이디를 불러오는 방법
			//session->attribute->userId를 불러오는데 MemberBean으로 캐스트를 해줘야 가능하다.
			mem3.setPassword(request.getParameter("PASSWORD")+
					"/"+
					request.getParameter("NEWPASSWORD"));
			mem3.setTeamId(request.getParameter("TEAM_ID"));
			mem3.setRoll(request.getParameter("ROLL"));
			System.out.println(mem3);
			MemberServiceImpl.getInstance().modify(map);
			break;

		default:
			break;
		}
		super.execute();
	}
}
