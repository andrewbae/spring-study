# HTTP
- HyperText Transfer Protocol
- 서버/클라이언트 모델을 따르는 요청(request)/응답(response) 프로토콜
- TCP, UDP 사용
- 기본포트 80

## 1. HTTP 메소드 (HTTP Method)
|메소드|요청 Body 유무|응답 Body 유무|캐시 가능|
|---|---|---|---|---|
|GET|N|Y|Y|
|POST|Y|Y|Y|
|PUT|Y|Y|N|
|DELETE|N|Y|N|
|HEAD|N|N|Y|
|CONNECT|Y|Y|N|
|OPTIONS|options|Y|N|
|TRACE|N|Y|N|
|PATCH|Y|Y|Y|

## 2. HTTP 메시지
- HTTP 메시지는 요청(Request)과 응답(Response)로 나뉘어져 있고 각자의 특성이 있는 형식이 있다.
- 기본적으로 헤더(Header)와 바디(Body)로 구성되어 있다.

### 2.1. 요청 메시지 (Request)
- HTTP 프로토콜 버전
- HTTP 메소드
- URL

### 2.2. 응답 메시지 (Response)
- HTTP 프로토콜 버전
- HTTP 상태 코드 (상태 코드 포함)

#### 2.2.1. HTTP 상태 코드
