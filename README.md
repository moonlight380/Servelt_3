# Servelt_3

## 기능
 

 
### Member
 - 회원가입(insert) 
 - 로그인(Select One)
 - 회원수정(update)
 - 회원탈퇴(Delete)
 - myPage
 
 
## JSP
 
## URL 주소				/  JSP 				/ Method
### /WEB-INF/views/member/**
 - /member/memberJoin	/  memberJoin.jsp	/ GET
 - /member/memberJoin	/  					/ POST
 
 - /member/memberLogin	/  memberLogin.jsp	/ GET
 - /member/memberLogin	/  					/ POST
 
 - /member/memberPage	/  memberPage.jsp	/ GET
 
 - /member/memberUpdate	/  memberUpdate.jsp	/ GET
 - /member/memberUpdate	/  					/ POST
 
 - /member/memberDelete	/  					/ GET
 
# point
- point list 출력
- point 등록
- point 상세 정보 출력
- point 수정
- point 삭제

## JSP
- pointList.jsp       :List 출력
- pointAdd.jsp        : 입력폼
- pointSelect.jsp     :point 상세정보 출력
- pointMod.jsp        :point 수정 폼


## URL 주소         /     JSP 파일 연동                             / Method
###  /WEB-INF/views/point/**
- 내부에서 사용하는 가상의 주소
- /point/pointList       /   pointList.jsp      /  GET
- /point/pointAdd        /    pointAdd.jsp      /  GET
- /point/pointAdd        /   미정                               /  POST
- /point/pointSelect     /    pointSelect.jsp   /  GET
- /point/pointMod       /    pointMod.jsp    /  GET
- /point/pointMod        /    pointMod.jsp    / POST
- /point/pointDelete      /                   /  GET

