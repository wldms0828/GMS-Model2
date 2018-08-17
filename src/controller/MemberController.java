package controller;

import java.io.*;
import java.nio.file.Path;

import domain.*;
import enums.Action;
import enums.Term;
import pool.DBConstant;
import service.ImageServiceImpl;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.SearchCommand;
import command.Reciever;

@WebServlet("/member.do") // annotation @ , url-mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--MemberController()--");
		Reciever.init(request, response);
		System.out.println("멤버 컨트롤 액션 : "+request.getParameter("action"));
		System.out.println("액션 : " + Reciever.cmd.getAction());
		
		switch (Action.valueOf(Reciever.cmd.getAction().toUpperCase())) {
		
		case ADD :
				System.out.println("JOIN");
				Carrier.forward(request, response);					
				// DB접근해야할 case
			break;
		case SEARCH: case RETRIEVE: 
			System.out.println("--MEMBERLIST--");
			Carrier.forward(request, response);
			break;
		case MODIFY: 
			System.out.println("UPDATE");
			Carrier.redirect(request, response, "/member.do?action=retrieve");			
				break;
		case FILEUPLOAD :
			System.out.println("======[1]=====");
			if(!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			System.out.println("======[2]=====업로드파일존재함");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload  = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1027*40);//40MB
			upload.setFileSizeMax(1024*1027*50);//50MB
			List<FileItem> items = null;
			try {
				System.out.println("======[3]=====try 내부로 진입");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				Map<String, Object> map = new HashMap<>();
				System.out.println("======[4]===== items 생성");
				Iterator<FileItem> iter = items.iterator();
						while(iter.hasNext()) {
							System.out.println("======[5]===== while 진입");
							FileItem item = (FileItem)iter.next();
							if(!item.isFormField()) {
								System.out.println("======[6]===== if 진입");
								String fileName = item.getName();
								System.out.println("fileName : " + fileName);
								file=new File(Term.UPLOADPATH+fileName);
								item.write(file);
								System.out.println("======[7]=====파일업로드 성공");
								map.put("IMGNAME", fileName.substring(0, fileName.indexOf(".")));
								map.put("EXTENSION",fileName.substring(fileName.indexOf(".")+1));
								map.put("USERID", ((MemberBean)request.getSession().getAttribute("member")).getUserId());
								ImageServiceImpl.getInstance().create(map);

							}else {
								System.out.println("======[8]=====파일업로드 실패");
							}
						}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("=======[10]=======");
			Carrier.redirect(request, response, "/member.do?action=retrieve");
			break;
		case REMOVE:
			System.out.println("DELETE");
			Carrier.redirect(request, response, "");
				break;
		case MOVE :
			System.out.println("MOVE");
			Carrier.forward(request, response);

		break;

		case LOGIN:
			System.out.println("--LOGIN--");
			if(request.getAttribute("match").equals("TRUE")){
				System.out.println("!!!! 멤버컨트롤러 로그인 !!!!");
				System.out.println(
						request.getSession().getAttribute("user"));
				Carrier.forward(request, response);

				}else {
				Carrier.redirect(request, response, "/member.do?action=move&page=login");
			}
			break;
		default : 
				Carrier.redirect(request, response, "");
			break;
		}
		
	}


}
