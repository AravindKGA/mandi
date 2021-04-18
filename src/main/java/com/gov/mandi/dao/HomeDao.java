package com.gov.mandi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateLogin(Map<String,String> inputParam)
	{
		String loginQuery = "select count(*) from userDetails where userName = ? and password = ?";
		boolean loginStatus = false;
		try
		{
		Object[] param = new Object[] {inputParam.get("username"),inputParam.get("password")};
		int count = jdbcTemplate.queryForObject(loginQuery, param, Integer.class);
		if(count >0)
			loginStatus = true;
			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return loginStatus;

	}
	
	
	public List<String> getcityState()
	{
		String loginQuery = "select  distinct  city_state  from cities order by city_state asc";
				
		List<String> cityState = new ArrayList<String>();
		try
		{
		cityState = jdbcTemplate.queryForList(loginQuery,String.class);
			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return cityState;

	}

}
