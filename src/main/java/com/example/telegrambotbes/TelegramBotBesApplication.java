package com.example.telegrambotbes;

import com.example.telegrambotbes.bot.BesTelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
public class TelegramBotBesApplication {

    private static final Logger logger = LoggerFactory.getLogger(TelegramBotBesApplication.class);

    public static void main(String[] args) {
        logger.info("Starting TelegramBotBesApplication");
        SpringApplication.run(TelegramBotBesApplication.class, args);
        logger.info("TelegramBotBesApplication started successfully");
    }

    @Bean
    public TelegramBotsApi telegramBotsApi(BesTelegramBot bot) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(bot);
        logger.info("✅ Бот успешно зарегистрирован в TelegramBotsApi!");
        return botsApi;
    }
}
