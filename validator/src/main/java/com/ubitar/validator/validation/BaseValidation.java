package com.ubitar.validator.validation;

import android.content.Context;

import com.ubitar.validator.provider.AppProvider;

public  abstract  class BaseValidation<Raw> implements IValidation<Raw> {
    private Raw raw;

    public BaseValidation(Raw raw){
        this.raw=raw;
    }

    @Override
    public Raw getRaw() {
        return raw;
    }

    public Context getContext(){
        return AppProvider.getInstance().getContext();
    }
}
