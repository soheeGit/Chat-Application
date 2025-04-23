package org.example.chatapplication.service;

import org.example.chatapplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final MessageRepository messageRepository;

    @Autowired
    public ChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // 메시지를 처리하고, Redis 채널에 발행하는 메서드
    public void sendMessage(String message) {
        // 메시지를 Redis로 발행
        messageRepository.publishMessage(message);
    }
}
