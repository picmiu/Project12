package co.miu.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.miu.member.vo.MemberVo;

public class MemberDao {

		  private String driver = "oracle.jdbc.driver.OracleDriver";
		  private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		  private String user = "hr";
		  private String password = "hr";
		
		  private Connection conn; 
		  private PreparedStatement psmt;
		  private ResultSet rs;
	//	이 부분에 SQL 작성
    private final String MEMBERLOGIN  =
    		"SELECT * FROM MEMBER1 WHERE MEMBERID = ? AND PASSWORD = ?";
    
    private final String MEMBERS =
    		"SELECT * FROM MEMBER1";
    
    private final String MEMBERJOIN =
    		"INSERT INTO MEMBER1(MEMBERID, MEMBERNAME, PASSWORD, MEMBERAUTH) VALUES"
                    + "(?,?,?,?)";
    		
    
	public MemberDao() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);	
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연 결 실 패 ㅋ");
		}
	}
	
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<MemberVo> selectAll() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(MEMBERS);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public MemberVo select(MemberVo vo) {
		try {
			psmt = conn.prepareStatement(MEMBERS);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	
	public MemberVo memberLoginCheck(MemberVo vo) {
		try {
			psmt = conn.prepareStatement(MEMBERLOGIN);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	
	 public MemberVo memberJoin(MemberVo vo) {
	        try {
	        	psmt = conn.prepareStatement(MEMBERJOIN);
				psmt.setString(1, vo.getMemberId());
				psmt.setString(2, vo.getMemberName());
				psmt.setString(3, vo.getPassword());
				psmt.setString(4, vo.getMemberAuth());
				rs = psmt.executeQuery();
	        	
				if(rs.next()) {
					vo.setMemberId(rs.getString("memberid"));
					vo.setMemberName(rs.getString("membername"));
					vo.setPassword(rs.getString("password"));
					vo.setMemberAuth(rs.getString("memberauth"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
	            return vo;
	 	}
}
