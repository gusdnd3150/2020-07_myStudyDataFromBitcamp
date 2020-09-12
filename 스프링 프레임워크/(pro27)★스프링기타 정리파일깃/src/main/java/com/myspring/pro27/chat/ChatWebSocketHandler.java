package com.myspring.pro27.chat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {
	private Map<String,WebSocketSession> user= new ConcurrentHashMap<String,WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		user.put(session.getId(), session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		user.remove(session.getId());

	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	       Map<String,Object> map = session.getAttributes();
	       String name = (String) map.get("name");
	       
	       for (WebSocketSession s:user.values()) {
	    	   s.sendMessage(message);
	       }
	}
	
	

}
