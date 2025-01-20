package com.app.dao.custmor.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.custmor.CustmorDAO;
import com.app.dto.custmor.custmor;

@Repository
public class CustmorDAOImpl implements CustmorDAO{

	public List<custmor> findCustmorList(){
		System.out.println("custmor 호출");
		return null;
	}
}
