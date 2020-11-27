package co.miu.border.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.miu.border.dao.BorderDao;
import co.miu.border.vo.BorderVo;


@WebServlet("/BorderInput.do")
public class BorderInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BorderInputController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Command 구현 없이 이곳에서 다 처리함.
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		vo.setBorderWriter(request.getParameter("wirter"));
		vo.setBorderDate(Date.valueOf(request.getParameter("wdate")));
		vo.setBorderTitle(request.getParameter("title"));
		vo.setBorderContent(request.getParameter("content"));
		
	      String viewPage;
	      int n = dao.insert(vo);
	      //벨리데이션 방법 
	      if(n != 0) {
	         response.sendRedirect("/Board/BorderList.do");
	         //	어노테이션 기반에서 서블릿 호출시에는 response 객체를 이용해서 권한을 돌린다.
	     
	      } else {
	    	 String msg = "데이터베이스에 정상적으로 입력하지 못했습니다.";
	    	 request.setAttribute("msg", msg);
	         viewPage = "jsp/border/inputError.jsp";
	         RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	         dispatcher.forward(request, response);
	   }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
