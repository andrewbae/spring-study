# 1-1 초난감 DAO

자바를 배운 사람들이 구현할 수 있는 가장 기본적인 데이터 삽입과 조회를 할 수 있는 코드이다.
하지만 이것으로 스프링이 지향하는 오브젝트의 설계와 구현 그리고 동작원리에 대해 이해를 하기 위한 것이라 생각한다.
최초 작성 했던 코드에서부터 객체지향 기술의 원리에 충실한 코드로 개선해가는 작업을 간단히 살펴볼 수 있다.
그리고 단위테스트도 간단히 진행해 볼 수 있다.

## 참고사항

```
WARN: Establishing SSL connection without server's identity verification is not recommended.
According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set.
For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'.
You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
```
위와 같은 경고(Warning)가 발생했다면 아래와 같이 DB 커넥션 부분을 변경 해야한다.

- 변경 전
```
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springstudy", "springstudy", "springstudy");
```

- 변경 후
```
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");
```

- 변경 사항
```
useSSL=true // SSL 사용 
verifyServerCertificate=false // SSL 인증서 사용 여부
``` 

현재는 개발 환경이라 SSL 인증서가 없어서 `verifyServerCertificate` 옵션을 `false`로 했으나 운영서버에서는 인증서가 꼭 필요할 것이다.