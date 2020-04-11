package com.google.notice;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
		//NoticeList
				if(command.equals("/noticeList")) {
					ArrayList<NoticeDTO> ar= noticeService.noticeList();
					request.setAttribute("noticeList", ar);
					
					path="../WEB-INF/views/notice/noticeList.jsp";

					//NoiticeADD
				}else if(command.equals("/noticeAdd")){
					
						if(method.equals("POST")) {
							
							NoticeDTO noticeDTO = new  NoticeDTO();
							noticeDTO.setSubject(request.getParameter("subject"));
							noticeDTO.setHit(Integer.parseInt(request.getParameter("hit")));
							
							
							 int result=noticeService.noticeAdd(noticeDTO);
							String msg="게시글 등록실패";
							 
							if(result>0) {
								 msg="게시글 등록 성공";
								 
							 }
							request.setAttribute("result", msg);
							request.setAttribute("path", "./noticeList");
							 path="../WEB-INF/views/common/result.jsp";		
							 
							 
						}else {
		
							 path="../WEB-INF/views/notice/noticeAdd.jsp";
						}
						
					//select
				}else if(command.equals("/noticeSelect")) {
						
					int no =Integer.parseInt(request.getParameter("no"));
						
					NoticeDTO noticeDTO =noticeService.noticeSelect(no);
						
					request.setAttribute("ndto", noticeDTO); //서버내에서 또다른 서버로 보내는 것. value 는 보내줄 데이터
					path="../WEB-INF/views/notice/noticeSelect.jsp";	
				
				//update
				}else if(command.equals("/noticeUpdate")) {
					if(method.equals("POST")) {
						
						NoticeDTO noticeDTO = new  NoticeDTO();
						noticeDTO.setSubject(request.getParameter("subject"));
						noticeDTO.setHit(Integer.parseInt(request.getParameter("hit")));
						
						
						 int result=noticeService.noticeAdd(noticeDTO);
						String msg="게시글 등록실패";
						 
						if(result>0) {
							 msg="게시글 등록 성공";
							 
						 }
						request.setAttribute("result", msg);
						request.setAttribute("path", "./noticeList");
						 path="../WEB-INF/views/common/result.jsp";		
						 
						 
					}else {
	
						 path="../WEB-INF/views/notice/noticeUpdate.jsp";
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
