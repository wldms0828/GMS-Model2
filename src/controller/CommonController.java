package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enums.Domain;
import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CTX,CSS,JS,IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = 0;
		for(Resources r : Resources.values()) {

			request.getSession().setAttribute(r.toString().toLowerCase(),
				(i==0)?
					request.getContextPath():
							request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			
		i++;
	}
		/*	if(i==0) {
		request.getSession().setAttribute(r.toString().toLowerCase(),
				request.getContextPath());
		}else {
			System.out.println(request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			request.getSession().setAttribute(r.toString().toLowerCase(),request.getContextPath()+"/resources/"+r.toString());
		}
	i++;
}*/
/*		HttpSession session = request.getSession();
		session.setAttribute(Domain.CTX.toString(), request.getContextPath());*/
		request.getRequestDispatcher(Term.WEBPATH.toString()+Term.MAIN.toString()).forward(request, response);
		
	}

}
