package com.tucomunidad.api.service;

import com.tucomunidad.api.model.Chat;
import com.tucomunidad.api.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

    public Optional<Chat> findById(Long id) {
        return chatRepository.findById(id);
    }

    public List<Chat> findByCommunityId(Long communityId) {
        return chatRepository.findByComunidad_IdAndParentChatIsNull(communityId);
    }

    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }

    public Chat replyToChat(Long chatId, Chat reply) {
        return chatRepository.findById(chatId).map(parent -> {
            reply.setParentChat(parent);
            return chatRepository.save(reply);
        }).orElse(null);
    }
}
