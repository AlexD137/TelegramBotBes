package com.example.telegrambotbes.command;

import com.example.telegrambotbes.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Goods implements Command{

    private final SendBotMessageService sendBotMessageService;


    public static final String GOODS_MESSAGE = "goods";


    public Goods(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;

    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), GOODS_MESSAGE);
    }
}
