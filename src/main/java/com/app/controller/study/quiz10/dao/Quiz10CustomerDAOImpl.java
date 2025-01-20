package com.app.controller.study.quiz10.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.controller.study.quiz10.dto.Quiz10Customer;

@Repository
public class Quiz10CustomerDAOImpl implements Quiz10CustomerDAO{

	@Override
	public int saveCustomer(Quiz10Customer quiz10Customer) {
		
		// DB 저장
		return 0;
	}
}
