package com.mtrilogic.databletest.models;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Datable;

@SuppressWarnings("unused")
public class TextModel extends Model {
    private static final String TEXT = "text";

    private String text;

    public TextModel(long itemId) {
        super(itemId, 0, true);
    }

    public TextModel(@NonNull Datable datable) {
        super(datable);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void restoreFromData(@NonNull Datable datable) {
        super.restoreFromData(datable);
        text = datable.getString(TEXT);
    }

    @Override
    public void saveToData(@NonNull Datable datable) {
        super.saveToData(datable);
        datable.putString(TEXT, text);
    }
}
