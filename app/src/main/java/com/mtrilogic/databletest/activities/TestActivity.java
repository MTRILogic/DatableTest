package com.mtrilogic.databletest.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.ModelFactory;
import com.mtrilogic.databletest.R;
import com.mtrilogic.databletest.models.ListTextModel;
import com.mtrilogic.databletest.models.TextModel;

import java.util.ArrayList;

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
            Model[] models = new ModelFactory(intent.getParcelableExtra(DATABLE)).getModels(ListTextModel::new);
            for (Model model : models){
                listModels((ListTextModel) model);
            }
        }
    }

    private void listModels(ListTextModel model){
        printTextModel(model);
        listSubModels(model.getModelList());
    }

    private void listSubModels(ArrayList<Model> modelList){
        for (Model model : modelList){
            printTextModel((TextModel) model);
        }
    }

    private void printTextModel(TextModel model){
        String text = lblText.getText() + "\n" + model.getText();
        lblText.setText(text);
    }
}
