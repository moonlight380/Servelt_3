package com.google.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.point.PointDTO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
        this.memberService = new MemberService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//pathInfo
		String command =request.getPathInfo();
		//Method 형식
		String method = request.getMethod();
		//Forward(true) Redirect(false)  선택
		boolean check =true;
		//URL(path)를 담을 변수
		String path="";
			try {
			if(command.equals("/memberJoin")) {
					if(method.equals("POST")) {
						//디비에 인서트
						MemberDTO memberDTO = new MemberDTO();
						memberDTO.setId(request.getParameter("id"));
						memberDTO.setPassword(request.getParameter("password"));
						memberDTO.setName(request.getParameter("name"));
						memberDTO.setEmail(request.getParameter("email"));
						memberDTO.setTel(request.getParameter("tel"));
						memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
						
						 int result=memberService.memberJoin(memberDTO);
						 
						check= false;
						path="../";
						
					}else {
						path="../WEB-INF/views/member/memberJoin.jsp";
						
					}
			}else if(command.equals("/memberLogin")) {
					if(method.equals("POST")) {
						
						MemberDTO memberDTO = new MemberDTO();
						memberDTO.setId(request.getParameter("id"));
						memberDTO.setPassword(request.getParameter("password"));
						
						
						 memberDTO=memberService.memberLogin(memberDTO);
						 
						 
						 if(memberDTO != null) {
							 	HttpSession session=request.getSession();
							 	session.setAttribute("member", memberDTO);
								/* request.setAttribute("member", "test"); 스코프는 생략할 수 있지만 작은 영역부터 찾아서 이름이 같다면 원하는 결과가 안나올 수 있음*/
								check = false;
								path="../";
							}else {
								request.setAttribute("result", "Login Fail");
								request.setAttribute("path", "./memberLogin");
								path="../WEB-INF/views/common/result.jsp";
							}
					
			
					}else {
						path="../WEB-INF/views/member/memberLogin.jsp";
					}
			
			}else if(command.equals("/memberLogout")) {
				HttpSession session =request.getSession();
				//session.removeAttribute("member"); //세션을 지운다.
				//세션이 죽어버리면 그 안에 들어가는 것들도 죽어버린다.
				//세션이 죽일 수 있는 방법은 창을 닫거나, 아무것도 안하면 일정시간이 지나면 끝
				//여기서는 강제로 세션을 없애려고 하는 것
				// 즉, 활동하는 시간을 강제로 0으로 만드는 것
				session.invalidate();
				//그리고 세션은 웹 브라우져 별로 하나씩 만들어지기 떄문에 다른 브라우저에서 각각 로그인 로그아웃을 해도 영향받지 않음
				check =false;
				path="../";
				
				
			}else if(command.equals("/memberPage")) {
				path="../WEB-INF/views/member/memberPage.jsp";
			
				
				
			}else if(command.equals("/memberDelete")) {
				
				MemberDTO memberDTO = new MemberDTO();
				HttpSession session=request.getSession(); //내장객체 request 안에 세션이 있다.
			 	memberDTO=(MemberDTO)session.getAttribute("member");//로그인 당시 member로 줬다 //속성이 object이기 때문에 형변환해야 한다
			 	//System.out.println(memberDTO.getId());
				String id =memberDTO.getId();
				
				int result=memberService.memberDelete(id);
				
				if(result>0) {
					session.invalidate(); //로그 아웃 상태로 변하도록
				}
				

				check=false;
				path="../";
				
			//업데이트
			}else if(command.equals("/memberUpdate")) {
				if(method.equals("POST")) {
					MemberDTO memberDTO = new MemberDTO();
					HttpSession session=request.getSession();

					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPassword(request.getParameter("password"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setEmail(request.getParameter("email"));
					memberDTO.setTel(request.getParameter("tel"));
					memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
					
					
				 	int result=memberService.memberUpdate(memberDTO);
				 	
					 String msg="회원 수정실패";
					 System.out.println(result);
					 
					 
						if(result>0) {
							
							//세션에 있는 데이터를 바꿔줘야 함
							
							session.setAttribute("member", memberDTO);//성공하면 새로운 데이터로 수정하겠다
							 msg="회원 수정 성공";
							 request.setAttribute("path", "./memberPage");
						 }else {
							 request.setAttribute("path", "./memberUpdate");
						 }
						
						request.setAttribute("result", msg);
						path="../WEB-INF/views/common/result.jsp"; //포워드로 보낼 주소
					

		
				}else {
					path="../WEB-INF/views/member/memberUpdate.jsp";
				}
				
				
				
				
			}
			}catch (Exception e) {
				// TODO: handle exception
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
