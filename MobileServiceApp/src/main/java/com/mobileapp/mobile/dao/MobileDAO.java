package com.mobileapp.mobile.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobileapp.mobile.model.Mobile;
import com.mobileapp.mobile.model.Sim;



@Repository
@Transactional
public interface MobileDAO extends MongoRepository<Mobile,Integer>{}
