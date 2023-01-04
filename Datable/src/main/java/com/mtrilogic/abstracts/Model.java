package com.mtrilogic.abstracts;

import androidx.annotation.NonNull;

import com.mtrilogic.classes.Datable;
import com.mtrilogic.interfaces.Restorable;

@SuppressWarnings("unused")
public abstract class Model implements Restorable {

    private static final String ITEM_ID = "itemId", VIEW_TYPE = "viewType", ENABLED = "enabled";

    private long itemId;
    private int viewType;
    private boolean enabled;

    public Model(){}

    public Model(long itemId, int viewType, boolean enabled){
        this.itemId = itemId;
        this.viewType = viewType;
        this.enabled = enabled;
    }

    public Model(@NonNull Datable datable){
        restoreFromData(datable);
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

    @Override
    public void restoreFromData(@NonNull Datable datable) {
        itemId = datable.getLong(ITEM_ID);
        viewType = datable.getInt(VIEW_TYPE);
        enabled = datable.getBoolean(ENABLED);
    }

    @Override
    public void saveToData(@NonNull Datable datable) {
        datable.putLong(ITEM_ID, itemId);
        datable.putInt(VIEW_TYPE, viewType);
        datable.putBoolean(ENABLED, enabled);
    }
}
