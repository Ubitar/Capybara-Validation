package com.ubitar.validator.result;


import androidx.annotation.NonNull;

import com.ubitar.validator.reason.IReason;

import java.util.ArrayList;
import java.util.List;

public class CResult<Raw> implements IResult<Raw> {

    private Raw raw;

    private List<IReason> reasons = new ArrayList<>();

    public CResult(@NonNull Raw raw){
        this.raw=raw;
    }

    @NonNull
    @Override
    public Raw getRaw() {
        return raw;
    }

    @Override
    public boolean hasError() {
        return reasons.size() > 0;
    }

    @NonNull
    @Override
    public IReason getReasonAtFirst() {
        if (reasons.size() > 0) return reasons.get(0);
        else return null;
    }

    @NonNull
    @Override
    public List<IReason> getAllReason() {
        if (reasons.size() > 0) return reasons;
        else return new ArrayList<>(1);
    }

    public void addReason(@NonNull  IReason reason) {
        reasons.add(reason);
    }
}
