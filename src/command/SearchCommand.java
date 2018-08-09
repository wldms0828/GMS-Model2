package command;

import java.util.*;


import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.Action;
import enums.Domain;
import oracle.net.aso.r;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command {

	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();

	}
	@Override
	public void execute() {
	switch(Domain.valueOf(domain.toUpperCase())) {
		case ADMIN :
		System.out.println("1.");
		Map<String, Object> param = new HashMap<>();
		String pageIndex = request.getParameter("pageIndex");
		PageProxy pxy = new PageProxy();
	int pn = (pageIndex==null)?
			1 : Integer.parseInt(pageIndex);
	pxy.carryOut(pn);
	Pagination page = pxy.getPagination();
		param.put("beginRow", String.valueOf(page.getBeginRow()));
		param.put("endRow", String.valueOf(page.getEndRow()));
		System.out.println(pxy.getPagination().getPageIndex());
		System.out.println("2. beginRow" + page.getBeginRow());
		System.out.println("3. endRow" + page.getEndRow());
		request.setAttribute("page", page);
		request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
		
		


		break;
		default:
			break;
		}
		
		super.execute();
	}
}