package com.mtrilogic.databletest.models;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Datable;
import com.mtrilogic.classes.ModelFactory;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class ListTextModel extends TextModel{
    private static final String LIST = "list";

    private ArrayList<Model> modelList;

    public ListTextModel(long itemId) {
        super(itemId);
    }

    public ListTextModel(@NonNull Bundle data) {
        super(data);
    }

    public ArrayList<Model> getModelList() {
        return modelList;
    }

    public void setModelList(ArrayList<Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public void restoreFromData(@NonNull Bundle data) {
        super.restoreFromData(data);
        modelList = new ModelFactory(data.getParcelable(LIST)).getModelList(TextModel::new);
    }

    @Override
    public void saveToData(@NonNull Bundle data) {
        super.saveToData(data);
        data.putParcelable(LIST, new Datable(modelList));
    }
}
