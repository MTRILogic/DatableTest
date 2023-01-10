package com.mtrilogic.abstracts;

import android.os.Bundle;

import androidx.annotation.NonNull;

@SuppressWarnings("unused")
public abstract class Model {

    private static final String
            ITEM_ID = "itemId",
            VIEW_TYPE = "viewType",
            ENABLED = "enabled";

    private long itemId;
    private int viewType;
    private boolean enabled;

    public Model(){}

    public Model(long itemId, int viewType, boolean enabled){
        this.itemId = itemId;
        this.viewType = viewType;
        this.enabled = enabled;
    }

    public Model(Bundle data){
        if (data != null){
            restoreFromData(data);
        }
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    protected void restoreFromData(@NonNull Bundle data) {
        itemId = data.getLong(ITEM_ID);
        viewType = data.getInt(VIEW_TYPE);
        enabled = data.getBoolean(ENABLED);
    }

    public void saveToData(@NonNull Bundle data) {
        data.putLong(ITEM_ID, itemId);
        data.putInt(VIEW_TYPE, viewType);
        data.putBoolean(ENABLED, enabled);
    }
}
