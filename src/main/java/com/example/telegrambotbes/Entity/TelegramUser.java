package com.example.telegrambotbes.Entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "tg_user")
public class TelegramUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chatId")
    private String chatId;

    @Column(name = "active")
    private boolean active;


}