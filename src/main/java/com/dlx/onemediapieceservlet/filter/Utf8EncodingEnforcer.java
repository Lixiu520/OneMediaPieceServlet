package com.dlx.onemediapieceservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/* Servlet Filter implementation class Utf8EncodingEnforcer, this is something
* strange with servlet, we must force encoding even if the encoding come from
* client... again a voodoo doll...*/
@WebFilter("/*")
public class Utf8EncodingEnforcer implements Filter {

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       System.out.println("??? " + request.getParameter("label"));
	   request.setCharacterEncoding("UTF-8");
       //response.setContentType("text/html; charset=UTF-8");
       response.setCharacterEncoding("UTF-8");
       chain.doFilter(request, response);
   }

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
       //
   }

   @Override
   public void destroy() {
       //
   }

}