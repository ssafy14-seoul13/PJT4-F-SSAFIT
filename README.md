# PJT4-SSAFIT-F
- 팀장: 규봉
- 팀원: 소연, 정현

#SSAFIT

## 0. 프로젝트 구조
ssafit/
 ├── src/
 │   ├── controller/
 │   │    ├── FrontController.java
 │   │    ├── VideoController.java
 │   │    ├── ReviewController.java
 │   │    └── MemberController.java
 │   │
 │   ├── service/
 │   │    ├── VideoService.java
 │   │    ├── ReviewService.java
 │   │    └── MemberService.java
 │   │
 │   ├── repository/
 │   │    ├── VideoRepository.java
 │   │    ├── ReviewRepository.java
 │   │    └── MemberRepository.java
 │   │
 │   ├── dto/
 │   │    ├── Video.java
 │   │    ├── Review.java
 │   │    └── Member.java
 │   │
 │   └── util/
 │        └── DBUtil.java   (DB 연결 헬퍼, 일단 메모리로 구현 가능)
 │
 ├── WebContent/
 │   ├── WEB-INF/
 │   │    └── web.xml
 │   ├── index.jsp
 │   ├── video/
 │   │    └── list.jsp
 │   ├── review/
 │   │    └── list.jsp
 │   └── member/
 │        └── login.jsp
