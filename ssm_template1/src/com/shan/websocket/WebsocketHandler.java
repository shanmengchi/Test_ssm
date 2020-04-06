package com.shan.websocket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class WebsocketHandler extends TextWebSocketHandler {  
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server"); 
		logger.info("======="+returnMessage.toString());
        session.sendMessage(returnMessage);  
	}
}  
