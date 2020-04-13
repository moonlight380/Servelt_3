package com.google.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.member.MemberDTO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		//httpServlet request 는 servelet request의 조상
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		
		String commnad =  ((HttpServletRequest)request).getPathInfo();
		if(memberDTO!= null) {
			String id = memberDTO.getId();
			if(id.equals("admin")) {
				//admin
				System.out.println("admin");
				
				chain.doFilter(request, response);
			}else {
				System.out.println("member");
//				request.setAttribute("result", "권한이 필요");
//				request.setAttribute("path","../");
//				//일반 member
//				RequestDispatcher view = request.getRequestDispatcher("../common/result.jsp");
//				view.forward(request, response);
				((HttpServletResponse)response).sendRedirect("../member/memberLogin");
			}
			
		}else {
			//로그인이 안된 상태 
			System.out.println("로그인 안된 상태");
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
				

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
