package command;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Reciever.cmd.getView() : "+ Reciever.cmd.getView());
		try {
			request.getRequestDispatcher(Reciever.cmd.getView()).forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}
	public static void redirect(HttpServletRequest request, HttpServletResponse response,String url) {
			try {
				response.sendRedirect(request.getContextPath() + url);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
