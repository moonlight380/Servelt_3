package com.google.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.point.PointDTO;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService noticeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
        this.noticeService = new NoticeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		//pathInfo
			String command =request.getPathInfo();
		//Method 형식
			String method =request.getMethod();
			
		//포워드, 리다이렉트
		boolean check= true;
		
		//패스(url)담을 변수
		String path="";
		try {
		//불러오기
				if(command.equals("/noticeList")) {
					ArrayList<NoticeDTO> ar= noticeService.noticeList();
					request.setAttribute("noticeList", ar);
					
					path="../WEB-INF/views/notice/noticeList.jsp";
				}else if(command.equals("/noticeAdd")){
					
					if(method.equals("POST")) {
						
						NoticeDTO noticeDTO = new  NoticeDTO();
						noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
						noticeDTO.setSubject(request.getParameter("subject"));

						noticeDTO.setName(request.getParameter("name"));
						noticeDTO.setHit(Integer.parseInt(request.getParameter("hit")));
						
						
						 int result=noticeService.noticeAdd(noticeDTO);
						String msg="점수 등록실패";
						 
						if(result>0) {
							 msg="점수 등록 성공";
							 
						 }
						request.setAttribute("result", msg);
						request.setAttribute("path", "./pointList");
						 path="../WEB-INF/views/common/result.jsp";
							/*
							 * check=false; //doPOST가 실행되어서 path="./pointList"; //pointList로 간다
							 * 
							 * //포워드 방식으로 보내면 데이터가 없음. 그러나 포워드 방식으로 보내면 DB로 가야 하는데 데이터를 담아가지 않아서 뽑아갈 데이터가 없음
							 * //path="../WEB-INF/views/point/pointList.jsp";
							 */			
						 
						 
					}else {
	
						 path="../WEB-INF/views/point/pointAdd.jsp";
					}
					
					
					
				}
				
				
			
		}catch (Exception e) {
			e.printStackTrace(); //에러메세지 콘솔창
		}
		
		
		
		
		
		
		if(check) {
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
