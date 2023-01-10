package com.mtrilogic.interfaces;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.mtrilogic.abstracts.Model;

public interface DataIterationListener {

    @NonNull
    Model onDataIteration(Bundle data);
}
