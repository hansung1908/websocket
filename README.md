# websocket
- websocket을 활용하여 제작한 채팅 서비스

### java, spring boot
- web, websocket, thymeleaf, lombok, devtools

### Web Socket이란?
- 웹 소켓 프로토콜인 RFC 6455는 단일 TCP 연결을 통해 Client와 Server 사이에 전이중 방향 통신(Full Duplex, 2-way Communication) 채널을 설정하는 표준화된 방법을 제공한다.
- HTTP 환경에서, HTTP와는 다른 TCP 프로토콜이나, Port 80 및 443을 사용해 HTTP를 통해 작동하며, 기존 방화벽 규칙을 재사용할 수 있도록 설계되었다.
Spring 스펙에서 'Web'에 속해있으며, Spring 4.0에서 등장한 네트워크 서비스이다. 기존에 채팅을 구현하려면 일반적인 Java Socket을 사용해야 했다. Java Socket으로 소켓 통신의 과정을 일일이 구현해야 했다. HTTP 통신은 기본적으로 비연결성(Connectless) 통신이므로, Client에게 한 번 보내고 나면 연결이 끊겨 지속적으로 데이터를 주고 받을 수 없다. 
- 임시 방편으로 Ajax를 사용한 비동기적 통신을 통해 주기적으로 한 페이지 안에서 Server한테 자신에게 보낼 정보가 있는지 요청(Request)하거나, 페이지가 이동될 때 마다 자신에게 온 정보가 있는지에 대한 질문을 요청에 포함할 수 있었다.
 

### Web Socket과 TCP
- 웹 소켓은 연결 요청에 대해 HTTP를 통해 Switching 및 HandShaking이 이루어진다.
TCP는 이진(Binary)데이터만 주고 받을 수 있으나, 웹 소켓은 Binary와 Text 데이터도 주고 받을 수 있다.
 

### Web Socket과 HTTP
- 웹 소켓은 HTTP 호환이 가능하게 설계되었고, HTTP 요청으로 시작하나 두 Protocol의 아키텍쳐와 Application Programming Model은 매우 다르다 *
- HTTP와 REST에서 Application은 여러 URL(Uniform Resource Location)로 모델링 된다. 반면에 웹 소켓은 일반적으로 초기 연결을 위한 URL이 한 개만 존재한다. 결과적으로 모든 Application 내 메세지는 동일한 TCP 연결을 통해 흐른다. 이는 완전히 다른 '비동기식 이벤트' 중심의 메세지 전달 아키텍쳐를 나타낸다.
웹 소켓은 HTTP와 달리 메세지 내용에 의미를 규정하지 않는 저수준 전송 프로토콜이다. 즉, Client와 Server가 메세지 시멘틱에 동의하지 않으면 메세지를 라우팅하거나 처리할 수 없다.
 

### Web Socket의 특징
- HTTP 통신의 단점 개선
- 영구적 양방향 통신
- HTML 5의 주요 API
- HTTP 프로토콜을 기반으로 하는 웹 브라우저의 웹 서버간 양방향 통신을 지원하기 위한 표준
- Client/Server가 실시간으로 데이터를 주고 받을 수 있다.
