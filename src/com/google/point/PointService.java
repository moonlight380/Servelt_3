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
	
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
}
