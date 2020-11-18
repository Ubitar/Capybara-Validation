package com.ubitar.validator.reason;

import com.ubitar.validator.rule.base.IRule;

public interface IReason {
    String getMessage();

    IRule getRule();
}
