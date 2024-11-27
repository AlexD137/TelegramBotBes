package com.example.telegrambotbes.command;

import com.example.telegrambotbes.service.SendBotMessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.telegrambotbes.command.CommandName.*;


public class CommandContainer {

    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = new HashMap<>();
        commandMap.put(START.getCommandName(), new StartCommand(sendBotMessageService));
        commandMap.put(STOP.getCommandName(), new StopCommand(sendBotMessageService));
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendBotMessageService));
        commandMap.put(NO.getCommandName(), new NoCommand(sendBotMessageService));


        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}