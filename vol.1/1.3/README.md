# 1.3 DAO의 확장

DAO 에서 관심사를 분리하고 중복 코드를 제거하고 상속을 통해 확장을 했지만 아직 DAO 파일에는 문제가 많다.  
`getConnection()` 메소드를 분리하였지만 DAO 클래스가 계속 추가 된다면 매 DAO 클래스 마다 `getConnection()` 메소드를 작성해야 한다.
엑세스 로직과 커넥션 로직이 분리되어 있다고 볼 수는 있지만 하나의 클래스 안에서 메소드로만 나누어져 있기에 완전하게 독립적일 수가 없었다. 이 챕터를 완료하면 완전하게 분리하여 완전 독립적인 DB 커넥터와 DAO를 만들 수 있다.
즉, 서로의 관심사로 나누어 코드를 작성할 수 있고 서로 간 변경 시 관련이 적어진다.  
보고 나니 네이티브 안드로이드에서 이벤트 리스너가 생각났다.

## 파일 구성

- `User.java` 사용자 정보를 저장할 자바빈 클래스
- `UserDao.java` 사용자 정보를 삽입하고 조회하는 DAO 클래스
- `UserDaoTest.java` 테스트 코드
- `ConnectionMaker.java` DB 커넥션을 가져오는 인터페이스
- `XConnectionMaker.java` DB 정보에 맞게 구현한 클래스

## 작업 사항

- `ConnectionMaker.java`를 작성하여 DB 커넥션 인터페이스 및 커넥션을 리턴하는 메소드를 분리
- `XConnectionMaker.java` 에서 `ConnectionMaker.java`를 구현하여 DB 정보에 맞는 커넥션 작성 
- `UserDao.java` 생성자에서 DB 커넥션 인터페이스를 파라미터로 지정
- `UserDaoTest.java` 에서 커넥션 객체를 생성하고 DAO 객체를 생성할 때 파라미터로 넘긴다.

## 핵심 사항
- [객체지향의 설계 원칙(SOLID)](http://www.nextree.co.kr/p6960/)
- 높은 응집도와 낮은 결합도
- 전략 패턴