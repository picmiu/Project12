package co.miu.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginResultActionCommand implements ActionCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String msg = null;
		
		if(id.equals("hong") && password.equals("1234")) {
			msg = "홍길동 님 환영합니다.";
		} else {
			msg = id + "님 아이디 또는 패스워드가 일치하지 않습니다.";
		}
		
		//System.out.println(msg);
		request.setAttribute("msg", msg);	//메세지를 보여줄 페이지에 전달한다. (key값 변수명, data값)
		//	위 문장은  처리한 data를 request 객체에 실어 보낸다.
		return "jsp/member/LoginCheck.jsp";
	}
}
