package com.google.point;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pointController
 */
@WebServlet("/pointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 Encoding 처리(가장먼저 처리해야 함, 꺼내기 전에)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//pathInfo
		String command = request.getPathInfo(); //모든 정보는 리퀘스트 안에 있다.
		
		//Method 형식
		String method =request.getMethod();
		
		
		//Forward(true) Redirect(false)  선택
		boolean check = true;
		
		//path를 담을 변수
		String path="";
		
		
		if(command.equals("/pointList")) {
			
			System.out.println("list");
			
		}else if(command.equals("/pointAdd")) {
			System.out.println("add");
		}else if(command.equals("/pointMod")){
			System.out.println("mod");
			
		}else if(command.equals("/pointSelect")) {
			System.out.println("select");
		}else if(command.equals("/pointDelete")) {
			System.out.println("delete");
		}else {
			System.out.println("ETS");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
