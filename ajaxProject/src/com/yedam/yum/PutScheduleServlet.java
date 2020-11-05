package com.yedam.yum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PutScheduleServlet")
public class PutScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PutScheduleServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String startDate = request.getParameter("start");
		String endDate = request.getParameter("end");
		
		EmpDAO dao = new EmpDAO();
		FullCalendar cal = new FullCalendar(title, startDate, endDate);
		dao.makeSchedule(cal);
		
		response.getWriter().append("success");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
