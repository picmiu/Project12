package com.yedam.yum;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetMemberPerDeptServ")
public class GetMemberPerDeptServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetMemberPerDeptServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();	//반드시 기억할 것. 생성자 호출.
		Map<String, Integer> members = dao.getMemberPerDept();
		Set<String> keySet = members.keySet();
		String json = "[";
		int cnt = 0, dataLength = keySet.size();
		for(String key : keySet) {
			System.out.println(key + ", " + members.get(key) + "}");
			cnt++;
			if(cnt != dataLength) {
				json += ",";
			}
		}
		json += "]";
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
