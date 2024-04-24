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

    @PostMapping("/{chatId}/reply")
    public ResponseEntity<Chat> replyToChat(@PathVariable Long chatId, @RequestBody Chat reply) {
        Chat repliedChat = chatService.replyToChat(chatId, reply);
        if (repliedChat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repliedChat);
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getChat(@RequestParam(required = false) Long communityId) {
        if (communityId != null) {
            List<Chat> chats = chatService.findByCommunityId(communityId);
            return ResponseEntity.ok(chats);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
