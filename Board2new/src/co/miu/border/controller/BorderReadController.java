package co.miu.border.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.miu.border.dao.BorderDao;
import co.miu.border.vo.BorderVo;

/**
 * Servlet implementation class BorderListController
 */
@WebServlet("/BorderRead.do")
public class BorderReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**		각각의 메소드 위에 어노테이션이 붙음. (무슨 말?ㅋ)
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO command 없이 여기서 다 처리하는 방법으로 구현 함.
		request.setCharacterEncoding("utf-8"); 		//한글 깨짐 방지
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		
		vo.setBorderId(Integer.valueOf(request.getParameter("id")));
		vo = dao.selectOne(vo);
		
		request.setAttribute("vo", vo);
		String viewPage = "jsp/border/borderRead.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
