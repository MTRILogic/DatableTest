package com.mtrilogic.interfaces;

import androidx.annotation.NonNull;

import com.mtrilogic.classes.Datable;

public interface Restorable extends Savable{

    void restoreFromData(@NonNull Datable datable);
}
