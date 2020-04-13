package com.google.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
	private String enc;
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
		// Filter 객체가 소멸 후
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청이 발생하면 실행
		request.setCharacterEncoding(enc);
		System.out.println("Encoding Filter IN");
		
		chain.doFilter(request, response);
		
		response.setCharacterEncoding("UTF-8");
		System.out.println("Encoding Filter OUT");
		//다음 필터 또는 서블릿으로 전달
		//응답이 발생하면 실행
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Filter 객체가 생성후 초기화 메서드
		 enc=fConfig.getInitParameter("enc");
		
	}

}
