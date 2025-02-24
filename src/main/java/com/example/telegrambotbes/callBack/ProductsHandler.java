package com.example.telegrambotbes.callBack;

import com.example.telegrambotbes.buttons.InlineKeyboardFactory;
import com.example.telegrambotbes.service.SendBotMessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component
public class ProductsHandler implements CallbackQueryHandler {

    private final SendBotMessageService sendBotMessageService;
    private final InlineKeyboardFactory inlineKeyboardFactory;

    public ProductsHandler(SendBotMessageService sendBotMessageService,
                           InlineKeyboardFactory inlineKeyboardFactory) {
        this.sendBotMessageService = sendBotMessageService;
        this.inlineKeyboardFactory = inlineKeyboardFactory;
    }

    @Override
    public boolean canHandle(String callbackData) {
        return "products".equals(callbackData);
    }

    @Override
    public void handle(CallbackQuery callbackQuery) {
        String chatId = callbackQuery.getMessage().getChatId().toString();
        InlineKeyboardMarkup keyboardMarkup = inlineKeyboardFactory.createCategoryKeyboard();
        sendBotMessageService.sendMessageWithInlineKeyboard(chatId, "Выберите категорию:", keyboardMarkup);
    }
}