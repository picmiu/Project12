package co.miu.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.miu.border.dao.BorderDao;
import co.miu.border.vo.BorderVo;


@WebServlet("/BorderSearch.do")
public class BorderSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BorderSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Controller에 module 구현
		request.setCharacterEncoding("utf-8");
		
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		
		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		vo = dao.selectSearch(vo);

		request.setAttribute("vo", vo);
		String viewPage = "jsp/border/borderEdit.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
