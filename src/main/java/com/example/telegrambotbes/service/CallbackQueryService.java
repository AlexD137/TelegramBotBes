package com.example.telegrambotbes.service;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public interface CallbackQueryService {
    void handleCallbackQuery(CallbackQuery callbackQuery);
}