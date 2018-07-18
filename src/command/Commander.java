package command;

import enums.*;

public class Commander {
	public static Command order(String domain,String action, String page) {
		Command cmd = null;
		switch (Action.valueOf(action.toUpperCase())) {
		case MOVE :
			System.out.println("---무브진입---");
			cmd = new MoveCommand(domain,action,page);
			break;
		case JOIN : 
			System.out.println("---조인진입---");
			cmd = new CreateCommand(domain,action,page);
			break;
		case SEARCH_BY_MEMBER_TEAM : 
			
		default:
			break;
		}
		return cmd;
	}
	
}
