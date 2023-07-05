package com.cos.websocket.Service;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/chatt")
@Service
public class WebSocketChatting {

    // 사용자들
    private static Set<Session> CLIENTS = Collections.synchronizedSet(new HashSet<>());

    // 사용자 접속 시 세션 연결
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.toString());

        // clients가 있다면 true
        if(CLIENTS.contains(session)) {
            System.out.println("이미 연결된 세션 : " + session);
        } else {
            // clients에 세션을 추가
            CLIENTS.add(session);
            System.out.println("새로운 세션 : " + session);
        }
    }

    // 사용자 종료 시 세션 제거
    @OnClose
    public void onClose(Session session) throws Exception {
        CLIENTS.remove(session);
        System.out.println("세션 종료 : " + session);
    }

    // 사용자 간 메세지 주고 받기
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.println("입력된 메세지: " + message);

        for(Session client : CLIENTS) {
            System.out.println("입력된 메세지: " + message);
            // client에 메세지를 전송(반복문이므로 세션에 참가한 사람 한명마다 일일이 전송)
            client.getBasicRemote().sendText(message);
        }
    }
}
