package com.ubitar.validator.reason;

import androidx.annotation.NonNull;

import com.ubitar.validator.rule.base.IRule;

public class CReason implements IReason {

    private String message;
    private IRule rule;

    public CReason(String message,@NonNull IRule rule) {
        this.message = message;
        this.rule = rule;
    }

    @NonNull
    @Override
    public String getMessage() {
        return message;
    }

    @NonNull
    @Override
    public IRule getRule() {
        return rule;
    }
}
