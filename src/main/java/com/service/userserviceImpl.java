package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.User;

public class userserviceImpl implements userService {

	@Override
	public void userSignup(User user) {
		
		String sql = "insert into user(fname,lname,username,password)values('"+user.getFname()+"', '"+user.getLname()+"','"+user.getUsername()+"', '"+user.getPassword()+"')"; 
		try {
			Statement stm = DB.getDbObject().createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean userLogin(String un, String psw) {
		
		String sql = "select * from user where username= '"+un+"' and password = '"+psw+"' "; 
		try {
			Statement stm = DB.getDbObject().createStatement();
			ResultSet rs = stm.executeQuery(sql); 
			if(rs.next()) {
				return true; 
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User>ulist = new ArrayList<>();
		
		String sql = "select * from user";
		try {
			Statement stm  = DB.getDbObject().createStatement();
			ResultSet rs = stm.executeQuery(sql); 
			while(rs.next()) {
				
				User  u = new User();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				ulist.add(u);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ulist;
	}
	
	

}
