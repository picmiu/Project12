package com.yedam.cafe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DBCon;
import com.yedam.yum.FullCalendar;

public class ProductDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;


	public void insertproduct(Product p) {
		conn = DBCon.getCon();
		String sql = "insert into Product values(?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p.getItemNo());
			psmt.setString(2, p.getItemName());
			psmt.setInt(3, p.getPrice());
			psmt.setString(4, p.getItemDesc());
			psmt.setDouble(5, p.getLikeIt());
			psmt.setString(6, p.getCategory());
			psmt.setString(7, p.getItemImg());

			int r = psmt.executeUpdate();
			System.out.println(r + "건입력");

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

	public List<Product> getProductList(String category) {
		conn = DBCon.getCon();
		String sql = "select * from product where category = nvl(\'"+category+"\' , category)" ;
		List<Product> products = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				prod.setItemNo(rs.getString("item_No"));
				prod.setItemName(rs.getString("Item_Name"));
				prod.setPrice(rs.getInt("price"));
				prod.setItemDesc(rs.getString("item_desc"));
				prod.setLikeIt(rs.getDouble("like_It"));
				prod.setCategory(rs.getString("category"));
				prod.setItemImg(rs.getString("item_Img"));
				products.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
