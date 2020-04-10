package com.google.notice;

import java.util.ArrayList;

import com.google.point.PointDTO;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		
		this.noticeDAO= new NoticeDAO();
	}
	
	
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		
		return noticeDAO.noticeList();
	}
	
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		int result=noticeDAO.noticeAdd(noticeDTO);
				
		
		return result;
	}
	
	
}//end class
