package com.yedam.book;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookDAO extends DAO {

	static BookDAO instance;

	public static BookDAO getInstance() {
		if (instance != null)
			return instance;
		else
			return new BookDAO();
	}

	// 댓글목록
	public List<HashMap<String, Object>> selectAll(String book_no) throws Exception {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from BOOK order by book_no ");
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("book_no", rs.getString("book_no"));
				map.put("book_title", rs.getString("book_title"));
				map.put("book_author", rs.getString("book_author"));
				map.put("book_price", rs.getString("book_price"));
				list.add(map);
			}
		} catch (Throwable e) {
			System.out.println("book selectAll error" + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return list;
	}// end of method

	public HashMap<String, Object> update(Book bk) throws Exception { // update
		PreparedStatement pstmtBookInsert = null;
		try {
			connect();
			conn.setAutoCommit(false); // 트랜잭션 처리
			String sql = "update BOOK set book_title=?, book_author=?, book_price=? where book_no=? "; // sql 명령문 수정?
			pstmtBookInsert = conn.prepareStatement(sql);
			pstmtBookInsert.setString(1, bk.getBook_no());
			pstmtBookInsert.setString(2, bk.getBook_title());
			pstmtBookInsert.setString(3, bk.getBook_author());
			pstmtBookInsert.setString(4, bk.getBook_price());
			pstmtBookInsert.executeUpdate();
			conn.commit(); // 커밋
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("book_no", bk.getBook_no());
			map.put("book_title", bk.getBook_title());
			map.put("book_author", bk.getBook_author());
			map.put("book_price", bk.getBook_price());
			return map;
		} catch (Throwable e) {
			try {
				conn.rollback(); // 롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
	}

	public HashMap<String, Object> delete(Book bk) throws Exception { // 삭제
		PreparedStatement pstmtBookInsert = null;
		try {
			connect();
			conn.setAutoCommit(false); // 트랜잭션 처리
			String sql = "delete BOOK where book_no=? ";
			pstmtBookInsert = conn.prepareStatement(sql);
			pstmtBookInsert.setString(1, bk.getBook_no());
			pstmtBookInsert.executeUpdate();
			conn.commit(); // 커밋
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("no", bk.getBook_no());
			return map;
		} catch (Throwable e) {
			try {
				conn.rollback(); // 롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
	}

	public HashMap<String, Object> insert(Book bk) throws Exception {
		Statement stmtIdSelect = null;
		ResultSet rsIdSelect = null;
		PreparedStatement pstmtIdUpdate = null;
		PreparedStatement pstmtBookInsert = null;
		int nextBook_No = 0;
		System.out.println(bk);
		try {
			connect();
			conn.setAutoCommit(false); // 트랜잭션 처리
			stmtIdSelect = conn.createStatement();
			rsIdSelect = stmtIdSelect.executeQuery("select VALUE from ID_REPOSITORY where NAME='BOOK'");
			if (rsIdSelect.next()) {
				nextBook_No = rsIdSelect.getInt("VALUE");
			}
			nextBook_No++; // 시퀀스 용도
			pstmtIdUpdate = conn.prepareStatement("update ID_REPOSITORY set VALUE = ? where NAME='BOOK'");
			pstmtIdUpdate.setInt(1, nextBook_No);
			pstmtIdUpdate.executeUpdate();

			pstmtBookInsert = conn.prepareStatement("insert into BOOK(book_no, book_title, book_author, book_price) values (?, ?, ?, ?)");
			pstmtBookInsert.setInt(1, nextBook_No);
			pstmtBookInsert.setString(2, bk.getBook_title());
			pstmtBookInsert.setString(3, bk.getBook_author());
			pstmtBookInsert.setString(4, bk.getBook_price());
			pstmtBookInsert.executeUpdate();
			conn.commit(); // 커밋
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("Book_no", nextBook_No);
			map.put("Book_title", bk.getBook_title());
			map.put("Book_author", bk.getBook_author());
			map.put("Book_price", bk.getBook_price());
			return map;
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		}
	}

	// 등록(프로시져)
	public HashMap<String, Object> insertProc(Book bk) throws Exception {
		CallableStatement cstmt = null;
		int nextBook_Id = 0;
		try {
			connect();
			conn.setAutoCommit(false); // 트랜잭션 처리
			cstmt = conn.prepareCall("{call BOOK_INS(?,?,?,?,?)}");
			cstmt.setString(1, bk.getBook_no());
			cstmt.setString(2, bk.getBook_title());
			cstmt.setString(3, "1");
			cstmt.registerOutParameter(4, java.sql.Types.NUMERIC);
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);

			cstmt.executeUpdate();
			conn.commit(); // 커밋
			nextBook_Id = cstmt.getInt(4);
			String out_msg = cstmt.getString(5);
			System.out.println(out_msg);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("Book_no", bk.getBook_no());
			map.put("Book_title", bk.getBook_title());
			map.put(("Book_author"), bk.getBook_author());
			map.put(("Book_price"), bk.getBook_price());
			return map;
		} catch (Throwable e) {
			try {
				conn.rollback(); // 롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		}
	}

}// end of class
