package servlet.exam02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.ContentController", urlPatterns = "/exam02/ContentController")

public class ContentController extends HttpServlet {
	
	//서블릿 객체가 생성된 후 즉시 딱 한 번 호출
	//역할: 서블릿 객체의 초기화 작업
	/*
	@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿 객체의 초기화 코드
		System.out.println("exam02.ContentController.init() 실행");
	}*/
	
	//클라이언트가 요청할 때 마다 호출(콜백)(요청 방식(get/post)과는 상관 없다)
	//역할: 요청 처리
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/content.jsp").forward(request, response);
	}
	

}
