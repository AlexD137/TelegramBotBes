package com.example.telegrambotbes.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MainMenuKeyboard {

    public ReplyKeyboardMarkup create() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true); // Автоматически подгонять размер кнопок
        keyboardMarkup.setOneTimeKeyboard(false); // Клавиатура остается внизу чата

        // Создаем список строк кнопок
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        // Первая строка: Товары и Корзина
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Товары");
        row1.add("Корзина");
        keyboardRows.add(row1);

        // Вторая строка: Новости и Помощь
        KeyboardRow row2 = new KeyboardRow();
        row2.add("Новости");
        row2.add("Помощь");
        keyboardRows.add(row2);

        // Третья строка: Заказы и Настройка
        KeyboardRow row3 = new KeyboardRow();
        row3.add("Заказы");
        row3.add("Настройка");
        keyboardRows.add(row3);

        // Устанавливаем список строк в клавиатуру
        keyboardMarkup.setKeyboard(keyboardRows);

        return keyboardMarkup;
    }
}