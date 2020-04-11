package com.google.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.point.PointDTO;
import com.google.util.DBConnect;

public class NoticeDAO {

	public ArrayList<NoticeDTO> noticeList() throws Exception{
		
		ArrayList<NoticeDTO> ar= new ArrayList<NoticeDTO>();
		
		Connection con = DBConnect.getConnect();
		String sql="SELECT * FROM notice ORDER BY no DESC";
		PreparedStatement st = con.prepareStatement(sql);
		//값 세팅 없음
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO(); //새로만들때마다 newDTO가 나와야 한다. 그래서 자리는 이자리 고정
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setName(rs.getString("name"));
			noticeDTO.setDay(rs.getDate("day"));
			noticeDTO.setHit(rs.getInt("hit"));
			
			ar.add(noticeDTO);	
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
		
	}
	//noticeAdd
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
	
		Connection con =DBConnect.getConnect();
		String sql="INSERT INTO NOTICE VALUES (NOTICE_seq.nextval,?,'admin',sysdate,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getSubject());
		st.setInt(2, noticeDTO.getHit());
		
		int result =st.executeUpdate(); 
		st.close();
		con.close();
		
		return result;
		
	}
	
	//noticeSelect
	public NoticeDTO noticeSelect(int no) throws Exception{
		NoticeDTO noticeDTO=null;
		Connection con= DBConnect.getConnect();
		String sql ="select * from notice where no =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs =st.executeQuery();
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setName(rs.getString("name"));
			noticeDTO.setDay(rs.getDate("day"));
			noticeDTO.setHit(rs.getInt("hit"));
		}else {}
		
		rs.close();
		st.close();
		con.close();
		return noticeDTO;
	}
	//Update
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception {
		
		Connection con =DBConnect.getConnect();
		String sql = "UPDATE notice set subject=?,name=?,day=sysdate,hit=? where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getSubject());
		st.setString(2, noticeDTO.getName());
//		st.setDate(3, noticeDTO.getDay()); 
		st.setInt(3, noticeDTO.getHit());
		st.setInt(4, noticeDTO.getNo());
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
	
	//Delete
	public int noticeDelete(int no) throws Exception{
		Connection con =DBConnect.getConnect();
		String sql="delete from notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		
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
	
}//end class
