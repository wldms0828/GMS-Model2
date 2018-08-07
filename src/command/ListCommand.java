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
		String pageIndex = request.getParameter("pageIndex");
		String pageIndex2= "";
	if(pageIndex==null) {
		System.out.println("넘어온 페이지 번호가 없다요");
		pageIndex2="1";
	}else {
		System.out.println("넘어온 페이지 번호"+pageIndex);
		pageIndex2=pageIndex;
	}

		int count=MemberServiceImpl.getInstance().countMember();
		System.out.println("count :" + count);
		int beginPage = 1;
		int endPage = 0;
		int pageSize = 5;
		int blockSize = 5;

		if(count / pageSize>pageSize+1) {
			if(count%5==0) {
				endPage=count/pageSize;
						
						;}
				else {
				endPage=count/pageSize+1;
;}
		}else{
			endPage=blockSize;
		};	
		String existPrev = "";
		String existnext = "";
		String nextBlock = "";
	
	request.setAttribute("existPrev", true);	
//		boolean existPrev = false;
//		if(prevBlock>=0) {
//			existPrev =true;
//			
//		}
//		boolean existnext=false;
//		if(nextBlock<=pagecCount) {
//			existnext=true;
//		}
		Map<String, Object> param = new HashMap<>();
		String beginRow=String.valueOf((Integer.parseInt(pageIndex2)-1) * pageSize + 1) ;
		String endRow= String.valueOf(pageSize * (Integer.parseInt(pageIndex2)));
		System.out.println("beginRow" + beginRow);
		System.out.println("endRow" + endRow);
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		switch(Domain.valueOf(domain.toUpperCase())) {
		case ADMIN : 
		request.setAttribute("list", MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("count", count);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage );


		break;
		default:
			break;
		}
		
		super.execute();
	}
}
