package com.revature.rest.emp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.rest.emp.model.Person;
import com.revature.rest.emp.utils.ConnectionUtils;


public class PersonDAOImpl implements PersonDAO {

	@Override
	public List<Person> getPersons() {
		
		
		Person person=null;
		List<Person> personList = new ArrayList<Person>();
		Connection conn=null;
		
		 try {
			conn=ConnectionUtils.getConnection();
			 
			Statement stmt=conn.createStatement();
			String queryActor="Select * from person";
			ResultSet rs=stmt.executeQuery(queryActor);
			
			while(rs.next()) {
				 person=new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				personList.add(person);
						
			}
			
			// STEP 5: Clean Up
			stmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personList;
	}

	@Override
	public Person getPerson(int id) {
		Person person=null;
		
		Connection conn=null;
		
		 try {
			conn=ConnectionUtils.getConnection();
			 
			String queryPerson="Select * from person where id=?";
			PreparedStatement pstmt=conn.prepareStatement(queryPerson);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				 person=new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
						}
			
			// STEP 5: Clean Up
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public String addPerson(Person p) {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		 try {
			conn=ConnectionUtils.getConnection();
			 
			String insertPerson="insert into person(id,age,name) values(?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(insertPerson);
			pstmt.setInt(1,p.getId());
			pstmt.setInt(2, p.getAge());
			pstmt.setString(3, p.getName());
			pstmt.execute();
			
			
			// STEP 5: Clean Up
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Data Saved ";
	}

}
