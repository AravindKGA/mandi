package com.gov.mandi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GetDistrictDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getDistrictList(String state)
	{
		String districQuery = "select  distinct city_name    from cities where city_state = ? order by city_name asc";
		Object[] param = new Object[] {state};
		List<String> city = new ArrayList<String>();
		try
		{
			city = jdbcTemplate.queryForList(districQuery,param,String.class);			
		}
		catch(DataAccessException daoException)
		{
			daoException.printStackTrace();
		}
		return city;
		
	}

}
