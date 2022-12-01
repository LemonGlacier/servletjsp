package servlet.exam07;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="exam07.RemoveSessionController", urlPatterns="/exam07/RemoveSessionController")
public class RemoveSessionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			
			//세션에 저장된 데이터(객체) 제거
			session.removeAttribute("loginId");
			session.removeAttribute("loginDate");
			session.removeAttribute("cart");
			
			//HttpSession 객체 자체를 제거
			//session.invalidate();
			
			response.sendRedirect("ContentController");
		}		
	
		
	
}
