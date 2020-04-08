package com.google.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		
		try {
			Connection con;
			con = DBConnect.getConnect();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Connection getConnect() throws Exception{
		
		//1 로그인정보4가지 
		
		//logon deny
		//1.ID/PW가 틀렸을 경우
		//2.DB에 해당 유저가 생성되지 않은 경우
		//3.유저의 권한이 적용되지 않은 경우
		
		
		String user="user02";
		String password="user02";
		
		//Not Connect
		//1.IP, port,xe 정보가 틀린 경우
		//2.물리적으로 연결이 안되거나, 서버가 종료된 경우
		//3.Listener 문제,DB 재시동
		String url="jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//Class not found
		//1.driver명이 틀린 경우
		//2.jdbc(ojdbc6.jar)가 없는 경우
		
		//2 드라이버를 메모리에 로딩
		Class.forName(driver);
		//3 로그인 후 Connection 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
