package com.mtrilogic.interfaces;

import androidx.annotation.NonNull;

import com.mtrilogic.classes.Datable;

public interface Savable {

    void saveToData(@NonNull Datable datable);
}
