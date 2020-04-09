package com.google.member;

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
	
	/*
	 * public MemberDTO myPage(int num) throws Exception {
	 * 
	 * int result =memberDAO.memberJoin(memberDTO); return result;
	 * 
	 * }
	 */


}
