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


@WebServlet("/BorderEdit.do")
public class BorderEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BorderEditController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		
		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		vo.setBorderDate(Date.valueOf(request.getParameter("wdate")));
		vo.setBorderContent(request.getParameter("content"));
		int n = dao.update(vo);
		if(n != 0) {
			response.sendRedirect("/Board/BorderList.do");
		} else {
			String msg = " 수 정 실 패 ㅋ";
			request.setAttribute("msg", msg);
			String viewPage = "jsp/border/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
