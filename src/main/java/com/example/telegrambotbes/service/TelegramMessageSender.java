package com.example.telegrambotbes.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramMessageSender implements MessageSender {

    private final TelegramLongPollingBot telegramBot;

    public TelegramMessageSender(TelegramLongPollingBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public void execute(SendMessage sendMessage) throws TelegramApiException {
        telegramBot.execute(sendMessage);
    }
}