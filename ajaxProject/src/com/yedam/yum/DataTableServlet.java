package com.yedam.yum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/DataTableServlet")
public class DataTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DataTableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	EmpDAO dao = new EmpDAO() ;
	List<Employee> employees = dao.getEmpList();
	int dataCnt = employees.size();
	JSONObject obj = new JSONObject();
	obj.put("draw", 1);
	obj.put("recordsTotal", dataCnt);
	obj.put("recordsFiltered", dataCnt);
	JSONArray oAry = new JSONArray();
	JSONArray iAry = new JSONArray();
	
	for (Employee emp : list) {
		iAry = new JSONArray();
		iAry.add(emp.getEmployeeId());
		iAry.add(emp.getFirstName());
		iAry.add(emp.getEmail());
		iAry.add(emp.getHireDate());
		iAry.add(emp.getSalary());
		
		oAry.add(iAry);
	}
	
	obj.put("data",oAry);
	
	response.getWriter().append(obj.toString());

}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
