package com.mobileapp.mobile.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean{
//ServletRequest--->HttpServletRequest
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		//request ----> filter-----> servlet
		
		String authHeader = httpRequest.getHeader("authorization");
		//Bearer token 
		String jwtToken = authHeader.substring(7);
		System.out.println("Token "+jwtToken);
		
		Claims claims = Jwts.parser().setSigningKey("secretKey")
		.parseClaimsJws(jwtToken).getBody();
		System.out.println("Claims "+claims);
		httpRequest.setAttribute("name", claims);
		chain.doFilter(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
