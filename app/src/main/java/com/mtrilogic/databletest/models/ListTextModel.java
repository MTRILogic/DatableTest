package com.mtrilogic.databletest.models;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.classes.Datable;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class ListTextModel extends Model {
    private static final String LIST = "list";

    private ArrayList<Model> modelList;

    public ListTextModel(long itemId) {
        super(itemId, 0, true);
    }

    public ListTextModel(@NonNull Datable datable) {
        super(datable);
    }

    public ArrayList<Model> getModelList() {
        return modelList;
    }

    public void setModelList(ArrayList<Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public void restoreFromData(@NonNull Datable datable) {
        super.restoreFromData(datable);
        modelList = datable.getModelList(LIST, TextModel::new);
    }

    @Override
    public void saveToData(@NonNull Datable datable) {
        super.saveToData(datable);
        datable.putModelList(LIST, modelList);
    }
}
