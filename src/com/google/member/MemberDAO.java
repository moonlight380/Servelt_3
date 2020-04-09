package com.google.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.util.DBConnect;

public class MemberDAO {

	
	//MemberLogin
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		Connection con =DBConnect.getConnect();
		String sql ="select *from member where id=? and password=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setTel(rs.getString("tel"));
			memberDTO.setAge(rs.getInt("age"));
		}else {
			memberDTO=null;
		}
		rs.close();
		st.close();
		con.close();
		return memberDTO ;
		
	}
	//MemberJoin
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int result=0;
		Connection con =DBConnect.getConnect();
		String sql="INSERT INTO member VALUES (?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getTel());
		st.setInt(6, memberDTO.getAge());
		result= st.executeUpdate();
		st.close();
		con.close();
		
		return result;
	}
}//end class
