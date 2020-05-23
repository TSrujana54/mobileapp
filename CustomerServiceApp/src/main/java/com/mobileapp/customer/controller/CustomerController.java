package com.mobileapp.customer.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.customer.dao.CustomerDAO;
import com.mobileapp.customer.model.Customer;
import com.mobileapp.customer.service.CustomerService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService service;
	ResponseEntity responseEntity;
	String token = "";
	static final long EXPIRATIONTIME=200000;
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		logger.info("addCustomer():: called");
		boolean flag = service.addCustomer(customer);
		if(flag) {
			
			responseEntity = new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer customer,HttpSession session){
		boolean flag = service.validate(customer);
		if(flag) {
			session.setAttribute("customerName", customer.getCustomerName());
			token = getToken(customer.getCustomerName());
			responseEntity = new ResponseEntity<String>(token,HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	private String getToken(String customerName) {
		String jwtToken = Jwts.builder()
			.setSubject(customerName)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
			.signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		
		System.out.println("Token "+jwtToken);
		return jwtToken;
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		if(session!=null&&session.getAttribute("customerName")!=null) {
			session.invalidate();
			responseEntity = new ResponseEntity<String>("Logged Out Successfully",HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	

}
