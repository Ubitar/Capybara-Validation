package com.ubitar.validator.result;


import com.ubitar.validator.reason.IReason;

import java.util.ArrayList;
import java.util.List;

public class CResult<Raw> implements IResult<Raw> {

    private Raw raw;

    private List<IReason> reasons = new ArrayList<>();

    public CResult(Raw raw){
        this.raw=raw;
    }

    @Override
    public Raw getRaw() {
        return raw;
    }

    @Override
    public boolean hasError() {
        return reasons.size() <= 0;
    }

    @Override
    public IReason getReasonAtFirst() {
        if (reasons.size() > 0) return reasons.get(0);
        else return null;
    }

    @Override
    public List<IReason> getAllReason() {
        if (reasons.size() > 0) return reasons;
        else return new ArrayList<>(1);
    }

    public void addReason(IReason reason) {
        reasons.add(reason);
    }
}
