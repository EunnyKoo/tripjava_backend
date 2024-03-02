# 🎈 TripJava

구글 지도 API를 활용하여 여행 경로를 저장하고 세부 일정 등 여행 스케줄을 편리하게 작성할 수 있는 웹사이트

✅ **[header]** 유저 상태에 따른 로그인/로그아웃 문구, 홈/로그인 기능

✅ **[메인페이지]** 여행지 입력

✅ **[지도]** 여행 경로 생성

✅ **[마이 페이지]** 여행 경로 열람 

✅ **[여행 플래너]** 여행 일정, 금액, 메모 등 여행 전체 일정 작성

✅ **한국관광공사 오픈 API**를 받아와 MySql 데이터 베이스에 저장

- **개발 기간** : 2024년 2월 13일 ~ 2024년 2월 29일
- **배포 주소** : http://101.101.218.151:8000
<br />

## 👨‍👩‍👧‍👦 팀 구성

|역할|이름|담당|✍️|
|------|---|---|---|
|Back-end(조장)|[권소희]()|백엔드|[회고록]()
|Back-end|[정세은](|||
|Back-end|[황주리]()||[회고록]
|Back-end|[구은현](https://github.com/EunnyKoo)||[회고록](https://velog.io/@eunkoo/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%97%AC%ED%96%89-%ED%94%8C%EB%9E%98%EB%84%88-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%8A%B8%EB%A6%BD%EC%9E%90%EB%B0%94-%ED%9A%8C%EA%B3%A0%EB%A1%9D)|
|Front-end|[나영혜]()||[회고록]
|Front-end|[이도준준]()||[회고록]

<br />

# 🔧 개발환경
## Front
JavaScript, SCSS, Figma, Google Map

## Back
Spring Boot, Java, MySQL, Postman

## Environment
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

## Communication & Tool
GIT, Github, Slack, Notion, Google Sheets

### Distribution
Naver Cloud Platform

## API
**[한국관광공사] https://www.data.go.kr/data/15101578/openapi.do

<br />

## 🗂️ 디렉토리 구조
```
trip=java/  
├── controller/  
│ ├── Checklist
│ ├── Destination  
│ ├── Itinerary 
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── TripRoute  
│ ├── User  
├── dto/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Plan  
│ ├── Planner  
│ ├── Todayplan  
│ ├── Tourist  
│ ├── TripRoute  
│ └── User  
├── entity/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── User   
├── repository/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── User   
├── service/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── User   
├── resources/  
│ └── application.properties  
```

<br />

## 📃 API 명세서

<br />

## 📋 ERD 다이어그램
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/b9c60088-bdf1-4838-9fe6-beb1ae4edab8)


<br />

# 🖥️ 화면 구성 및 주요 기능
## 메인 페이지

<br />
