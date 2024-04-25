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

    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    public List<Chat> findByCommunityId(Long communityId) {
        return chatRepository.findByComunidad_Id(communityId);
    }

    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }

    public Chat updateChat(Long chatId, Chat chat) {
        return chatRepository.findById(chatId).map(existingChat -> {
            existingChat.setSender(chat.getSender());
            existingChat.setMessage(chat.getMessage());
            existingChat.setFecha(chat.getFecha());
            existingChat.setUsuarios(chat.getUsuarios());
            existingChat.setChats(chat.getChats());
            return chatRepository.save(existingChat);
        }).orElse(null);
    }
}
