package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.*;

public class Commander {
	public static Command order(HttpServletRequest request,HttpServletResponse response) {
		Command cmd = null; // reference 변수
		System.out.println("action : "+request.getParameter("action"));
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE :
			System.out.println("---무브진입---");
			cmd = new MoveCommand(request);
			break;
		case ADD : 
			System.out.println("---조인진입---");
			cmd = new AddCommand(request);
			break;		
		case SEARCH : 
			System.out.println("--멤버전체목록--");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE : 
			System.out.println("--아이디검색--");
			cmd = new RetrieveCommand(request);
			break;
		case MODIFY : 
			System.out.println("---비번변경진입---");
			cmd = new ModifyCommand(request);
			break;
		case REMOVE :
			System.out.println("---회원탈퇴진입---");
			cmd = new RemoveCommand(request);
			break;
		case LOGIN : 
			System.out.println("--로그인--");
			cmd = new LoginCommand(request);
			break;
		case FILEUPLOAD :
			System.out.println("---무브진입---");
			cmd = new MoveCommand(request);
			break;

			//reference v
		default:
			break;
		}
		return cmd;
		//cmd는 죽지만 주소를 남기고 죽는다.
	}
	
}
