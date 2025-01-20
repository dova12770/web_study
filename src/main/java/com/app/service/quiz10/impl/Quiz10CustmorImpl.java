package com.app.service.quiz10.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.custmor.CustmorDAO;
import com.app.dto.custmor.custmor;

public class Quiz10CustmorImpl {

	@Autowired
	CustmorDAO custmorDAO;
	
	
	public List<custmor> findCustmorList(){
		System.out.println("custmor 호출");
		 List<custmor> custmorList = custmorDAO.findCustmorList();
		return custmorList;
	}
}
