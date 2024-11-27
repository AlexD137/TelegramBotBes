package com.example.telegrambotbes.service;

import com.example.telegrambotbes.bot.BesTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final BesTelegramBot besTelegramBot;


    @Autowired
    public SendBotMessageServiceImpl(BesTelegramBot besTelegramBot) {
        this.besTelegramBot = besTelegramBot;
    }


    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try{
            besTelegramBot.execute(sendMessage);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
