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
		String pageIndex = request.getParameter("pageIndex");
		PageProxy pxy = new PageProxy();
		System.out.println("pageIndex : "+pageIndex);
	int pn = (pageIndex==null)?1: Integer.parseInt(pageIndex);
	System.out.println("pn :" +pn);
	pxy.carryOut(pn);
	Pagination page = pxy.getPagination();
//		int count=MemberServiceImpl.getInstance().countMember();
//		System.out.println("count :" + count);
//		int beginPage = 1;
//		int endPage = 0;
//		int pageSize = 5;
//		int blockSize = 5;
//		int pageCount=(count%pageSize==0)?
//				count/pageSize:count/pageSize+1;
//		
//
//		if(count / pageSize>pageSize+1) {
//			if(count%5==0) {
//				endPage=count/pageSize;
//						
//						;}
//				else {
//				endPage=count/pageSize+1;
//;}
//		}else{
//			endPage=blockSize;
//		};	
//
////		boolean existPrev = false;
////		if(prevBlock>=0) {
////			existPrev =true;
////		}
////		boolean existnext=false;
////		if(nextBlock<=pagecCount) {
////			existnext=true;
////		}
		Map<String, Object> param = new HashMap<>();
		System.out.println("beginRow" + page.getBeginRow());
		System.out.println("endRow" + page.getEndRow());
		param.put("beginRow", String.valueOf(page.getBeginRow()));
		param.put("endRow", String.valueOf(page.getEndRow()));
		switch(Domain.valueOf(domain.toUpperCase())) {
		case ADMIN : 
		request.setAttribute("list", MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("page", page);



		break;
		default:
			break;
		}
		
		super.execute();
	}
}