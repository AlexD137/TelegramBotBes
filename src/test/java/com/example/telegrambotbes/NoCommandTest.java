package com.example.telegrambotbes;

import com.example.telegrambotbes.command.Command;
import com.example.telegrambotbes.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.example.telegrambotbes.command.CommandName.NO;
import static com.example.telegrambotbes.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}