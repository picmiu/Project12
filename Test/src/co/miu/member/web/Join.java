package co.miu.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.miu.member.dao.MemberDao;
import co.miu.member.vo.MemberVo;


@WebServlet("/Join.do")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Join() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 회원관리와 관련된 모든 것을 처리하기.
		request.setCharacterEncoding("utf-8");
		MemberVo vo = new MemberVo();
		MemberDao dao = new MemberDao();	
		HttpSession session = request.getSession(false);	//세션 객체를 가져온다.
		
		vo.setMemberId(request.getParameter("mid"));
		vo.setMemberName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.memberJoin(vo);
		
		String viewPage = "jsp/member/member.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		doGet(request, response);
	}

}
