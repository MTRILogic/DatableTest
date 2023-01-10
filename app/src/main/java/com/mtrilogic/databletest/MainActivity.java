package com.mtrilogic.databletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Datable;
import com.mtrilogic.databletest.activities.TestActivity;
import com.mtrilogic.databletest.models.ListTextModel;
import com.mtrilogic.databletest.models.TextModel;

import java.util.ArrayList;

/**
 * Este proyecto es un intento de facilitar el uso de parcelable en Android, usando una clase única
 * que lo implemente. Pero es algo complicado de lograr cuando se usan arrays y collections, debido
 * a que los parcelables tienen que ser reconstruidos durante su retorno a su tipo correspondiente,
 * mediante un proceso engorroso.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(v -> {
            Model[] models = getModels();
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            intent.putExtra(TestActivity.DATABLE, new Datable(models));
            startActivity(intent);
        });
    }

    private Model[] getModels(){
        Model[] models = new Model[5];
        for (int i = 0; i < models.length; i++){
            ListTextModel model = new ListTextModel(i);
            model.setText("Model " + i);
            model.setModelList(getModelList());
            models[i] = model;
        }
        return models;
    }

    private ArrayList<Model> getModelList(){
        ArrayList<Model> modelList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            TextModel model = new TextModel(i);
            model.setText("SubModel " + i);
            modelList.add(i, model);
        }
        return modelList;
    }
}