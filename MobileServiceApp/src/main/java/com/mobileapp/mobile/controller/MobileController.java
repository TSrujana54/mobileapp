package com.mobileapp.mobile.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.mobile.dao.MobileDAO;
import com.mobileapp.mobile.model.Mobile;
import com.mobileapp.mobile.service.MobileService;



@RestController
public class MobileController {
	@Autowired
	private MobileService service;
	ResponseEntity responseEntity;

	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	@PostMapping("/app/addMobile")
	public ResponseEntity<?> addMobile(@RequestBody Mobile m,HttpSession session){
	//	String customerName = (String)session.getAttribute("customerName");
	//	if(customerName!=null) {
		boolean flag = service.addMobile(m);
		if(flag) {
			responseEntity = new ResponseEntity<Mobile>(m,HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
	//	}
	//	else {
		//	responseEntity = new ResponseEntity<String>("Customer Not Logged In",HttpStatus.BAD_REQUEST);
		//}
		return responseEntity;
	}
		
	
	
	@DeleteMapping("/app/delete/{id}")
	public ResponseEntity<String> deleteMobile(@PathVariable("id") String mobileId){
		boolean flag = service.deleteMobile(mobileId);
		if(flag) {
			responseEntity = new ResponseEntity<String>("Deleted Succusfully",HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

}
