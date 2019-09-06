package com.demo1.service;

import com.demo1.dao.DemoDAO;
import com.demo1.dao.DemoDAOInterface;
import com.demo1.entity.DemoUser;

public class DemoService implements DemoServiceInterface {

	public static DemoServiceInterface createObject() {
		// TODO Auto-generated method stub
		return new DemoService() ;
	
	}

	
	public int createProfile(DemoUser du) {
		DemoDAOInterface dd=DemoDAO.createDaoObject("fe");
		int i = dd.createProfileDao(du);
		return i;
	}

}
