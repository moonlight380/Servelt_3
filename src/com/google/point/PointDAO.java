package com.google.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.util.DBConnect;

public class PointDAO {
	//DAO(Data Access Object)
	
		//1. List //메서드 이름은 통일
	public ArrayList<PointDTO> pointList() throws Exception {
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		//1.DB 연결
		Connection con =DBConnect.getConnect();
		//2.SQL문 작성
		String sql="SELECT * FROM point ORDER BY num ASC";
		//3.SQL을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);			
		
		//4.? 값 세팅
		
		//5.최종 전송 후 결과 처리
		ResultSet rs =st.executeQuery();
		while(rs.next()) {
			PointDTO pointDTO = new PointDTO(); //새로만들때마다 newDTO가 나와야 한다
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			ar.add(pointDTO);
			//이곳에 있는 데이터를 포인트리스트에 보내줘야 함
			//배열은 몇개인지 알아야 쓸 수 있음
			//배열,list,map
			
		}
		
		//6.자원해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	
	//2. SelectOne
		public PointDTO pointSelect(int num) throws Exception {
			PointDTO pointDTO =null;
			
			Connection con = DBConnect.getConnect();
			String sql="SELECT * FROM POINT WHERE num= ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, num);
			ResultSet rs =st.executeQuery();
			if(rs.next()) {
				pointDTO= new PointDTO();
				pointDTO.setName(rs.getString("name"));
				pointDTO.setNum(rs.getInt("num"));
				pointDTO.setKor(rs.getInt("kor"));
				pointDTO.setEng(rs.getInt("eng"));
				pointDTO.setMath(rs.getInt("math"));
				pointDTO.setTotal(rs.getInt("total"));
				pointDTO.setAvg(rs.getDouble("avg"));
			}else {}
			
			rs.close();
			st.close();
			con.close();
			
			return pointDTO;
			
		}
	//3. Insert
	public int pointAdd( PointDTO pointDTO) throws Exception{
		Connection con =DBConnect.getConnect();
		String sql="INSERT INTO POINT VALUES (?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointDTO.getName());
		st.setInt(2,pointDTO.getNum());
		st.setInt(3,pointDTO.getKor());
		st.setInt(4,pointDTO.getEng());
		st.setInt(5,pointDTO.getMath());
		st.setInt(6,pointDTO.getTotal());
		st.setDouble(7,pointDTO.getAvg());
		int result =st.executeUpdate(); 
		

		st.close();
		con.close();
		return result;
	}
		
	//4. Update(Mod)
	public int pointUpdate(PointDTO pointDTO) throws Exception{
		Connection con =DBConnect.getConnect();
		String sql="UPDATE point SET  name=?,kor=?,eng=?,math=?,total=?,avg=? WHERE num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,pointDTO.getName());
		st.setInt(2,pointDTO.getKor());
		st.setInt(3,pointDTO.getEng());
		st.setInt(4,pointDTO.getMath());
		st.setInt(5,pointDTO.getTotal());
		st.setDouble(6,pointDTO.getAvg());
		st.setInt(7,pointDTO.getNum());
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
	
	
	
	//5. Delete
	public int pointDelete(int num) throws Exception{
		
		Connection con =DBConnect.getConnect();
		String sql="delete from point where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
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
	
}
