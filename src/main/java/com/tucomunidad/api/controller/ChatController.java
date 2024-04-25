package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Chat;
import com.tucomunidad.api.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        Chat savedChat = chatService.save(chat);
        return ResponseEntity.ok(savedChat);
    }

    @PostMapping("/{chatId}/chat")
    public ResponseEntity<Chat> updateChat(@PathVariable Long chatId, @RequestBody Chat chat) {
        Chat updatedChat = chatService.updateChat(chatId, chat);
        if (updatedChat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedChat);
    }

    @GetMapping
    public ResponseEntity<?> getChats(@RequestParam(required = false) String communityId) {
        try {
            if (communityId != null && !communityId.isEmpty()) {
                Long id = Long.parseLong(communityId);
                List<Chat> chats = chatService.findByCommunityId(id);
                return ResponseEntity.ok(chats);
            }
            return ResponseEntity.ok(chatService.findAll());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid community ID: " + communityId);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
