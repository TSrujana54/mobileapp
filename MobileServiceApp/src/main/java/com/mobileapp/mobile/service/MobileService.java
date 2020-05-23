package com.mobileapp.mobile.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapp.mobile.dao.MobileDAO;
import com.mobileapp.mobile.model.Mobile;
@Service
public class MobileService {
	@Autowired
	MobileDAO dao;
	boolean flag = false;
	
	public boolean addMobile(Mobile m) {
		Mobile mobile = dao.save(m);
		if(mobile!=null)
			flag = true;
		return flag;
	}

	public boolean deleteMobile(String mobileId) {
		List<Mobile> mobileList = dao.findAll();
		for(Mobile mobile : mobileList) {
			if(mobile.getMobileId().equals(mobileId)) {
				dao.delete(mobile);
				flag = true;
			}
		}
		return flag;
	}

}
