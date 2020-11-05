package com.yedam.cafe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PutProductServlet")
public class PutProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PutProductServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String itemNo = request.getParameter("itemNo");
		String itemName = request.getParameter("itemName");
		String price = request.getParameter("price");
		String itemDesc = request.getParameter("itemDesc");
		String likeIt = request.getParameter("LikeIt");
		String category = request.getParameter("category");
		String itemImg = request.getParameter("itemImg");
		
		Product prod = new Product();
		prod.setItemNo(itemNo);
		prod.setItemName(itemName);
		prod.setPrice(Integer.parseInt(price));
		prod.setItemDesc(itemDesc);
		prod.setLikeIt(Double.parseDouble(likeIt));
		prod.setCategory(category);
		prod.setItemImg(itemImg);
		
		
		ProductDAO dao = new ProductDAO();
		dao.insertproduct(prod);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href=\"cafe/index.html\";</script>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
