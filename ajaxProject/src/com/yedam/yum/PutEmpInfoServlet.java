package com.yedam.yum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PutEmpInfoServlet")
public class PutEmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutEmpInfoServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String salary = request.getParameter("salary");

        EmpDAO dao = new EmpDAO();
        dao.updateEmpInfo(id, firstName, lastName, salary);
        
        response.getWriter().append("complete");
    		}
     }