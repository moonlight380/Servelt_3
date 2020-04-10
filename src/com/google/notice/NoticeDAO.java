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
	
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		Connection con =DBConnect.getConnect();
		String sql="INSERT INTO POINT VALUES (NOTICE_seq.nextval,?,'admin',sysdate,0";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getSubject());
		int result =st.executeUpdate(); 
		st.close();
		con.close();
		return result;
	}

	
	
	
}//end class
