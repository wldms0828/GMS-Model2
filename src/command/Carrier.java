package command;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Sentry.cmd.getView() : "+ Sentry.cmd.getView());
		try {
			request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
