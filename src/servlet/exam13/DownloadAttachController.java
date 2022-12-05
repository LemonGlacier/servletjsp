package servlet.exam13;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import util.Pager;

@WebServlet(name="exam13.DownloadAttachController", urlPatterns="/exam13/DownloadAttachController")
public class DownloadAttachController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardService boardService = (BoardService) request.getServletContext().getAttribute("boardService");
		Board board = boardService.getBoard(bno);
		
		String fileName = board.getBfileName();
		String filePath = "C:/Temp/download/" + board.getBsavedName();
		String contentType = board.getBfileType();
		
		//http 응답에  Content-Type 헤더 추가
		response.setContentType(contentType);
				
		//Browser의 종류 얻기
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			//IE일 경우(인터넷 익스플로러)
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			//Chrome, Edge, FileFox, Safari일 경우
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			
		}
		System.out.println(fileName);
		
		//http 응답에 Content-Disposition 헤더 추가
		response.setHeader("Content-Disposition", "attachment; filename = \"" +fileName+"\"");
		
		//http 응답 본문에 파일데이터 출력하기		
			/* 방법1
			FileInputStream fis = new FileInputStream(filePath);
			byte[] data = new byte[1024];
			while(true) { 		
				int readByteNum = fis.read(data);
				if(readByteNum == -1) break;
				sos.write(data,0,readByteNum);
			}
			sos.flush();
			fis.close();
			sos.close();
				 */
				
			//방법2
			Path path = Paths.get(filePath);
			ServletOutputStream sos =response.getOutputStream();
			Files.copy(path, sos);
			sos.flush();
			sos.close();
	
	}
	
}
