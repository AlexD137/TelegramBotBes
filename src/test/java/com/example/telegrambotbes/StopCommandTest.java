package com.example.telegrambotbes;

import com.example.telegrambotbes.command.Command;
import com.example.telegrambotbes.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.example.telegrambotbes.command.CommandName.STOP;
import static com.example.telegrambotbes.command.StopCommand.STOP_MESSAGE;

//@DisplayName("Unit-level testing for StopCommand")
//public class StopCommandTest extends AbstractCommandTest {
//
//    @Override
//    String getCommandName() {
//        return STOP.getCommandName();
//    }
//
//    @Override
//    String getCommandMessage() {
//        return STOP_MESSAGE;
//    }
//
//    @Override
//    Command getCommand() {
//        return new StopCommand(sendBotMessageService);
//    }
//}