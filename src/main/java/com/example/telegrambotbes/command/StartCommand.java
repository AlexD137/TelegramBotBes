package com.example.telegrambotbes.command;

import com.example.telegrambotbes.Entity.TelegramUser;
import com.example.telegrambotbes.service.SendBotMessageService;
import com.example.telegrambotbes.service.TelegramUserService;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Update;


@Slf4j
public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Добро пожаловать";


    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        log.debug("Вызван метод execute для chatId={}", chatId);

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    log.debug("Вызван метод setActive в оптионал");
                    telegramUserService.save(user);

                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    log.debug("Создан тг юзер{}", telegramUser);
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                    log.debug("Вызван метод сейв для {}  ", telegramUser.getChatId());
                });

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}