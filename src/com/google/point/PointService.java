package com.google.point;

import java.util.ArrayList;

public class PointService {
	
	private PointDAO pointDAO;
	
	public PointService() {
		
	//생성자 //this 생략 가능
		this.pointDAO = new PointDAO();
	}
	
	
	//1.List
	public ArrayList<PointDTO> pointList() throws Exception{
		return pointDAO.pointList();
	}

	//2.SelectOne
	public PointDTO pointSelect(int num) throws Exception{
		
		return pointDAO.pointSelect(num);
	}
	
	//3.Delete
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	//4.Insert
	public int pointAdd(PointDTO pointDTO) throws Exception{
		pointDTO.setTotal(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		int result=pointDAO.pointAdd(pointDTO);
		
		return result;
		
	}
	//5.Update	
	public int pointUpdate(PointDTO pointDTO) throws Exception{
		pointDTO.setTotal(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);	
		int result=pointDAO.pointUpdate(pointDTO);
		
		return result;
	}
	
}//END CLASS
