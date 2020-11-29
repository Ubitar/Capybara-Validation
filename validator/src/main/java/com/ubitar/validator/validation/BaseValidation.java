package com.ubitar.validator.validation;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ubitar.validator.provider.AppProvider;

public  abstract  class BaseValidation<Raw> implements IValidation<Raw> {
    private Raw raw;

    public BaseValidation(@NonNull Raw raw){
        this.raw=raw;
    }

    @NonNull
    @Override
    public Raw getRaw() {
        return raw;
    }

    @NonNull
    public Context getContext(){
        return AppProvider.getInstance().getContext();
    }
}
