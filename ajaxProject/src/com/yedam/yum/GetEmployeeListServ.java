package com.yedam.yum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmployeeListServ")
public class GetEmployeeListServ extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public GetEmployeeListServ() {
        super();
        // TODO Auto-generated constructor stub
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath()).append("<b>Hello</b>"); // getContextPath: 최상위 위치를 보여줌
//      {"name":"Hong", "age":20, "score":80}   // json object
//      String json = "{\"name\":\"Hong\", \"age\":20, \"score\":80}";
      
      EmpDAO dao = new EmpDAO();
      List<Employee> list = dao.getEmpList();
      
      String json = "[";   //js object type의 모양으로 바꿔줘야함
      
      int dataCnt = list.size();   //object 간에 쉼표 붙이고 마지막 object 뒤에는 쉼표 없도록
      int i = 0;
      for(Employee emp : list) {
         json += "{\"id\":\"" + emp.getEmployeeId() 
         + "\", \"firstName\":\"" + emp.getFirstName()
         + "\", \"lastName\":\"" + emp.getLastName() 
         + "\", \"email\":\"" + emp.getEmail()
         + "\", \"phoneNumber\":\"" + emp.getPhoneNumber() 
         + "\", \"hireDate\":\"" + emp.getHireDate()
         + "\", \"jobId\":\"" + emp.getJobId() 
         + "\", \"salary\":\"" + emp.getSalary()
         + "\", \"commisionPct\":\"" + emp.getCommissionPct() 
         + "\", \"managerId\":\"" + emp.getManagerId()
         + "\", \"departmentId\":\"" + emp.getDepartmentId() + "\"}";
         i++;
         if(i!=dataCnt) {
            json += ", ";
         }
      }
      json += "]";
      
//      for(Employee emp : list) {
//         json += "{\"id\":" + emp.getEmployeeId() + ", \"firstName\":\"" + emp.getFirstName()
//         + "\", \"lastName\":\"" + emp.getLastName() + "\", \"email\":\"" + emp.getEmail()
//         + "\", \"phoneNumber\":\"" + emp.getPhoneNumber() + "\", \"hireDate\":\"" + emp.getHireDate()
//         + "\", \"jobId\":" + emp.getJobId() + ", \"salary\":" + emp.getSalary()
//         + ", \"commisionPct\":" + emp.getCommissionPct() + ", \"managerId\":" + emp.getManagerId()
//         + ", \"departmentId\":" + emp.getDepartmentId()+ "}";
//      }
      
      response.getWriter().append(json);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}