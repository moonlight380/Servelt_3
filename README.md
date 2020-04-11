# Servelt_3
####
- 공지사항 (Notice) 게시판
- 글쓰기 , 수정, 삭제 는 id admin 만 가능
- 샘플페이지로 fnc 홈페이지  PRcenter 공지사항 부분에 있는 부분을 구현
- 데이터들이 어떤것이 들어갔는지 확인
- 글 리스트 페이지는 최신순으로 뿌려주세요. 
- 리스트페이지에서 글쓰기 버튼을 클릭하면 글쓰기로 이동 (admin만 로그인 했을 때) 로그인 해서만 들어 갈 것.
- 리스트페이지에서 글 제목을 누르면 글 상세보기로 이동

- 글 상세보기에서 글 수정, 글 삭제 버튼이 존재 (admin만 로그인 했을 때/ 나머지들은 버튼이 보이면 안됨 조건문/공지사항의 리스트는 모든 사람이 보이도록/로그인 안한 사람은 멤버쩜 아이디가 admin이 아니라고 하면 null이 발생해서 exception이다. 그래서 멤버가 널이 아닌사람들 중에서 아이디가 admin인사람// 조건식을 분리 처음에 멤버가 null이 아니라면 그 안에서 멤버 아이디가 이콜 admin) 로그인 해서만 들어 갈 것.
- 글 삭제 버튼을 누르면 확인 취소 창을 띄우고 확인을 누르면 삭제 , 취소는  아무것도 안하면 된다.
- 글 수정은 누르면 글 수정으로 이동 
- 포인트 순서가 같다. 테이블에 들어가는 컬럼들이 다르다.
- 어떤 데이터로 컬럼을 만들어서 테이블을 구성할 지 생각을 해라
- fnc에 날짜 들어가는 것. 자바에서는 date클래스 
자바.sql.date
- 글쓰기할 때 입력해야 하는 것. 네임 (자동으로 admin/admin만 쓰는 것.)
현재시간을 넣어서 하는 것
자동으로 1씩증가 되도록
- 옵션 조회수, 글을 읽으면 제목 클릭해서 글 상세보기로 들어오면 조회수를 1 증가 시키는 것.



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
- /point/pointMod        /                      / POST
- /point/pointDelete      /                   /  GET

