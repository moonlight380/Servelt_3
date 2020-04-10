package com.google.member;

import com.google.point.PointDTO;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		
		this.memberDAO = new  MemberDAO();
	}
	
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		int result =memberDAO.memberJoin(memberDTO);
		return result;
				
	}
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		memberDTO =memberDAO.memberLogin(memberDTO);
		return memberDTO;
				
	}
	//딜리트
	
	public int memberDelete(String id) throws Exception{
		int result=memberDAO.memberDelete(id);
		
		return result;
	}
	//업데이트
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		int result=memberDAO.memberUpdate(memberDTO);
		
		return result;
		
	}
	
	
	
	/*
	 * public MemberDTO myPage(int num) throws Exception {
	 * 
	 * int result =memberDAO.memberJoin(memberDTO); return result;
	 * 
	 * }
	 */


}
