package com.example.telegrambotbes.callBack;

import com.example.telegrambotbes.service.SendBotMessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.List;

@Component
public class CallbackQueryHandlerFactory {

    private final List<CallbackQueryHandler> handlers;
    private final SendBotMessageService sendBotMessageService;


    public CallbackQueryHandlerFactory(List<CallbackQueryHandler> handlers, SendBotMessageService sendBotMessageService) {
        this.handlers = handlers;
        this.sendBotMessageService = sendBotMessageService;
    }

    public void handle(CallbackQuery callbackQuery) {
        String callbackData = callbackQuery.getData();

        for (CallbackQueryHandler handler : handlers) {
            if (handler.canHandle(callbackData)) {
                handler.handle(callbackQuery);
                return;
            }
        }
        String chatId = callbackQuery.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, "Неизвестная категория");


    }
}