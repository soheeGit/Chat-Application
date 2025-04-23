package org.example.chatapplication.controller;

import org.example.chatapplication.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // 클라이언트에서 /app/chat로 보내는 메시지를 처리
    @MessageMapping("/chat")
    public void sendMessage(String message) {
        // ChatService를 통해 메시지 처리
        chatService.sendMessage(message);
    }
}
