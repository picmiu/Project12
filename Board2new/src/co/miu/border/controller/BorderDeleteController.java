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


@WebServlet("/BorderDelete.do")
public class BorderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BorderDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 여기에 삭제하는 것을 만들어 보세요. (중간 실습 과제)
		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		
		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		int n = dao.delete(vo);
		if(n != 0) {
			response.sendRedirect("/Board/BorderList.do");
		} else {
			String msg = " 삭 제  실 패 ㅋ";
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
