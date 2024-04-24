package com.tucomunidad.api.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable = false)
    private Comunidad comunidad;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @OneToMany(mappedBy = "parentChat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chat> replies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Chat parentChat;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Chat> getReplies() {
        return replies;
    }

    public void setReplies(List<Chat> replies) {
        this.replies = replies;
    }

    public Chat getParentChat() {
        return parentChat;
    }

    public void setParentChat(Chat parentChat) {
        this.parentChat = parentChat;
    }
}
