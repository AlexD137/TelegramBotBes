package com.example.telegrambotbes.bot;

import com.example.telegrambotbes.command.CommandContainer;
import com.example.telegrambotbes.service.SendBotMessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegrambotbes.command.CommandName.NO;


@Component
public class BesTelegramBot extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(BesTelegramBot.class);
    public static String COMMAND_PREFIX = "/";

    private final String username;
    private final CommandContainer commandContainer;

    public BesTelegramBot(@Value("${bot.token}") String botToken,
                          @Value("${bot.username}") String botUsername) {
        super(new DefaultBotOptions(), botToken);
        this.username = botUsername;

        logger.info("Bot initialized with token: {}", botToken);
        logger.info("Bot username: {}", username);

        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            logger.info("Received message: {}", message);
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                logger.info("Executing command: {}", commandIdentifier);
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }
}

