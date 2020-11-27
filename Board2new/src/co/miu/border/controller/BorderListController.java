package co.miu.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.miu.border.command.BorderList;
import co.miu.common.BorderCommand;

@WebServlet("/BorderList.do")	//Q.수정?
public class BorderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public BorderListController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	여기가 게시판 관련 처리.
		request.setCharacterEncoding("utf-8");		//한글처리
		BorderCommand command = new BorderList();	//실행 명령 선언 (적당한 command 선언)
		String viewPage = command.action(request, response);	//실행 명령어 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	//forward 시키는 것. 보여줄 페이지 선택
		dispatcher.forward(request, response);
		
	}

}
