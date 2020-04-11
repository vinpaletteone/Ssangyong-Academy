# Ssangyong-Academy, 쌍용교육센터.
![project03](https://user-images.githubusercontent.com/57277591/79044784-22197180-7c42-11ea-9db3-5ffe9c64c56e.jpg)


**쌍용교육센터는 교육 센터 운영 및 유지 프로그램 개발 JDBC 프로젝트입니다.**
1. 기간 : 2019.11.01 ~ 2019.11.22
2. 목표 : 코스메틱 상품을 온라인으로 수발주 서비스를 제공하며<br>
서버를 통한 접근성이 높은 웹 발주 관리와 불편한 ERP 보다 훨씬 쉽게 온라인으로 발주를 할 수 있습니다.<br>
3. 특징 : 프로그램을 통해 과정을 개설하고 과정에 따른 과목을 등록해 교육센터의 전반적인 운영이 가능하도록 합니다.

<br>

---
## About Tech
![웹 1920 – 11](https://user-images.githubusercontent.com/57277591/79044799-352c4180-7c42-11ea-88de-2d78df4cb42c.jpg)

### 기술 스택 & 툴

### Back-End
- JAVA(JDK 1.8)
- Oracle
- JDBC
- ANSI-SQL
- PL/SQL

<br>

---
## About Team

### Member
#### Back-End
- 지수빈, 이유진, 이지성, 장대호, 장준성, 홍요섭

<br>

---
## 프로젝트 상세히 보기
![project03_modal](https://user-images.githubusercontent.com/57277591/79044761-0d3cde00-7c42-11ea-9c8e-d9736a14f57b.jpg)

### 담당 업무
- SQL 쿼리 작성, 관리자 메뉴 구현(개설 과목 관리, 교육생 관리), 교육생 메뉴 구현(교육생 정보, 성적 조회)

### 느낀점
1. Oracle, PL/SQL 사용 - **"데이터를 단순하게 생각했던 점에서의 반성"**
- 위기 : 매개변수를 받아 if문을 통해 update, insert, select를 동시에 처리하는 프로시저 작성 오류 발생. <br>
하루내내 혼자의 힘으로 해결하려했지만 부족했었다. 처음부터 개체 관계 모델을 잘못 구성했었다...<br>

- 극복 : 팀원들과 상의 > 테이블과 ERD 수정. > 그래도 오류남. <br>
> join을 하는 과정에서 프로시저가 50줄이 넘어감. > 멘붕 > 데이터의 흐름과 관계도 파악 후 > 프로시저 에러 해결! <br>

- 느낀점 : 데이터는 단순한 정보를 담는 것이 아니다. 비행기로 타고 갈 목적지를 걸어서 간 기분이였다.
데이터 구조를 정확하게 파악해야한다. 팀원들과 충분한 상의는 필수! 혼자만의 문제라고 안고 가려하지 말자. 상호작용이 가장 중요하다.

