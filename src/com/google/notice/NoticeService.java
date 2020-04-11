package com.google.notice;

import java.util.ArrayList;

import com.google.point.PointDTO;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		
		this.noticeDAO= new NoticeDAO();
	}
	
	//list
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		
		return noticeDAO.noticeList();
	}
	//add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		int result=noticeDAO.noticeAdd(noticeDTO);

		return result;
	}
	//noticeSelect
	public NoticeDTO noticeSelect(int no) throws Exception{	
		return noticeDAO.noticeSelect(no);
	}
	//noticeUpdate
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		
		int result = noticeDAO.noticeUpdate(noticeDTO);
		return result;
	}
	public int noticeDelete(int no)throws Exception{
		int result = noticeDAO.noticeDelete(no);
		return result;
	}
	
	
}//end class
