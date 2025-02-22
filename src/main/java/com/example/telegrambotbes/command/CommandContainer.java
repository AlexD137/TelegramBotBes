package com.example.telegrambotbes.command;

import com.example.telegrambotbes.service.SendBotMessageService;
import com.example.telegrambotbes.service.TelegramUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.telegrambotbes.command.CommandName.*;


public class CommandContainer {


    private static final Logger logger = LoggerFactory.getLogger(CommandContainer.class);


    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {

        logger.info("Initializing CommandContainer");


        commandMap = new HashMap<>();
        commandMap.put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService));
        commandMap.put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService));
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendBotMessageService));
        commandMap.put(NO.getCommandName(), new NoCommand(sendBotMessageService));
        commandMap.put(CART.getCommandName(), new NoCommand(sendBotMessageService));
        commandMap.put(GOODS.getCommandName(), new NoCommand(sendBotMessageService));


        unknownCommand = new UnknownCommand(sendBotMessageService);

        logger.info("CommandContainer initialized with {} commands", commandMap.size());
    }

    public Command retrieveCommand(String commandIdentifier) {
        logger.info("Retrieving command: {}", commandIdentifier);
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}