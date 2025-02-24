package com.example.telegrambotbes.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardFactory {

    public InlineKeyboardMarkup createCategoryKeyboard() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(InlineKeyboardButton.builder()
                .text("Категория 1")
                .callbackData("category_1")
                .build());
        row1.add(InlineKeyboardButton.builder()
                .text("Категория 2")
                .callbackData("category_2")
                .build());
        rows.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(InlineKeyboardButton.builder()
                .text("Категория 3")
                .callbackData("category_3")
                .build());
        row2.add(InlineKeyboardButton.builder()
                .text("Категория 4")
                .callbackData("category_4")
                .build());
        rows.add(row2);

        keyboardMarkup.setKeyboard(rows);
        return keyboardMarkup;
    }
}