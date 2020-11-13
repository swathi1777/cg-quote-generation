package com.cg;


import java.sql.*;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "angel777");

			if (con != null) {
				System.out.println("Connection Successful");
			}

			Statement smt = con.createStatement();
			
			System.out.println("Enter Student ID : ");
			String id=scan.nextLine();
			
			ResultSet rs=smt.executeQuery("select * from student where id='"+ id+"'");
			boolean found=false;
			while(rs.next()) {
				found=true;
				System.out.print("ID - "+rs.getString("ID"));
				System.out.print("\tNAME - "+rs.getString("SNAME"));
				System.out.print("\tMARKS - "+rs.getFloat("MARKS"));
				System.out.println("\tPHONE - "+rs.getLong("PHONE_NO"));
			}
			
			if(!found) {
				System.out.println("No Student found with ID : "+id);
			}
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}



	}
