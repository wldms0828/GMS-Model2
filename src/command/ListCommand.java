package command;

import java.util.*;


import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.Action;
import enums.Domain;
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
		
		switch(Domain.valueOf(domain.toUpperCase())) {
		case ADMIN : 
		request.setAttribute("list", MemberServiceImpl.getInstance().listMember());
		int count=MemberServiceImpl.getInstance().countMember();
		request.setAttribute("count",(count%5==0)?count/5:count/5+1);
		
		break;
		default:
			break;
		}
		
		super.execute();
	}
}
