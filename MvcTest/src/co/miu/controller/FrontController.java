package co.miu.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.miu.command.ActionCommand;
import co.miu.command.LoginFormActionCommand;
import co.miu.command.LoginResultActionCommand;
import co.miu.command.MainActionCommand;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")	//좀있다 써넣기
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, ActionCommand>	map = new HashMap<String, ActionCommand>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 여기에 요청 주소를 써넣으면 됨.
		map.put("/main.do", new MainActionCommand());
		map.put("/LoginForm.do", new LoginFormActionCommand());
		map.put("/LoginCheck.do", new LoginResultActionCommand());		
//		map.put("/main.do", new MainActionCommand());
//		map.put("/main.do", new MainActionCommand());	->이런 식으로 계속 담으면 됨. 여기만 계속 만들고 수정하면서 쓰면 됨. (수행할 command 있을때마다 만들어주기)
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기에 실제 서비스할 내용을 쓰면 됨.
		request.setCharacterEncoding("utf-8");  	//한글 깨짐 방지
		String uri = request.getRequestURI();		//요청 분석을 위해 URI 값을 구함.
		String contextPath = request.getContextPath();	//Context path값 구함.
		String path = uri.substring(contextPath.length());	//실제요청 경로를 구함.
		
		ActionCommand command = map.get(path);	//수행할 Model를 구하는 것. (값이 돌아옴. 위의  map.put에 담긴 값이!)
			String viewPage = command.action(request, response);	//Model 수행 후 결과의 jsp페이지를 돌려받음.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	//forward 객체 생성
			dispatcher.forward(request, response); 		//결과 페이지를 돌려준다.
	}		
}
