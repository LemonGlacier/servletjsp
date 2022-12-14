package servlet.exam03;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name="exam03.ContentController", urlPatterns="/exam03/ContentController")
public class ContentController extends HttpServlet{
	private String encoding;
	private String viewlocation;
	
	//클라이언트에서 최초로 서블릿을 요청했을 때 딱 한 번 실행(load-on-startup 옵션이 없을 경우)
	//load-on-startup이 있을 경우 Deployment 시에 딱 한 번 실행
	//역할: service(), doGet(), doPost()에서 사용화는 데이터를 초기화해주는 역할
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("exam03.ContentController.init() 실행");
		
		if(config.getInitParameter("encoding") == null) {
			encoding="UTF-8";
		} else {
			encoding = config.getInitParameter("encoding");
		}
		
		if(config.getInitParameter("viewlocation") == null) {
			viewlocation = "/WEB-INF/views";
		} else {
			viewlocation = config.getInitParameter("viewlocation");
		}
		
		System.out.println(config.getInitParameter("encoding"));
		System.out.println(config.getInitParameter("viewlocation"));
		
	}
	
	//클라이언트가 요청할 때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doGet() 실행");
		request.getRequestDispatcher(viewlocation+"/exam03/content.jsp").forward(request, response);
	}
	
	//클라이언트가 요청할 때 마다 실행
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doPost() 실행");
		
		request.setCharacterEncoding(encoding);
		
		String param1 = request.getParameter("param1");
		System.out.println("param1: "+param1);
		
		request.getRequestDispatcher(viewlocation+"/exam03/content.jsp").forward(request, response);
	}
	
	//서블릿이 제거될 때 (Undeployment)
	@Override
	public void destroy() {
		System.out.println("exam03.ContentController.destroy() 실행");
	}
}
