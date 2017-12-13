# 문자열 (String)
자바에서 문자열을 표현할 때 기본적으로는 `String`을 사용한다.

## `String`
- 불변형(immutable)
- 한 번 생성되면 할당된 메모리 공간이 변하지 않는다.
- 문자열 결합(`+`, `concat()`) 시 기존 `String` 객체에 추가된 문자열이 붙는 것이 아니라 새 `String` 객체에 연결된 문자열을 저장하고 이를 참조하도록 한다.

## `StringBuffer`, `StringBuilder`
- `String` 의 단점(immutable의 특성)을 극복하기 위해 두가지를 사용할 수 있다.

### 기본 특성
- 변형(mutable)
- 할당된 객체에서 유연하게 기존 버퍼 크기를 늘리고 줄인다.

### `StringBuffer`
- 각 메소드 별로 동기화 키워드(`Synchronized`) 키워드가 존재한다.
- 멀티스레드 환경에서도 동기화를 지원한다.
- 동기화 관련 처리로 인해 단일스레드에서는 `StringBuilder` 에 비해 느리다.

### `StringBuilder`
- 동기화를 보장하지 않는다.
- 단일스레드에서 사용하기 적합하다.
