package controller;

import java.io.*;
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
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import command.Carrier;
import command.SearchCommand;
import command.SearchCommand;
import command.Sentry;

@WebServlet("/member.do") // annotation @ , url-mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--MemberController()--");
		Sentry.init(request, response);
		System.out.println("액션 : " + Sentry.cmd.getAction());
		
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE :
				System.out.println("MOVE");
				Carrier.forward(request, response);
		
			//request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
			// DB접근하지 않아도 될 case와
			break;
		case JOIN :
				
				System.out.println("JOIN");
				Carrier.forward(request, response);
		
				
				// DB접근해야할 case
			break;
		case UPDATEMEMBER:
			System.out.println("UPDATE");
			Carrier.redirect(request, response, "");
			
				break;
		case DELETEMEMBER:
			System.out.println("DELETE");
			Carrier.redirect(request, response, "");
			break;
		case MEMBERLIST:case SEARCHBYNAME : case RETRIEVE:
			System.out.println("--MEMBERLIST--");
			Carrier.redirect(request, response, "");
			
			break;

		case COUNTMEMBER:
			
			MemberServiceImpl.getInstance().count();
			System.out.println("회원수 : " + MemberServiceImpl.getInstance().count());
			break;
		case LOGIN:
			System.out.println("--LOGIN--");
			if(request.getAttribute("match").equals("TRUE")){
				/*HttpSession s =*/
				/*request.getSession().
					setAttribute("user", request.getAttribute("user"));*/
				System.out.println(request.getAttribute("user"));
				//servlet(interface)과 JSP(interface) 을 구현한 container이기 때문에 
				//MemberController 에 끌고 나와서 선언해준다
//				Sentry.cmd.setPage("mypage");
//				Sentry.cmd.execute();
				Carrier.forward(request, response);

				}else {
				Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			}
			break;
		default : 
				Carrier.redirect(request, response, "");
			break;
		}
		
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp");
		 */
		// rd.forward(request,response);
		// request.getRequestDispatcher() 의 return 타입은 RequestDispatcher
	}


}
