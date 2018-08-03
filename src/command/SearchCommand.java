package command;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import domain.*;
import service.*;

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
		System.out.println("---팀명,이름 검색 입장---"); 
		String searchOption=request.getParameter("searchOption");
		String search = request.getParameter("search");
		String page=request.getParameter("page");
		String action=request.getParameter("action");
		String domain=super.domain;
		String searchName = request.getParameter("search") + "/" + request.getParameter("searchOption");
		System.out.println("searchOption : " + searchOption);
		System.out.println("search : " + search);
		System.out.println("page : " + page);
		System.out.println("action : " + action);
		System.out.println("domain : " + domain);		
		
		request.setAttribute("list", MemberServiceImpl.getInstance().findMemberByName(searchName));
		System.out.println("이름 입력 : " + MemberServiceImpl.getInstance().findMemberByName(searchName));
		System.out.println("---팀명,이름 검색성공 ---");
		super.execute();
	}
}
