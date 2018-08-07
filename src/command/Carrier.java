package command;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Sentry.cmd.getView() : "+ Sentry.cmd.getView());
		//모든 정보를 request,response 에 담아서 페이지를 이동하는 기능
		try {
			request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public static void redirect(HttpServletRequest request, HttpServletResponse response,String url) {
		//페이지 이동만 하는 기능	
		try {
				response.sendRedirect(request.getContextPath() + url);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
