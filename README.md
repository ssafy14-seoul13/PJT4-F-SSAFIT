# PJT4-SSAFIT-F
- 팀장: 규봉
- 팀원: 소연, 정현

# SSAFIT

## 0. 프로젝트 개요
- SSAFIT은 사용자가 직접 운동 영상을 등록할 수 있고, 검색, 즐겨찾기, 리뷰할 수 있는 웹 기반 서비스입니다.
- 각 영상 상세 페이지에서는 영상 시청과 리뷰 작성, 타 사용자의 리뷰를 확인할 수도 있습니다.
- 본 프로젝트는 Servlet, JSP를 이해하고, Tomcat 환경에서 요청/응답 흐름을 제어하는 웹 서버를 구축 및 MVC 아키텍처를 이해하고 활용하고자 진행하였습니다.

<br>

## 1. 준비 사항
### 1. 사용 데이터
- Youtube 영상 데이터 사용
<br>
### 2. 개발언어 및 툴
- Java, STS, HTML, CSS, JavaScript, VScode, Tomcat
<br>
### 3. 필수 라이브러리 / 오픈소스
- BootStrap Framework

## 2. 


## 0. 프로젝트 구조
```
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
```
