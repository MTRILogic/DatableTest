package com.mtrilogic.classes;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.interfaces.RestorableModelListener;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Restorable {
    private Bundle data;

    public Restorable(Datable datable){
        if (datable != null){
            data = datable.getData();
        }
    }

    public <M extends Model> M getModel(@NonNull Class<M> clazz, @NonNull RestorableModelListener listener){
        if (data != null) {
            return clazz.cast(restoreModel(Datable.DATA, listener));
        }
        return null;
    }

    public Model[] getModels(@NonNull RestorableModelListener listener){
        if (data != null) {
            int size = data.getInt(Datable.SIZE);
            Model[] models = new Model[size];
            for (int i = 0; i < size; i++) {
                models[i] = restoreModel(Datable.DATA + i, listener);
            }
            return models;
        }
        return null;
    }

    public ArrayList<Model> getModelList(@NonNull RestorableModelListener listener){
        if (data != null) {
            int size = data.getInt(Datable.SIZE);
            ArrayList<Model> modelList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                modelList.add(i, restoreModel(Datable.DATA + i, listener));
            }
            return modelList;
        }
        return null;
    }

    private Model restoreModel(@NonNull String key, @NonNull RestorableModelListener listener){
        Bundle data = this.data.getBundle(key);
        if (data != null){
            return listener.restoreModel(data);
        }
        return null;
    }
}
