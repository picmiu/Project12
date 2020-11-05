package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
   public static Connection getCon() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "hr";
      String password = "hr";
      Connection conn = null;// 연결객체. return해야하기 때문에 초기화.
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, user, password);
         System.out.println("연결성공");
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("DB연결실패");

      }
      return conn;

   }
}