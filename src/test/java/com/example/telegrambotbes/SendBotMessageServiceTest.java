package com.example.telegrambotbes;

import com.example.telegrambotbes.bot.BesTelegramBot;
import com.example.telegrambotbes.service.SendBotMessageService;
import com.example.telegrambotbes.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private BesTelegramBot besTelegramBot;

    @BeforeEach
    public void init() {
        besTelegramBot = Mockito.mock(BesTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(besTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {

        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);


        sendBotMessageService.sendMessage(chatId, message);


        Mockito.verify(besTelegramBot).execute(sendMessage);
    }
}