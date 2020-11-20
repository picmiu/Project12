package co.miu.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainActionCommand implements ActionCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// main.do 요청이 오면 main.jsp를 보여주는 것.
		return "jsp/main/main.jsp";
	}

}
