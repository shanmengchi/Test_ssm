package com.shan.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * WebSocket的session拦截处理
 * WebSocketInterceptor对WebSocket的连接进行过滤，可以对连接前和连接后自定义处理
 * @author Administrator
 *
 */
@Component
public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor{  
  
    @Override  
    public boolean beforeHandshake(ServerHttpRequest request,  
            ServerHttpResponse response, WebSocketHandler wsHandler,  
            Map<String, Object> attributes) throws Exception {  
        System.out.println("==================Before Handshake===============");  
        return super.beforeHandshake(request, response, wsHandler, attributes);   
    }  
  
    @Override  
    public void afterHandshake(ServerHttpRequest request,  
            ServerHttpResponse response, WebSocketHandler wsHandler,  
            Exception ex) {  
    	 System.out.println("==================After Handshake===============");  
         super.afterHandshake(request, response, wsHandler, ex);  
    }  
  
}  
