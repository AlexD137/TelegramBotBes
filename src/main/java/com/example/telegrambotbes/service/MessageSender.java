package com.example.telegrambotbes.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface MessageSender {
    void execute(SendMessage sendMessage) throws TelegramApiException;
}