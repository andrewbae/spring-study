# HTTP
- HyperText Transfer Protocol
- 서버/클라이언트 모델을 따르는 요청(request)/응답(response) 프로토콜
- TCP, UDP 사용
- 기본포트 80

## 1. HTTP 메소드 (HTTP Method)
|메소드|요청 Body 유무|응답 Body 유무|캐시 가능|
|---|:---:|:---:|:---:|
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
- [HTTP 상태 코드 (상태 코드 포함)](####2.2.1-주요-HTTP-상태-코드)

#### 2.2.1. 주요 HTTP 상태 코드
참고 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status

|Code|Message|Description|
|---|---|---|
|100|Continue|첫 번째 부분을 받았으며 나머지를 기다리고 있음.|
|101|Switching Protocol|프로토콜 전환 요청을 승인하는 중.|
|200|OK|요청이 성공적으로 수행되어 제공됨.|
|201|Created|새 리소스가 생성됨. 일반적으로 PUT 요청 이후에 전송됨.|
|202|Accepted|서버가 요청을 접수했지만 아직 처리하지 않음.|
|400|Bad Request|서버가 요청한 구문을 이해하지 못함.|
|401|Unauthorized|요청된 응답을 얻으려면 인증이 필요함. 인증 실패.|
|403|Forbidden|클라이언트의 액세스 권한이 없음으로 거부함. 인가 실패.|
|404|Not Found|서버가 요청한 페이지를 찾을을 수없음.|
|500|Internal Server Error|서버 오류 발생으로 요청 수행 불가.|
|502|Bad Gateway|요청을 처리하는 데 필요한 응답을 얻기 위해 게이트웨이로 작업하는 동안 유효하지 않은 응답음 얻음.|
|503|Service Unavailable|서버가 요청을 처리할 준비가 되지 않음. 일반적으로 유지보수를 위해 작동하지 않거나 과부하 상태인 상태|
