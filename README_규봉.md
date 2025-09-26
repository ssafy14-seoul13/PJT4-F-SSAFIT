# PJT4-SSAFIT-F
- 팀장: 규봉
- 팀원: 소연, 정현

# SSAFIT

# 0. 프로젝트 개요
- SSAFIT은 운동 영상 정보를 활용한 운동 추천 및 리뷰 서비스로, 운동 영상 정보를 관리하고 영상 검색 기능, 운동 부위별 영상 추천 기능, 영상에 대한 리뷰및 커뮤니티 기능, 운동계획 관리 기능 등을 제공하는 서비스입니다.
- 각 영상 상세 페이지에서는 영상 시청과 리뷰 작성, 타 사용자의 리뷰를 확인할 수도 있습니다.
- 본 프로젝트는 Servlet, JSP를 이해하고, Tomcat 환경에서 요청/응답 흐름을 제어하는 웹 서버를 구축 및 MVC 아키텍처를 이해하고 활용하고자 진행하였습니다.

<br>

# 1. 준비 사항
### 1. 사용 데이터
- Youtube 영상 데이터 사용

### 2. 개발언어 및 툴
- Java, STS, HTML, CSS, JavaScript, VScode, Tomcat

### 3. 필수 라이브러리 / 오픈소스
- BootStrap Framework

<br>

# 2. 작업 순서
### 1. 역할 분배
- 기본 템플릿 제작
- User, Video, Review로 나눠 진행

### 2. MVC 계층을 배치한 아키텍처, 클래스 다이어그램 초안 작성

### 3. 생성형 AI를 활용한 다이어그램의 개선 포인트를 작성

### 4. 설계한 프로젝트를 구현 및 개발

<br>

# 3. 기능
### 1. 필수 기능
- 회원 정보 관리 (로그인 / 로그아웃 / 작성 / 조회 / 수정 / 삭제)
- 영상 정보 관리 (영상 정보 / 부위 별 등 검색 기능 / 영상에 대한 리뷰)

### 2. 추가 기능
- 영상 정보 관리 (찜 영상 목록)
- 커뮤니티 관리 (자유 게시판, 회원 팔로우 기능)
- 운동계획 관리 (운동 계획, 시각적인 기능 등)

<br>

# 4. 프로젝트 구조
```
 ssafit/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │      └── pjt4/
│   │   │         └── ssafit/
│   │   │            ├── controller/      
│   │   │            │   ├── VideoController.java
│   │   │            │   ├── ReviewController.java
│   │   │            │   └── UserController.java
│   │   │            ├── service/              
│   │   │            │   ├── VideoService.java
│   │   │            │   ├── VideoServiceImpl.java
│   │   │            │   ├── ReviewService.java
│   │   │            │   ├── ReviewServiceImpl.java
│   │   │            │   ├── UserServiceImpl.java
│   │   │            │   └── UserService.java
│   │   │            ├── repository/        
│   │   │            │   ├── VideoRepository.java
│   │   │            │   ├── VideoRepositoryImpl.java
│   │   │            │   ├── ReviewRepository.java
│   │   │            │   ├── ReviewRepositoryImpl.java
│   │   │            │   └── UserRepository.java
│   │   │            ├── dto/        
│   │   │            │   ├── Video.java
│   │   │            │   ├── Review.java
│   │                    └── User.java
│   └── webapp/    
│       ├── WEB-INF/
│       │   └── user/            
│       │       ├── view.jsp          
│       │       ├── login.jsp           
│       │       └── regist.jsp         
│       │   └── video/            
│       │       ├── view.jsp          
│       │       ├── detail.jsp          
│       └── index.jsp            
└── README.md                     (프로젝트 설명)
```

# 5. 소감
이번 Back 관통 프로젝트를 진행하면서 MVC 패턴을 직접 설계하고 구현하면서 백엔드 개발을 경험해볼 수 있는 기회여서 좋았습니다.

Service, Repository 계층을 싱글턴 패턴으로 만들고 SOLID 5원칙 중 하나인 의존성 주입을 적용하여 구현하는 과정이 편리한 방법이라는 것을 알게되었습니다.

서블릿을 이용해서 Back을 구현하는 것도 재밌는데, Spring은 어떨지 기대가 됩니다. DB도 배워서 이번 관통프로젝트와 연동하고, Spring 방식으로도 만들어보고 싶습니다.


