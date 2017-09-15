package com.ld;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ld.services.HbaseScanner;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//≤È—Øhbase
		HbaseScanner scanner = new HbaseScanner();
		List<String> cidList = scanner.searchCidList();
		request.setAttribute("cidList", cidList);
		List<String> ispList = scanner.searchIspList();
		request.setAttribute("ispList", ispList);
		List<String> roomList = scanner.searchRoomList();
		request.setAttribute("roomList", roomList);
		List<String> serverIpList = scanner.searchServerIp();
		request.setAttribute("serverIpList", serverIpList);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
