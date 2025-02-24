package com.example.telegrambotbes.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainMenuKeyboard {

    public ReplyKeyboardMarkup create() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Товары");
        row1.add("Корзина");
        keyboardRows.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add("Новости");
        row2.add("Помощь");
        keyboardRows.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add("Заказы");
        row3.add("Настройка");
        keyboardRows.add(row3);

        keyboardMarkup.setKeyboard(keyboardRows);

        return keyboardMarkup;
    }
}