package com.example.telegrambotbes.service;

import com.example.telegrambotbes.bot.TelegramBotExecutor;
import com.example.telegrambotbes.buttons.MainMenuKeyboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {


    private final TelegramUserService telegramUserService;
    private final MessageSender messageSender;


    @Autowired
    public SendBotMessageServiceImpl(TelegramUserService telegramUserService, MessageSender messageSender) {

        this.telegramUserService = telegramUserService;
        this.messageSender = messageSender;
    }


    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try{
            messageSender.execute(sendMessage);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageWithInlineKeyboard(String chatId, String message, InlineKeyboardMarkup keyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            messageSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
