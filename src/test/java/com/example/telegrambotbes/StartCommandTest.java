//package com.example.telegrambotbes;
//
//import com.example.telegrambotbes.command.Command;
//import com.example.telegrambotbes.command.StartCommand;
//import org.junit.jupiter.api.DisplayName;
//
//import static com.example.telegrambotbes.command.CommandName.START;
//import static com.example.telegrambotbes.command.StartCommand.START_MESSAGE;
//
//@DisplayName("Unit-level testing for StartCommand")
//class StartCommandTest extends AbstractCommandTest {
//
//    @Override
//    String getCommandName() {
//        return START.getCommandName();
//    }
//
//    @Override
//    String getCommandMessage() {
//        return START_MESSAGE;
//    }
//
//    @Override
//    Command getCommand() {
//        return new StartCommand(sendBotMessageService);
//    }
//}