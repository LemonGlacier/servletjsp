<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		JSP와 서블릿의 차이점
	</div>
	<div class="card-body">
		<%--서블릿을 거치지 않고 그냥 jsp를 호출  (jsp=뷰)--%>
		<a href="/servletjsp/views/exam01/boardList.jsp" class = "btn btn-info btn-sm">JSP 요청</a>
		<%--서블릿을 통해서 jsp 파일로 감 // 서블릿: WEB-INF 안에 파일이 있어야 한다 (서블릿=컨트롤러)--%>
		<a href="/servletjsp/exam01/BoardListController" class = "btn btn-info btn-sm">Servlet 요청</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>