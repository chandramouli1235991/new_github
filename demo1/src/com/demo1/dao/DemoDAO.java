package com.demo1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.demo1.entity.DemoUser;

public class DemoDAO implements DemoDAOInterface {

	public static DemoDAOInterface createDaoObject(String string) {
		// TODO Auto-generated method stub
		return new DemoDAO();
	}

	@Override
	public int createProfileDao(DemoUser du) {
		int i=1;
		try
		{
			DataSource ds;
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:/OracleDS1");
			Connection con=ds.getConnection();
			
			PreparedStatement ps=con.prepareStatement("insert into facebookemployee values(?,?,?,?)");
			ps.setString(1, du.getName());
			ps.setString(2, du.getPassword());
			ps.setString(3, du.getEmail());
			ps.setString(4, du.getAddress());
			i=ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
		
	
	}


