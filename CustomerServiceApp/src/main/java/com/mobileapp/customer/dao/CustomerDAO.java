package com.mobileapp.customer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileapp.customer.model.Customer;


@Repository
@Transactional
public interface CustomerDAO extends JpaRepository<Customer, String>{
	

}
