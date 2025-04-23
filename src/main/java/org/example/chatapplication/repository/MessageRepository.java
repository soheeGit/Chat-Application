package org.example.chatapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    @Autowired
    public MessageRepository(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    // 메시지 발행 (publish)
    public void publishMessage(String message) {
        // Redis 채널에 메시지 발행
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
