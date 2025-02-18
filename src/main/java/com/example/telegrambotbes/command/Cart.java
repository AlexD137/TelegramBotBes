package com.example.telegrambotbes.command;

import com.example.telegrambotbes.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Cart implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String CART_MESSAGE = "cart";

    public Cart(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), CART_MESSAGE);
    }
}
