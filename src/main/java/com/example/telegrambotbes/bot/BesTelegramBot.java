package com.example.telegrambotbes.bot;

import com.example.telegrambotbes.buttons.MainMenuKeyboard;
import com.example.telegrambotbes.command.CommandContainer;
import com.example.telegrambotbes.service.CallbackQueryService;
import com.example.telegrambotbes.service.SendBotMessageServiceImpl;
import com.example.telegrambotbes.service.TelegramMessageSender;
import com.example.telegrambotbes.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import static com.example.telegrambotbes.command.CommandName.NO;


@Component
public class BesTelegramBot extends TelegramLongPollingBot {



    public static String COMMAND_PREFIX = "/";
    private final String username;
    private final CommandContainer commandContainer;
    private final CallbackQueryService callbackQueryService;

    public BesTelegramBot(@Value("${bot.token}") String botToken,
                          @Value("${bot.username}") String botUsername, TelegramUserService telegramUserService,
                          CallbackQueryService callbackQueryService) {
        super(new DefaultBotOptions(), botToken);

        this.username = botUsername;
        this.callbackQueryService = callbackQueryService;
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(telegramUserService,
                new TelegramMessageSender(this)));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }
        } else if (update.hasCallbackQuery()) {
            callbackQueryService.handleCallbackQuery(update.getCallbackQuery());
        }
        else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }




    @Override
    public String getBotUsername() {
        return username;
    }
}

