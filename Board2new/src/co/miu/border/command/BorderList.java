package co.miu.border.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.miu.border.dao.BorderDao;
import co.miu.border.vo.BorderVo;
import co.miu.common.BorderCommand;

public class BorderList implements BorderCommand {

	@Override		//상속 받은 객체?가 알아서 만들어 주는 것.
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		BorderDao dao = new BorderDao();
		ArrayList<BorderVo> blist = dao.selectAll();		//BorderVo 타입으로 list를 받음.
		request.setAttribute("list", blist); 	//list 객체에 'blist' 담아주기
		
		return "jsp/border/borderList.jsp";		//이렇게 돌려주면 됨.
	}
}