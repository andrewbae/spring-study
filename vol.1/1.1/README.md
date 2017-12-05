# 1.1 초난감 DAO

책을 펼치면 가장 먼저 볼 수 있는 코드이다.  
그리고 자바 개발자라면 누구나 간단하게 구현할 수 있는 기본적인 데이터 삽입과 조회를 할 수 있는 코드이다.  
앞으로 한동안은 이 간단한 코드로부터 시작해서 스프링의 설계와 구현 동작원리 등 스프링을 이해할 수 있는 과정을 진행한다.  
과연 이 코드가 어떻게 될지 기대가 된다.

## 파일 구성

- `User.class` 사용자 정보를 저장할 자바빈 클래스
- `UserDao.class` 사용자 정보를 DB와 연동하여 관리해주는 DAO 클래스
- `UserDaoTest.class` 기본 테스트 코드

## 참고 사항

예제와 같이 `UserDao.class`를 작성했을때 DB 커넥션을 얻어오는 부분에서 아래와 같은 경고가 발생했을때 참고할 것.
```
WARN: Establishing SSL connection without server's identity verification is not recommended.
According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set.
For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'.
You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
```

### 변경 전
```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springstudy", "springstudy", "springstudy");
```

### 변경 후
```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");
```

### 변경 사항 및 이유

```
useSSL=true // SSL 사용 
verifyServerCertificate=false // SSL 인증서 사용 여부
``` 
데이터베이스를 SSL 통신하지 않으면 TCP 패킷 캡쳐 시 쿼리가 그대로 노출될 가능성이 있다.   
현재는 개발 환경이라 SSL 인증서가 없어서 `verifyServerCertificate` 옵션을 `false`로 했으나 운영서버에서는 인증서가 꼭 필요할 것이다.
