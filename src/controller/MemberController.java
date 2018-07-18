package controller;

import java.io.IOException;
import domain.*;
import enums.Action;
import pool.DBConstant;
import service.MemberServiceImpl;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import command.Carrier;
import command.Sentry;

@WebServlet({ "/member.do" }) // annotation @ , url-mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--MemberController()--");
		Sentry.init(request);
		System.out.println("액션 : " + Sentry.cmd.getAction());
		//String action = request.getParameter("action");
		//String page = request.getParameter("page");
		// String path = request.getServletPath();
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE :
			try {
				Carrier.send(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
			// DB접근하지 않아도 될 case와
			break;
		case JOIN :
				//String name = request.getParameter("NAME");
				//String ssn = request.getParameter("SSN");
				//String userId = request.getParameter("USERID");
				//String pass = request.getParameter("PASSWORD");
				MemberBean mem = new MemberBean();
				mem.setName(request.getParameter("NAME"));
				mem.setSsn(request.getParameter("SSN"));
				mem.setUserId(request.getParameter("USERID"));
				mem.setPassword(request.getParameter("PASSWORD"));
				//MemberServiceImpl.getInstance().createMember(mem);	
				response.sendRedirect(request.getContextPath() + "/member.do?action=move&page=user_login_form");
			// DB접근해야할 case
			break;
		case MEMBER_LIST:
			List<MemberBean> list = new ArrayList<>();
			list = MemberServiceImpl.getInstance().listMember();
			System.out.println(list);
			
			break;
		case SEARCH_BY_MEMBER_TEAM :
			String teamId = request.getParameter("TEAMID");
			MemberBean mem1 = new MemberBean();
			mem1.setTeamId(teamId);
			//MemberServiceImpl.getInstance().findMemberByName(name);
			
			response.sendRedirect(request.getContextPath() + "/member.do?action=move&page=searchTeamResult");
			break;
		case SEARCH_BY_MEMBER_ID:
			String id = request.getParameter("USERID");
			MemberBean mem2 = new MemberBean();
			mem2.setUserId(id);
			MemberServiceImpl.getInstance().findMemberById(id);
			break;
		case COUNT_MEMBER:
			MemberServiceImpl.getInstance().countMember();
			System.out.println("회원수 : " + MemberServiceImpl.getInstance().countMember());
			break;
		case UPDATE_MEMBER:
			System.out.println("비밀번호변경");
			String userId = request.getParameter("USERID");
			String pass = request.getParameter("PASSWORD")+
					"/"+
					request.getParameter("NEWPASSWORD");
			System.out.println("비밀번호 : " + pass);
			System.out.println("아이디 : " + userId);
			MemberBean mem3 = new MemberBean();
			mem3.setUserId(userId);
			mem3.setPassword(pass);
			MemberServiceImpl.getInstance().updateMember(mem3);
				break;
		case DELETE_MEMBER:
			//String userId = request.getParameter("USERID");
			//String pass = request.getParameter("PASSWORD");
			MemberBean mem4 = new MemberBean();
			mem4.setUserId(request.getParameter("USERID"));
			mem4.setPassword(request.getParameter("PASSWORD"));
			MemberServiceImpl.getInstance().deleteMember(mem4);
			
			break;
		case LOGIN:
			//String userId = request.getParameter("USERID");
			//String pass = request.getParameter("PASSWORD");
			MemberBean mem5 = new MemberBean();
			mem5.setUserId(request.getParameter("USERID"));
			mem5.setPassword(request.getParameter("PASSWORD"));
			MemberServiceImpl.getInstance().login(mem5);
			if(MemberServiceImpl.getInstance().login(mem5)) {
				System.out.println("로그인성공");
			}else {
				System.out.println("로그인실패");
			}
			break;

		}
		
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp");
		 */
		// rd.forward(request,response);
		// request.getRequestDispatcher() 의 return 타입은 RequestDispatcher
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
