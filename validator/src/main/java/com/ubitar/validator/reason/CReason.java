package com.ubitar.validator.reason;

import com.ubitar.validator.rule.base.IRule;

public class CReason implements IReason {

    private String message;
    private IRule rule;

    public CReason(String message, IRule rule) {
        this.message = message;
        this.rule = rule;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IRule getRule() {
        return rule;
    }
}
