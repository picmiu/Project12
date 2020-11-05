package com.yedam.yum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.common.DBCon;

public class EmpDAO {
   PreparedStatement psmt;
   ResultSet rs;
   Connection conn;
   
   public void deleteSchedule(String title, String startDate) {
	   conn = DBCon.getCon();
	   String sql = "delete from fullcalendar"	//
			   + "where title=? and substr(start_date,1,10)=?";
	   try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, startDate);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}			
	}

   
   public void makeSchedule(FullCalendar cal) {
	   conn = DBCon.getCon();
	   String sql = "insert into fullcalendar values(?,?,?)";
	   try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, cal.getTitle());
		psmt.setString(2, cal.getStartDate());
		psmt.setString(3, cal.getEndDate());
		
		int r = psmt.executeUpdate();
		System.out.println(r + "건 입력.");
		
	} catch (SQLException e) {

		e.printStackTrace();
	}
   }
   
   public List<FullCalendar> getSchedules() {
	   conn = DBCon.getCon();
	   String sql = "select * from fullcalendar";
	   List<FullCalendar> schedules = new ArrayList<>();
	   try {
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
	      while(rs.next()) {
	          FullCalendar cal = new FullCalendar(rs.getString("title"), rs.getString("startDate"),
	                                              rs.getString("endDate"));
		}
	   } catch (SQLException e) {
		e.printStackTrace();
	   }
	   return null;
   }
  
   
   public Map<String, Integer> getMemberPerDept() {
	   conn = DBCon.getCon();
	   String sql = "select d.department_name, e.cnt\r\n" + 
	   		"from (select department_id, count(*) as cnt\r\n" + 
	   		"from employees\r\n" + 
	   		"group by department_id) e, departments d\r\n" + 
	   		"where e.department_id = d.department_id;";
	   Map<String, Integer> memberPerDept = new HashMap<>();
	   try {
		   psmt = conn.prepareStatement(sql);
		   rs = psmt.executeQuery();
		   while(rs.next()) {
			   memberPerDept.put(rs.getNString("department_name"), rs.getInt("cnt"));		
		   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   try {
			   conn.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		   }
	   }
	   return memberPerDept;
   }
   
   //GetEmpInfoServlet 만듦
    //public Employee getEmpInfo(int empId) { //한건을 가지고 조회해보는 쿼리 
   
// 수정기능 추가
   public void updateEmpInfo(String eid, String f, String l, String s) {
      conn = DBCon.getCon();
      String sql = "update employees set salary = ? where employee_id = ?";
      
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, s);
         psmt.setString(2, eid);
         int r = psmt.executeUpdate();
         System.out.println(r + "건 변경완료");
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
   }
   
   public Employee getEmpinfo(String empId) {
      conn = DBCon.getCon();
      Employee emp = new Employee();
      try {
      psmt = conn.prepareStatement("select * from employees where employee_id = ?");
      psmt.setString(1, empId);
      rs = psmt.executeQuery();
      if(rs.next()) {
         emp.setEmployeeId(rs.getInt("employee_id"));
         emp.setFirstName(rs.getString("first_name"));
         emp.setLastName(rs.getString("last_name"));
         emp.setEmail(rs.getString("email"));
         emp.setPhoneNumber(rs.getString("phone_number"));
         emp.setHireDate(rs.getString("hire_date"));
         emp.setJobId(rs.getString("job_id"));
         emp.setSalary(rs.getInt("salary"));
         emp.setCommissionPct(rs.getDouble("commission_pct"));
         emp.setManagerId(rs.getInt("manager_id"));
         emp.setDepartmentId(rs.getInt("department_id"));
      }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        }      
        return emp;
   }

   
   public List<Employee> getEmpList() {
      conn = DBCon.getCon();
      List<Employee> employees = new ArrayList<>();
      try {
         psmt = conn.prepareStatement("select * from employees order by 1");
         rs = psmt.executeQuery(); //값을 가지고 와 담는다.
         while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmployeeId(rs.getInt("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setPhoneNumber(rs.getString("phone_number"));
            emp.setHireDate(rs.getString("hire_date"));
            emp.setJobId(rs.getString("job_id"));
            emp.setSalary(rs.getInt("salary"));
            emp.setCommissionPct(rs.getDouble("commission_pct"));
            emp.setManagerId(rs.getInt("manager_id"));
            emp.setDepartmentId(rs.getInt("department_id"));
            
            employees.add(emp);
         }
         
      }catch (SQLException e) {
         e.printStackTrace();
      }
      return employees;

   }
}