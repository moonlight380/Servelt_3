package com.google.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
       
	
	private PointService pointService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        // TODO Auto-generated constructor stub
        this.pointService = new PointService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//한글 Encoding 처리(가장먼저 처리해야 함, 꺼내기 전에)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//pathInfo
		String command = request.getPathInfo(); //모든 정보는 리퀘스트 안에 있다.
		
		//Method 형식
		String method =request.getMethod();
		
		
		//Forward(true) Redirect(false)  선택
		boolean check = true;
		
		//URL(path)를 담을 변수
		String path="";
		
		try {
				if(command.equals("/pointList")) {
					
						ArrayList<PointDTO> ar=pointService.pointList();
						request.setAttribute("list",ar);
						
					path="../WEB-INF/views/point/pointList.jsp";
					
				}else if(command.equals("/pointAdd")) {
						if(method.equals("POST")) {
							PointDTO pointDTO = new PointDTO();	
							pointDTO.setName((request.getParameter("num")));
							pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
							pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
							pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
							pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
							
			
							 int result=pointService.pointAdd(pointDTO);
							
							check=false;
							path="./pointList";
							
						}else {
	
							 path="../WEB-INF/views/point/pointAdd.jsp";
						}
						
				}else if(command.equals("/pointMod")){
						if(method.equals("POST")) {
							
						}else {
							path="../WEB-INF/views/point/pointMod.jsp";
						}
					
					
				}else if(command.equals("/pointSelect")) {
						
						int num =Integer.parseInt(request.getParameter("num"));
						 PointDTO pointDTO=pointService.pointSelect(num);
						
						request.setAttribute("dto", pointDTO);
						path="../WEB-INF/views/point/pointSelect.jsp";
					
				}else if(command.equals("/pointDelete")) {
						check=false;
						//리다이렉트에 포인트 포인트리스트로 보내기
						
						int num =Integer.parseInt(request.getParameter("num"));
						 int result=pointService.pointDelete(num);
						 path="./pointList";
					
				}else {
						System.out.println("ETC");
				}
		
		}catch (Exception e) {
			e.printStackTrace(); //에러메세지 콘솔창
		}
		
		if(check==true) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
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
