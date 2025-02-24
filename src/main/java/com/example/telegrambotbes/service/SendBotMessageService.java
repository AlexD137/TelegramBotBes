package com.example.telegrambotbes.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
    void sendMessageWithInlineKeyboard(String chatId, String message, InlineKeyboardMarkup keyboardMarkup);
}
