package com.ld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ld.services.PhoenixSearcher;
import com.ld.services.been.SendRateInfo;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		PhoenixSearcher searcher = new PhoenixSearcher();
		List<SendRateInfo> list = new ArrayList<SendRateInfo>();
		if(searchType == null){
			response.getWriter().append("ERROR : searchType == null");
		}
		if(searchType.equals("serverIp")){
			String serverIp = request.getParameter("serverIp");
			list = searcher.searchByServerIp(serverIp);
		}else if(searchType.equals("cid")){
			String cid = request.getParameter("cid");
			list = searcher.searchByCid(cid);
		}else if(searchType.equals("room")){
			String room = request.getParameter("room");
			list = searcher.searchByRoom(room);
		}else if(searchType.equals("isp")){
			String isp = request.getParameter("isp");
			list = searcher.searchByIsp(isp);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
