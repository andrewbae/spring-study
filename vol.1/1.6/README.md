# 1.6 싱글톤 레지스트리로서의 애플리케이션 컨텍스트
기존 코드에서 변경된 부분은 없다. 왜냐하면 이미 작업하면서 싱글톤 레지스트리를 사용하고 있었기 때문이다.
단, 테스트 코드에서 DaoFactory를 직접 사용할 경우와 애플리케이션 컨텍스트를 사용한 비교 코드만 변경이 되었다.  
핵심은 대규모 엔터프라이즈 시스템에서 클라이언트의 요청이 올 때마다 오브젝트를 만드는 것은 매우 비효율적이고 서버에 부하가 심하게 걸릴 우려가 있어 싱글톤을 사용하고 싶은데 고전적인 싱글톤 패턴을 사용할 경우 스프링이 지향하는 객체지향적인 설계 방식과 원칙, 디자인 패턴 등을 적용하는데 어려움이 있고 서버 환경에서 완전한 싱글톤을 보장할 수 없다는 것이다. **그렇기 때문에 스프링은 평범한 자바 클래스를 싱글톤으로 활용할 수 있게 만들어주는 기능을 싱글톤 레지스트리라는 것으로 제공한다는 점이다.**

## 파일 구성
- `com.andrewbae.spring.domain.*`: 자바빈 클래스
- `com.andrewbae.spring.dao.*`: DAO 클래스
- `com.andrewbae.spring.factory.*`: 팩토리 클래스 > 스프링에서 사용할 설정 정보
- `ConnectionMaker.java`: DB 커넥션 인터페이스
- `XConnectionMaker.java`: `ConnectionMaker.java` 구현 코드
- `UserDaoTest.java`: 테스트 코드

## 예시
테스트 코드와 결과이다.
```java
public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // DaoFactory를 직접 사용.
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println("DaoFactory 직접 사용");
        System.out.println(dao1);
        System.out.println(dao2);
        System.out.println("dao1 == dao2: " + (dao1 == dao2));

        System.out.println("=========================================");

        // DaoFactory를 설정정보로 사용하는 애플리케이션 컨텍스트 생성.
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao3 = ctx.getBean("userDao", UserDao.class);
        UserDao dao4 = ctx.getBean("userDao", UserDao.class);

        System.out.println("애플리케이션 컨텍스트를 통해 DaoFactory 사용");
        System.out.println(dao3);
        System.out.println(dao4);
        System.out.println("dao1 == dao2: " + (dao3 == dao4));
    }
}
```

결과 콘솔 복붙시 스프링 로딩부분 삭제함.
```
DaoFactory 직접 사용
com.andrewbae.spring.dao.UserDao@79b4d0f
com.andrewbae.spring.dao.UserDao@6b2fad11
dao1 == dao2: false
=========================================
애플리케이션 컨텍스트를 통해 DaoFactory 사용
com.andrewbae.spring.dao.UserDao@609e8838
com.andrewbae.spring.dao.UserDao@609e8838
dao1 == dao2: true
```

이 결과를 통하여 직접 `DaoFactory`를 사용할 때는 `userDao`를 생성할때마다 새로운 객체를 생성하지만 애플리케이션 컨텍스트를 사용하면 하나의 `userDao` 객체를 사용한다는 것을 알 수 있다. 이렇게 스프링에서는 싱글톤 레지스트리를 사용하여 평범한 클래스를 싱글톤으로 사용할 수 있고 객체지향적인 설계도 가능하다는 점을 알 수 있다.

## 주의할점!
물론 스프링에서 대부분 처리해주지만 개발자가 주의해야할 부분도 있다.

### 싱글톤과 오브젝트의 상태
- 인스턴스 변수(전역변수)는 읽기전용 객체에만 사용해야 한다.
- 매번 바뀌는 값을 인스턴스 변수(전역변수)로 선언할 경우 여러 사용자가 동시에 접속 시 심각한 문제가 발생할 수 있다.
- 파라미터, 로컬 변수, 리턴 값 등을 이용하여 처리할 수 있다.

### 스프링 빈의 스코프
- 스프링 빈의 기본 스코프는 싱글톤(singleton)이다.
- 그 외 프로토타입, 요청, 세션 등 다양한 스코프가 있다.
