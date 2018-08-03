package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.*;

public class Commander {
	public static Command order(HttpServletRequest request,HttpServletResponse response) {
		Command cmd = null; // reference 변수
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE :
			System.out.println("---무브진입---");
			cmd = new MoveCommand(request);
			break;
		case JOIN : 
			System.out.println("---조인진입---");
			cmd = new CreateCommand(request);
			break;
			
		case UPDATEMEMBER : 
			System.out.println("---비번변경진입---");
			cmd = new UpdateCommand(request);
			break;
		case DELETEMEMBER :
			System.out.println("---회원탈퇴진입---");
			cmd = new DeleteCommand(request);
			break;
		case SEARCHBYNAME : 
			System.out.println("---이름검색---");
			cmd = new SearchCommand(request);
			cmd = new CountCommand(request);
			break;
		case RETRIEVE : 
			System.out.println("--아이디검색--");
			cmd = new RetrieveCommand(request);
			break;
		case LOGIN : 
			System.out.println("--로그인--");
			cmd = new LoginCommand(request);
			break;
		case MEMBERLIST : 
			System.out.println("--멤버전체목록--");
			cmd = new ListCommand(request);
			cmd = new CountCommand(request);
			break;

			//reference v
		default:
			break;
		}
		return cmd;
		//cmd는 죽지만 주소를 남기고 죽는다.
	}
	
}
