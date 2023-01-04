package com.mtrilogic.databletest.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Datable;
import com.mtrilogic.databletest.R;
import com.mtrilogic.databletest.models.TextModel;

public class TestActivity extends Activity {
    public static final String DATABLE = "datable";
    private TextView lblText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        lblText = findViewById(R.id.lblText);

        Intent intent = getIntent();
        if (intent != null){
            Datable datable = intent.getParcelableExtra(DATABLE);
            if (datable != null){
                Model[] models = datable.getModels(TextModel::new);
                for (Model model : models){
                    printTextModel((TextModel) model);
                }
            }
        }
    }

    private void printTextModel(TextModel model){
        String text = lblText.getText() + "\n" + model.getText();
        lblText.setText(text);
    }
}
