package com.mtrilogic.interfaces;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

public interface RestorableModelListener {

    @NonNull
    Model restoreModel(@NonNull Bundle data);
}
