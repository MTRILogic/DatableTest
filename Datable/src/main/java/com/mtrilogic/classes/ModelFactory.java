package com.mtrilogic.classes;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.interfaces.DataIterationListener;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class ModelFactory {
    private Bundle data;
    private int size;

    public ModelFactory(Datable datable){
        if (datable != null){
            data = datable.getData();
            size = data.getInt(Datable.MODEL);
        }
    }

    public Model[] getModels(@NonNull DataIterationListener listener){
        Model[] models = new Model[size];
        for (int i = 0; i < size; i++){
            models[i] = getModelFromIteration(i, listener);
        }
        return models;
    }

    public ArrayList<Model> getModelList(@NonNull DataIterationListener listener){
        ArrayList<Model> modelList = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            modelList.add(i, getModelFromIteration(i, listener));
        }
        return modelList;
    }

    private Model getModelFromIteration(int i, DataIterationListener listener){
        Datable datable = data.getParcelable(Datable.MODEL + i);
        return listener.onDataIteration(datable != null ? datable.getData() : null);
    }
}