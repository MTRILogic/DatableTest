package com.mtrilogic.classes;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Datable implements Parcelable {
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

    public static final String MODEL = "model";

    private final Bundle data;

    public Datable(){
        data = new Bundle();
    }

    public Datable(@NonNull Model model){
        this(new Bundle());
        model.saveToData(data);
    }

    public Datable(@NonNull Model[] models){
        this(new Bundle());
        int size = models.length;
        data.putInt(MODEL, size);
        for (int i = 0; i < size; i++){
            Datable datable = new Datable();
            models[i].saveToData(datable.data);
            data.putParcelable(MODEL + i, datable);
        }
    }

    public Datable(@NonNull ArrayList<Model> modelList){
        this(new Bundle());
        int size = modelList.size();
        data.putInt(MODEL, size);
        for (int i = 0; i < size; i++){
            Datable datable = new Datable();
            modelList.get(i).saveToData(datable.data);
            data.putParcelable(MODEL + i, datable);
        }
    }

    private Datable(@NonNull Bundle data){
        this.data = data;
    }

    public Bundle getData() {
        return data;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeBundle(data);
    }
}
