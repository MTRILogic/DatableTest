package com.mtrilogic.classes;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Datable implements Parcelable {
    public static final Creator<Datable> CREATOR = new ClassLoaderCreator<Datable>() {
        @Override
        public Datable createFromParcel(Parcel source, ClassLoader loader) {
            Bundle data = null;
            if (source != null && loader != null){
                data = source.readBundle(loader);
            }
            if (data == null){
                data = new Bundle();
            }
            return new Datable(data);
        }

        @Override
        public Datable createFromParcel(Parcel source) {
            return new Datable(new Bundle());
        }

        @Override
        public Datable[] newArray(int size) {
            return new Datable[size];
        }
    };

    public static final String DATA = "data", SIZE = "size";

    private final Bundle data;

    public Datable(Model model){
        this(new Bundle());
        saveModel(DATA, model);
    }

    public Datable(Model[] models){
        this(new Bundle());
        if (models != null) {
            int size = models.length;
            data.putInt(SIZE, size);
            for (int i = 0; i < size; i++) {
                saveModel(DATA + i, models[i]);
            }
        }
    }

    public Datable(ArrayList<Model> modelList){
        this(new Bundle());
        if (modelList != null) {
            int size = modelList.size();
            data.putInt(SIZE, size);
            for (int i = 0; i < size; i++) {
                saveModel(DATA + i, modelList.get(i));
            }
        }
    }

    private Datable(@NonNull Bundle data){
        this.data = data;
    }

    public Bundle getData() {
        return data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeBundle(data);
    }

    private void saveModel(@NonNull String key, Model model){
        if (model != null) {
            Bundle data = new Bundle();
            model.saveToData(data);
            this.data.putBundle(key, data);
        }
    }
}
