package com.mtrilogic.databletest.models;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

@SuppressWarnings("unused")
public class TextModel extends Model {
    private static final String TEXT = "text";

    private String text;

    public TextModel(long itemId) {
        super(itemId, 0, true);
    }

    public TextModel(@NonNull Bundle data) {
        super(data);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void restoreFromData(@NonNull Bundle data) {
        super.restoreFromData(data);
        text = data.getString(TEXT);
    }

    @Override
    public void saveToData(@NonNull Bundle data) {
        super.saveToData(data);
        data.putString(TEXT, text);
    }
}
