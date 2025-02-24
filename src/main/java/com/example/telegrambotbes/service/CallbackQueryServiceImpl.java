package com.example.telegrambotbes.service;

import com.example.telegrambotbes.callBack.CallbackQueryHandlerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Service
public class CallbackQueryServiceImpl implements CallbackQueryService {

    private final CallbackQueryHandlerFactory callbackQueryHandlerFactory;

    public CallbackQueryServiceImpl(CallbackQueryHandlerFactory callbackQueryHandlerFactory) {
        this.callbackQueryHandlerFactory = callbackQueryHandlerFactory;
    }

    @Override
    public void handleCallbackQuery(CallbackQuery callbackQuery) {
        callbackQueryHandlerFactory.handle(callbackQuery);
    }
}