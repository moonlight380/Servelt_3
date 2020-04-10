package com.google.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.point.PointDTO;
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
	//memberDelte
	public int memberDelete(String id) throws Exception{
		
		Connection con =DBConnect.getConnect();
		String sql="delete from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		int result =st.executeUpdate();
			if(result>0) {
				System.out.println("성공");
			}else{
				System.out.println("실패");
			}
			st.close();
			con.close();
			
			return result;
	}
	//update
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		int result=0;
		Connection con =DBConnect.getConnect();
		String sql="UPDATE member set password=?,name=?,email=?,tel=?,age=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setString(1, memberDTO.getPassword());
		st.setString(2, memberDTO.getName());
		st.setString(3, memberDTO.getEmail());
		st.setString(4, memberDTO.getTel());
		st.setInt(5, memberDTO.getAge());
		st.setString(6, memberDTO.getId());
		result= st.executeUpdate();
		st.close();
		con.close();
		
		
		System.out.println(memberDTO.getName());
		return result;
		
	}
	
}//end class
