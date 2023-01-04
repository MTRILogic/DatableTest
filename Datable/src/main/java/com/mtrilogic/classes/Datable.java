package com.mtrilogic.classes;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.interfaces.DatableIterationListener;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Datable implements Parcelable {

    public static final Creator<Datable> CREATOR = new ClassLoaderCreator<Datable>() {
        @Override
        public Datable createFromParcel(Parcel source, ClassLoader loader) {
            if (source != null && loader != null){
                Bundle data = source.readBundle(loader);
                String key = source.readString();
                return new Datable(key, data);
            }
            return null;
        }

        @Override
        public Datable createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Datable[] newArray(int size) {
            return new Datable[size];
        }
    };

    private static final String
            MODEL = "model",
            MODELS = "models",
            MODEL_LIST = "modelList",
            SIZE = "size",
            VIEW_TYPE = "viewType";

    private final Bundle data;
    private final String key;

    /*==============================================================================================
    PUBLIC CONSTRUCTORS
    ==============================================================================================*/

    public Datable(ArrayList<Model> modelList){
        this(MODEL_LIST, new Bundle());
        int size = modelList.size();
        putInt(SIZE, size);
        for (int i = 0; i < size; i++){
            Datable datable = new Datable(modelList.get(i));
            putParcelable(MODEL + i, datable);
        }
    }

    public Datable(Model[] models){
        this(MODELS, new Bundle());
        int size = models.length;
        putInt(SIZE, size);
        for (int i = 0; i < size; i++){
            Datable datable = new Datable(models[i]);
            putParcelable(MODEL + i, datable);
        }
    }

    public Datable(Model model){
        this(MODEL, new Bundle());
        model.saveToData(this);
    }

    /*==============================================================================================
    PRIVATE CONSTRUCTOR
    ==============================================================================================*/

    private Datable(String key, Bundle data){
        this.data = data;
        this.key = key;
    }

    /*==============================================================================================
    PUBLIC METHODS
    ==============================================================================================*/

    // PUT METHODS

    public void putModel(String key, Model model){
        Datable datable = new Datable(model);
        putParcelable(key, datable);
    }

    public void putModels(String key, Model[] models){
        Datable datable = new Datable(models);
        putParcelable(key, datable);
    }

    public void putModelList(String key, ArrayList<Model> modelList){
        Datable datable = new Datable(modelList);
        putParcelable(key, datable);
    }

    public void putBinder(String key, IBinder value){
        data.putBinder(this.key + key, value);
    }

    public void putBoolean(String key, boolean value){
        data.putBoolean(this.key + key, value);
    }

    public void putBooleanArray(String key, boolean[] value){
        data.putBooleanArray(this.key + key, value);
    }

    public void putBundle(String key, Bundle value){
        data.putBundle(this.key + key, value);
    }

    public void putByte(String key, byte value){
        data.putByte(this.key + key, value);
    }

    public void putByteArray(String key, byte[] value){
        data.putByteArray(this.key + key, value);
    }

    public void putChar(String key, char value){
        data.putChar(this.key + key, value);
    }

    public void putCharArray(String key, char[] value){
        data.putCharArray(this.key + key, value);
    }

    public void putCharSequence(String key, CharSequence value){
        data.putCharSequence(this.key + key, value);
    }

    public void putCharSequenceArray(String key, CharSequence[] value){
        data.putCharSequenceArray(this.key + key, value);
    }

    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value){
        data.putCharSequenceArrayList(this.key + key, value);
    }

    public void putDouble(String key, double value){
        data.putDouble(this.key + key, value);
    }

    public void putDoubleArray(String key, double[] value){
        data.putDoubleArray(this.key + key, value);
    }

    public void putFloat(String key, float value){
        data.putFloat(this.key + key, value);
    }

    public void putFloatArray(String key, float[] value){
        data.putFloatArray(this.key + key, value);
    }

    public void putInt(String key, int value){
        data.putInt(this.key + key, value);
    }

    public void putIntArray(String key, int[] value){
        data.putIntArray(this.key + key, value);
    }

    public void putIntegerArrayList(String key, ArrayList<Integer> value){
        data.putIntegerArrayList(this.key + key, value);
    }

    public void putLong(String key, long value){
        data.putLong(this.key + key, value);
    }

    public void putLongArray(String key, long[] value){
        data.putLongArray(this.key + key, value);
    }

    public void putParcelable(String key, Parcelable value){
        data.putParcelable(this.key + key, value);
    }

    public void putParcelableArray(String key, Parcelable[] value){
        data.putParcelableArray(this.key + key, value);
    }

    public void putParcelableArrayList(String key, ArrayList<? extends Parcelable> value){
        data.putParcelableArrayList(this.key + key, value);
    }

    public void putShort(String key, short value){
        data.putShort(this.key + key, value);
    }

    public void putShortArray(String key, short[] value){
        data.putShortArray(this.key + key, value);
    }

    public void putString(String key, String value){
        data.putString(this.key + key, value);
    }

    public void putStringArray(String key, String[] value){
        data.putStringArray(this.key + key, value);
    }

    public void putStringArrayList(String key, ArrayList<String> value){
        data.putStringArrayList(this.key + key, value);
    }

    // GET METHODS

    public Model getModel(String key, DatableIterationListener listener){
        Datable d = getParcelable(key);
        return listener.onDatableIteration(d);
    }

    public Model[] getModels(DatableIterationListener listener){
        int size = getInt(SIZE);
        Model[] models = new Model[size];
        for (int i = 0; i < size; i++){
            Datable datable = getParcelable(MODEL + i);
            Model model = listener.onDatableIteration(datable);
            models[i] = model;
        }
        return models;
    }

    public Model[] getModels(String key, DatableIterationListener listener){
        Datable datable = getParcelable(key);
        int size = datable.getInt(SIZE);
        Model[] models = new Model[size];
        for (int i = 0; i < size; i++){
            Datable d = datable.getParcelable(MODEL + i);
            Model model = listener.onDatableIteration(d);
            models[i] = model;
        }
        return models;
    }

    public ArrayList<Model> getModelList(DatableIterationListener listener){
        int size = getInt(SIZE);
        ArrayList<Model> modelList = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            Datable datable = getParcelable(MODEL + i);
            Model model = listener.onDatableIteration(datable);
            modelList.add(i, model);
        }
        return modelList;
    }

    public ArrayList<Model> getModelList(String key, DatableIterationListener listener){
        Datable datable = getParcelable(key);
        int size = datable.getInt(SIZE);
        ArrayList<Model> modelList = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            Datable d = datable.getParcelable(MODEL + i);
            Model model = listener.onDatableIteration(d);
            modelList.add(i, model);
        }
        return modelList;
    }

    public IBinder getBinder(String key){
        return data.getBinder(this.key + key);
    }

    public boolean getBoolean(String key){
        return data.getBoolean(this.key + key);
    }

    public boolean[] getBooleanArray(String key){
        return data.getBooleanArray(this.key + key);
    }

    public Bundle getBundle(String key){
        return data.getBundle(this.key + key);
    }

    public byte getByte(String key){
        return data.getByte(this.key + key);
    }

    public byte[] getByteArray(String key){
        return data.getByteArray(this.key + key);
    }

    public char getChar(String key){
        return data.getChar(this.key + key);
    }

    public char[] getCharArray(String key){
        return data.getCharArray(this.key + key);
    }

    public CharSequence getCharSequence(String key){
        return data.getCharSequence(this.key + key);
    }

    public CharSequence[] getCharSequenceArray(String key){
        return data.getCharSequenceArray(this.key + key);
    }

    public ArrayList<CharSequence> getCharSequenceArrayList(String key){
        return data.getCharSequenceArrayList(this.key + key);
    }

    public double getDouble(String key){
        return data.getDouble(this.key + key);
    }

    public double[] getDoubleArray(String key){
        return data.getDoubleArray(this.key + key);
    }

    public float getFloat(String key){
        return data.getFloat(this.key + key);
    }

    public float[] getFloatArray(String key){
        return data.getFloatArray(this.key + key);
    }

    public int getInt(String key){
        return data.getInt(this.key + key);
    }

    public int[] getIntArray(String key){
        return data.getIntArray(this.key + key);
    }

    public ArrayList<Integer> getIntegerArrayList(String key){
        return data.getIntegerArrayList(this.key + key);
    }

    public long getLong(String key){
        return data.getLong(this.key + key);
    }

    public long[] getLongArray(String key){
        return data.getLongArray(this.key + key);
    }

    public <T> T getParcelable(String key, Class<? extends T> clazz){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return data.getParcelable(this.key + key, clazz);
        }
        return null;
    }

    public <T extends Parcelable> T getParcelable(String key){
        return data.getParcelable(this.key + key);
    }

    public <T> T[] getParcelableArray(String key, Class<? extends T> clazz){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return data.getParcelableArray(this.key + key, clazz);
        }
        return null;
    }

    public Parcelable[] getParcelableArray(String key){
        return data.getParcelableArray(this.key + key);
    }

    public <T> ArrayList<T> getParcelableArrayList(String key, Class<? extends T> clazz){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return data.getParcelableArrayList(this.key + key, clazz);
        }
        return null;
    }

    public <T extends Parcelable>ArrayList<T> getParcelableArrayList(String key){
        return data.getParcelableArrayList(this.key + key);
    }

    public short getShort(String key){
        return data.getShort(this.key + key);
    }

    public short[] getShortArray(String key){
        return data.getShortArray(this.key + key);
    }

    public String getString(String key){
        return data.getString(this.key + key);
    }

    public String[] getStringArray(String key){
        return data.getStringArray(this.key + key);
    }

    public ArrayList<String> getStringArrayList(String key){
        return data.getStringArrayList(this.key + key);
    }

    public Bundle getData() {
        return data;
    }

    public String getKey() {
        return key;
    }

    /**
     * Esta función es requerida para reconstruir los models que puedan ser de diferente tipo
     * @return el viewType del model.
     */
    public int getViewType(){
        return getInt(VIEW_TYPE);
    }

    /*==============================================================================================
    PUBLIC OVERRIDE METHODS
    ==============================================================================================*/

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(data);
        dest.writeString(key);
    }
}
